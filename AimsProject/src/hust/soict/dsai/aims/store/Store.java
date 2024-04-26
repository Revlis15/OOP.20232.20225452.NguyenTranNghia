package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<>();

    public Store(ArrayList<Media> itemsInStore) {
        this.itemsInStore = itemsInStore;
    }

    public void addMedia(Media media) {
        this.itemsInStore.add(media);
        System.out.println("Media "+media+" is successfully added.");
    }

    public void removeMedia(Media media) {
        boolean is_remove = this.itemsInStore.remove(media);
        if (is_remove) {
            System.out.println("Media "+media+" is successfully removed.");
        } else {
            System.out.println("There aren't any "+media+" in the Store.");
        }
    }
}
