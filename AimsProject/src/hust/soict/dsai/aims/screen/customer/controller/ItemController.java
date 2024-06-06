package hust.soict.dsai.aims.screen.customer.controller;

import javax.naming.LimitExceededException;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class ItemController {

	@FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

    @FXML
    private Label lblTitle;

    @FXML
    private Label lblCost;
    
    @SuppressWarnings("unused")
	private Cart cart;
    private Media media;
    public ItemController(Cart cart) {
        this.cart = cart;
    }
    
    @SuppressWarnings("unused")
    public void setData(Media media) {
    	this.media = media;
        this.lblTitle.setText(media.getTitle());
        this.lblCost.setText(String.valueOf(media.getCost()) + 	" $");
        if (media instanceof Playable) {
        	btnPlay.setVisible(true);
        }
        else {
            btnPlay.setVisible(false);
            HBox.setMargin(btnAddToCart,new Insets(0,0,0,60));
        }
    }

    @FXML
    void btnAddToCartClicked(ActionEvent event) throws LimitExceededException {
        cart.addMedia(media);
    }

    @FXML
    void btnPlayClicked(ActionEvent event) throws PlayerException {
        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        }
    }
}
