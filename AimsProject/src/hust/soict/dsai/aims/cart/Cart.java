package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Arrays;

import javax.naming.LimitExceededException;

public class Cart {
    public int qtyOrdered = 0;

    private static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public Float totalCost() {
        Float total = (float) 0;
        for (Media item : this.itemsOrdered) {
            total += item.getCost();
        }
        return total;
    }

    public void displayItemsOrdered() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (Media m : this.itemsOrdered) {
            System.out.println(m);
        }
        System.out.println("Total cost: "+totalCost()+"$");
        System.out.println("***************************************************");
    }

    public void addMedia(Media media) throws LimitExceededException {
    	if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
	        itemsOrdered.add(media);
	        this.qtyOrdered++;
	        System.out.println("The media has been added.");
    	}
    	else {
    		throw new LimitExceededException("ERROR: The number of media has reached its limit.");
    	}
    }

    public void addMedia(Media m1, Media m2) throws LimitExceededException {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            if (this.qtyOrdered + 2 > MAX_NUMBERS_ORDERED) {
            	System.out.println("There is not enough space available");
            	return;
            } else {
            	this.itemsOrdered.add(m1);
                this.itemsOrdered.add(m2);
                this.qtyOrdered += 2;
                System.out.println("The medias have been added.");
            }
        }
        else {
    		throw new LimitExceededException("ERROR: The number of media has reached its limit.");
    	}
    }

    public void addMedia(Media... medias) throws LimitExceededException {
    	if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
	        if (medias.length + this.qtyOrdered > MAX_NUMBERS_ORDERED) {
	            System.out.println("There is not enough space available");
	            return;
	        } else {
		        this.itemsOrdered.addAll(Arrays.asList(medias));
		        this.qtyOrdered += medias.length;
		        System.out.println("The media(s) has(have) been added.");
		    }
    	}
    	else {
    		throw new LimitExceededException("ERROR: The number of media has reached its limit.");
    	}
    }
    
    public void removeMedia(Media media) throws IllegalArgumentException {
        boolean isRemoved = this.itemsOrdered.remove(media);
        if (isRemoved) {
            System.out.println("The media has been removed.");
            this.qtyOrdered--;
        } else {
            throw new IllegalArgumentException("Cannot find the specified media in the cart.");
        }
    }

    public void searchMedia(int id) {
        for (Media media : this.itemsOrdered) {
            if (media.getId() == id) {
                System.out.println("Searching result: "+media);
                return;
            }
        }
        System.out.println("No match is found.");
    }

    public void searchMedia(String title) {
        for (Media media : this.itemsOrdered) {
            if (media.isMatch(title)) {
                System.out.println("Searching result: "+media);
                return;
            }
        }
        System.out.println("No match is found.");
    }

    public void playMedia(String title) throws PlayerException {
        for (Media m : this.itemsOrdered) {
            if (m.getTitle().equals(title)) {
                if (Playable.class.isAssignableFrom(m.getClass())) {
                    ((Playable) m).play();
                }
            }
        }
    }
}
