package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.Iterator;

import hust.soict.dsai.aims.exception.PlayerException;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks = new ArrayList<>();

    public String getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return id + ". Compact Disc - " + title + " - " + category + " - " + director + " - " + artist + " - " + length + ": " + cost + "$";
    }

    public CompactDisc(String title, String artist, ArrayList<Track> tracks) {
        super(title);
        this.artist = artist;
        this.tracks = tracks;
        int tmp = 0;
        for (Track track : this.tracks) {
            tmp += track.getLength();
        }
        this.length = tmp;
    }

    public CompactDisc(String title, String category, Float cost, String artist, ArrayList<Track> tracks) {
        super(title, category, cost);
        this.artist = artist;
        this.tracks = tracks;
        int tmp = 0;
        for (Track track : this.tracks) {
            tmp += track.getLength();
        }
        this.length = tmp;
    }

    public CompactDisc(String title, String category, Float cost, String director, String artist, ArrayList<Track> tracks) {
        super(title, category, cost, director);
        this.artist = artist;
        this.tracks = tracks;
        int tmp = 0;
        for (Track track : this.tracks) {
            tmp += track.getLength();
        }
        this.length = tmp;
    }

    public void addTrack(Track track) throws PlayerException {
        if (this.tracks.contains(track)) {
            throw new PlayerException("The track " + track + " is already in tracks' list.");
        }
        this.tracks.add(track);
        this.length += track.getLength();
        System.out.println("The track " + track + " is successfully added.");
    }

    public void removeTrack(Track track) throws PlayerException {
        boolean isRemove = this.tracks.remove(track);
        if (isRemove) {
            System.out.println("The track " + track + " is successfully removed.");
            this.length -= track.getLength();
        } else {
            throw new PlayerException("There aren't any " + track + " in tracks' list.");
        }
    }

    public int getLength() {
        return this.length;
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
        	System.out.println("Playing "+this.artist+"'s compact disc.");
            System.out.println("Compact disc length: "+this.length);
            for (int i = 0; i < this.tracks.size(); i++) {
                System.out.print((i+1)+". ");
                this.tracks.get(i).play();
            }
            Iterator<Track> iter = tracks.iterator();
            Track nextTrack;
            while (iter.hasNext()) {
                nextTrack = (Track) iter.next();
                try {
                	nextTrack.play();
                } catch (PlayerException e) {
                	throw e;
                }
            }
        } else {
        	throw new PlayerException("ERROR: CD length is non-negative");
        }
  
    }

}
