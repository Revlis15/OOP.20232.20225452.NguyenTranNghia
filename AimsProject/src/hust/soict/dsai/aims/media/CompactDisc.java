package hust.soict.dsai.aims.media;

import java.util.ArrayList;

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

    public CompactDisc(String title, String category, float cost, String artist, ArrayList<Track> tracks) {
        super(title, category, cost);
        this.artist = artist;
        this.tracks = tracks;
        int tmp = 0;
        for (Track track : this.tracks) {
            tmp += track.getLength();
        }
        this.length = tmp;
    }

    public CompactDisc(String title, String category, float cost, String director, String artist, ArrayList<Track> tracks) {
        super(title, category, cost, director);
        this.artist = artist;
        this.tracks = tracks;
        int tmp = 0;
        for (Track track : this.tracks) {
            tmp += track.getLength();
        }
        this.length = tmp;
    }

    public void addTrack(Track track) {
        if (this.tracks.contains(track)) {
            System.out.println("The track "+track+" has already in tracks' list.");
            return;
        }
        this.tracks.add(track);
        this.length += track.getLength();
        System.out.println("The track "+track+" is successfully added.");
    }

    public void removeTrack(Track track) {
        boolean isRemove = this.tracks.remove(track);
        if (isRemove) {
            System.out.println("The track "+track+" is successfully removed.");
            this.length -= track.getLength();
        } else {
            System.out.println("There aren't any "+track+" in tracks' list.");
        }
    }

    public int getLength() {
        return this.length;
    }

    @Override
    public void play() {
        System.out.println("Playing "+this.artist+"'s compact disc.");
        System.out.println("Compact disc length: "+this.length);
        for (int i = 0; i < this.tracks.size(); i++) {
            System.out.print((i+1)+". ");
            this.tracks.get(i).play();
        }
    }
}
