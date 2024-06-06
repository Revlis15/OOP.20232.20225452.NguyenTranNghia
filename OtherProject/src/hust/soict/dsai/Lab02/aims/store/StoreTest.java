package hust.soict.dsai.Lab02.aims.store;

import hust.soict.dsai.Lab02.aims.disc.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) throws Exception{
        Store store = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King","Animation","Roger Allers", 87, 19.95f);
        store.addItem(dvd1);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas", 87, 24.95f);
		store.addItem(dvd2);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation", 18.99f);
		store.addItem(dvd3);

        
    }
}
