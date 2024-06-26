package hust.soict.dsai.aims;

import javax.swing.JOptionPane;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.screen.manager.StoreManagerScreen;


public class Aims {
    public static void main(String[] args) {
        try {
            Store store = new Store();

            DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation",
                    "Roger Allers", 87, 19.95f);
            store.addMedia(dvd1);

            DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction",
                    "George Lucas", 87, 19.95f);
            store.addMedia(dvd2);

            DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation",
                    18.99f);
            store.addMedia(dvd3);

            DigitalVideoDisc dvd4 = new DigitalVideoDisc("Iron Man","Science Fiction", 20.89f);
            store.addMedia(dvd4);

            @SuppressWarnings("unused")
            Cart cart = new Cart();

            new StoreManagerScreen(store);

            try {
                dvd1.play();
                dvd2.play();
                dvd3.play();
            } catch (PlayerException e) {
                JOptionPane.showMessageDialog(null, e.getMessage(), "Illegal DVD Length", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}