package hust.soict.dsai.aims.media;

import java.util.Objects;

public class Track implements Playable {
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Track - " + title + " - " + length + ".";
    }

    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        //Compare with itself
        if (o == this) {
            return true;
        }
        //Check if o is an instance of Track class
        if (!(o instanceof Track)) {
            return false;
        }
        //Cast o to Track
        Track t = (Track) o;
        //Compare
        return (this.length == t.getLength() && Objects.equals(this.title, t.getTitle()));
    }

    @Override
    public void play() {
        System.out.println("Playing Track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }
}
