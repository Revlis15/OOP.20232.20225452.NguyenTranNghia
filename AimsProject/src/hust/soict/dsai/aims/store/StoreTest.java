package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;

public class StoreTest {
    public static void main(String[] args) {
        ArrayList<Media> itemsInStore = new ArrayList<>();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        itemsInStore.add(dvd1);
        
        Store store = new Store();
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.removeMedia(dvd3);
        store.removeMedia(dvd2);
    }
}
