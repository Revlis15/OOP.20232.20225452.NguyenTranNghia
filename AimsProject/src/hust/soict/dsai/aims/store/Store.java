package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.*;

import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }

    public Media getMedia(String title) {
        for (Media m: this.itemsInStore) {
            if (m.getTitle().equals(title)){
                return m;
            }
        }
        return null;
    }

    public void addMedia(Media media) {
        this.itemsInStore.add(media);
        System.out.println("Media " + media + " is successfully added.");
    }

    public void removeMedia(Media media) {
        boolean is_remove = this.itemsInStore.remove(media);
        if (is_remove) {
            System.out.println("Media " + media + " is successfully removed.");
        } else {
            System.out.println("There aren't any " + media + " in the Store.");
        }
    }

    public void playMedia(String title) {
        for (Media m : this.itemsInStore) {
            if (m.getTitle().equals(title)) {
                if (Playable.class.isAssignableFrom(m.getClass())) {
                    ((Playable) m).play();
                }
            }
        }
    }

    public boolean bookExists(Book book) {
        for (Media media : this.itemsInStore) {
            if (media instanceof Book) {
                Book existingBook = (Book) media;
                if (existingBook.getTitle().equals(book.getTitle()) &&
                    existingBook.getCategory().equals(book.getCategory()) &&
                    existingBook.getCost() == book.getCost() &&
                    existingBook.getAuthors().equals(book.getAuthors())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dvdExists(DigitalVideoDisc dvd) {
        for (Media media : this.itemsInStore) {
            if (media instanceof DigitalVideoDisc) {
                DigitalVideoDisc existingDVD = (DigitalVideoDisc) media;
                if (existingDVD.getTitle().equals(dvd.getTitle()) &&
                    existingDVD.getCategory().equals(dvd.getCategory()) &&
                    existingDVD.getCost() == dvd.getCost() &&
                    existingDVD.getDirector().equals(dvd.getDirector())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean cdExists(CompactDisc cd) {
        for (Media media : this.itemsInStore) {
            if (media instanceof CompactDisc) {
                CompactDisc existingCD = (CompactDisc) media;
                if (existingCD.getTitle().equals(cd.getTitle()) &&
                    existingCD.getCategory().equals(cd.getCategory()) &&
                    existingCD.getCost() == cd.getCost() &&
                    existingCD.getDirector().equals(cd.getDirector()) &&
                    existingCD.getArtist().equals(cd.getArtist())) {
                    return true;
                }
            }
        }
        return false;
    }

    public void displayMedia() {
        System.out.println("***********************STORE***********************");
        for (Media m : this.itemsInStore) {
            System.out.println(m);
        }
        System.out.println("***************************************************");
    }
}
