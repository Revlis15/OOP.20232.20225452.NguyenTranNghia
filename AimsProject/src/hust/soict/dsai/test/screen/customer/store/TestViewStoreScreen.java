package hust.soict.dsai.test.screen.customer.store;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.screen.customer.controller.ViewStoreController;
import hust.soict.dsai.aims.store.Store;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class TestViewStoreScreen extends Application {
	private static Store store;
	private static Cart cart;
	@Override
	public void start(Stage primaryStage) throws Exception {
		final String STORE_FXML_FILE_PATH = "/hust/soict/dsai/aims/screen/customer/view/Store.fxml";
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
		ViewStoreController viewStoreController = new ViewStoreController(store,cart);
		fxmlLoader.setController(viewStoreController);
		Parent root = fxmlLoader.load();
		
		primaryStage.setTitle("Store");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
    }

	public static void main(String[] args) throws LimitExceededException {
        store = new Store();
        cart = new Cart();
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 90, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", "unknown", 110, 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Avenger", "Science Fiction", "unknown", 110, 20.56f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Avenger 2", "Science Fiction", "unknown", 130, 21.56f);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Avenger 3", "Science Fiction", "unknown", 120, 22.56f);
        DigitalVideoDisc dvd7 = new DigitalVideoDisc("Avenger 4", "Science Fiction", "unknown", 122, 23.56f);
        DigitalVideoDisc dvd8 = new DigitalVideoDisc("Spiderman", "Science Fiction", "unknown", 115, 20.56f);
        DigitalVideoDisc dvd9 = new DigitalVideoDisc("Spiderman 2", "Science Fiction", "unknown", 117, 21.56f);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(dvd4);
        store.addMedia(dvd5);
        store.addMedia(dvd6);
        store.addMedia(dvd7);
        store.addMedia(dvd8);
        store.addMedia(dvd9);
        cart.addMedia(dvd1);
        cart.addMedia(dvd3);
        launch(args);
    }
}
