package soict.dsai.Lab02.src.hust.soict.dsai.aims.store;

import soict.dsai.Lab02.src.hust.soict.dsai.disc.DigitalVideoDisc;

public class Store {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemInStore[]  = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int numOfItems = 0;

    public  int getNumberOfItems() { 
        return numOfItems;
    }
    protected boolean hasSpace(){
        for (int i=0 ;i <itemInStore.length; i++)   
            if(itemInStore[i]==null){   
                return true;
            }                
        return false;               
    }
    protected int getNextEmptySlot(){
        int num = 0;
        for (int i=0 ;i <itemInStore.length; i++)   
            if(itemInStore[i]==null){   
                num = i;
                break;
            }
        return num;               
    }

    public void addItem(DigitalVideoDisc video) {
        if  (video != null && hasSpace()) {
            itemInStore[getNextEmptySlot()] = video;
            numOfItems++;
            System.out.println("The disc "+video.title+"has been added.");
            }
        else if (video != null && !hasSpace()) {
            System.out.println("No Space in Store");
        }
        else{
            System.out.println("Null Value passed to addItem method.");
        }

    }
    
    public void removeItem(DigitalVideoDisc disc) {
        if (disc != null) {
            for (int i = 0; i < itemInStore.length; i++) {
                if (itemInStore[i] == disc) {
                    itemInStore[i] = null;
                    numOfItems--;
                    System.out.println("The disc "+disc.title+" has been removed.");
                    break;
                }
            }
        }
        else {
            System.out.println("Null Value passed to removeItem method.");
        }
    }
    
}
