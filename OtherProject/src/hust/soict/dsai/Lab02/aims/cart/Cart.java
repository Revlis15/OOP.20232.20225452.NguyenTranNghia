package hust.soict.dsai.Lab02.aims.cart;

import hust.soict.dsai.Lab02.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered;

	public int getQtyOrdered(){
        return this.qtyOrdered;
    }
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered > MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full !!!");			
		}
		else if (qtyOrdered < 19 && qtyOrdered >= 15) {
			System.out.printf("The disc %s has been added.\n",disc.getTitle());
			itemOrdered[qtyOrdered] = disc;
			System.out.println("The cart is almost full.");
			qtyOrdered++;
			System.out.println("There are currently " + qtyOrdered +" disc");
		}
		else if (qtyOrdered == 19) {
			System.out.printf("The disc %s has been added.\n",disc.getTitle());
			itemOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("The cart is full !!!");	
		}
		else {
			System.out.printf("The disc %s has been added.\n",disc.getTitle());
			itemOrdered[qtyOrdered] = disc;
			qtyOrdered++;
			System.out.println("There are currently " + qtyOrdered +" disc.");
		}
	}

	public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList){
		int sum = qtyOrdered + dvdList.length;
		if (qtyOrdered > MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full !!!");			
		}
		else if(sum > MAX_NUMBERS_ORDERED) {
			System.out.println("There aren't enough space in the cart, please remove some disc to add more !!!");		
			System.out.println("There are currently " + qtyOrdered +" disc");
		}
		else {
			for (int i = 0; i < dvdList.length; i++) {
				System.out.printf("The disc %s has been added.\n",dvdList[i].getTitle());
				itemOrdered[qtyOrdered] = dvdList[i];
				qtyOrdered++;
				System.out.println("There are currently " + qtyOrdered +" disc.");
			}
		}
	}

	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
		int sum = qtyOrdered + 2;
		if (qtyOrdered > MAX_NUMBERS_ORDERED) {
			System.out.println("The cart is full !!!");			
		}
		else if(sum > MAX_NUMBERS_ORDERED) {
			System.out.println("There aren't enough space in the cart, please remove some disc to add more !!!");		
			System.out.println("There are currently " + qtyOrdered +" disc");
		}
		else {
			System.out.printf("The disc %s has been added.\n",dvd1.getTitle());
			itemOrdered[qtyOrdered] = dvd1;
			System.out.printf("The disc %s has been added.\n",dvd2.getTitle());
			itemOrdered[qtyOrdered+1] = dvd2;
			qtyOrdered += 2;
			System.out.println("There are currently " + qtyOrdered +" disc.");
		}
	}
	
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered == 0) {
			System.out.println("The cart is empty !!!");
		}
		else {
			for (int i = 0; i <  qtyOrdered; i++) {
				if (itemOrdered[i] == disc) {
					System.out.printf("The disc %s has been removed.\n",disc.getTitle());
					itemOrdered[i] = itemOrdered[qtyOrdered-1];
					itemOrdered[qtyOrdered-1] = null;
					qtyOrdered--;
					System.out.println("There are " + qtyOrdered + " disc left.");
					break;
				}
				else if (i == qtyOrdered-1) {
					System.out.printf("The disc %s is not in the cart.\n",disc.getTitle());
				}
			}
		}
	}

	public float totalCost(){
		float total = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemOrdered[i] != null) {
				total += itemOrdered[i].getCost();
			}
		}
		return total;
	}

	public void displayCart(){
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemOrdered[i] != null) {
				int num = i+1;
				System.out.printf("%d. The disc %s has the cost: %.2f. \n", num, itemOrdered[i].getTitle(), itemOrdered[i].getCost());
			}
		}
		System.out.println("The total cost is: " + totalCost());
	}
	public void print() {
		System.out.println("******************************CART******************************");
		System.out.println("Ordered Items:");
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemOrdered[i] != null) {
				int num = i+1;
				System.out.printf("%d."+itemOrdered[i]+"\n",num);
			}
		}
		System.out.println("Total cost: "+totalCost());
		System.out.println("****************************************************************");

	}
	public int isMatch(String title) {
		String[] words = title.split(" ");
		int match = -1;
		for (int j=0; j<words.length; j++) {
			for (int i=0; i<qtyOrdered; i++) {
				if (itemOrdered[i].search(words[j])) {
					match = i;
					break;
				}
			}
		}
		return match;
	}
	public int isMatch(int id) {
		int match = -1;
		for (int i=0; i<qtyOrdered; i++) {
			if (itemOrdered[i].search(id)) {
				match = i;
				break;
			}
		}
		return match;	
	}
	
	public void search(String title) {
		if (isMatch(title) != -1) {
			System.out.println("Found a match: " + itemOrdered[isMatch(title)].getTitle());
		} else {
			System.out.println("No match found! Try again.");
		}
	}
	
	public void search(int id) {
		if (isMatch(id) != -1) {
			System.out.println("Found a match: " + itemOrdered[isMatch(id)].getTitle());
		} else {
			System.out.println("No match found! Try again.");
		}
	}
}
