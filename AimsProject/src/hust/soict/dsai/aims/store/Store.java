package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

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

    public void displayMedia() {
        System.out.println("***********************STORE***********************");
        for (Media m : this.itemsInStore) {
            System.out.println(m);
        }
        System.out.println("***************************************************");
    }
}
