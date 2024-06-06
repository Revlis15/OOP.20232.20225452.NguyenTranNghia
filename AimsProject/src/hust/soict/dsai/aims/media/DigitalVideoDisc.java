package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable{
    private String director;
    private int length;

    @Override
    public String toString() {
        return id + ". DVD - " + title + " - " + category + " - " + director + " - " + length + ": " + cost + "$";
    }

    public DigitalVideoDisc(String title) {
        super(title);
    }

    public DigitalVideoDisc(String title, String category, Float cost) {
        super(title, category, cost);
    }

    public DigitalVideoDisc(String title, String category, String director, Float cost) {
        super(title, category, cost, director);
    }

    public DigitalVideoDisc(String title, String category, String director, int length, Float cost) {
        super(title, category, cost, length, director);
    }

    @Override
    public void play() throws PlayerException {
        if (this.getLength() <= 0) {
            throw new PlayerException("ERROR: CD length is non-negative");
        }
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }
}
