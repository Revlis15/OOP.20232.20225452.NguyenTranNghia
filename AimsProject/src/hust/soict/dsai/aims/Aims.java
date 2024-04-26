package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Media;

import javax.naming.LimitExceededException;
import java.util.*;

public class Aims {
    public static void main(String[] args) {
        //Setup store
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

        //Setup cart
        Cart cart = new Cart();

        //Setup scanner
        Scanner user = new Scanner(System.in);

        //Drive code
        program:
        while (true) {
            showMenu();
            int menuOption = Integer.parseInt(user.nextLine());

            //exit
            while (menuOption == 0) {
                break program;
            }

            //view store
            store:
            while (menuOption == 1) {
                store.displayMedia();
                //store menu
                storeMenu();
                int storeOption = Integer.parseInt(user.nextLine());

                while (storeOption == 0) {
                    //back to main menu
                    break store;
                }

                while (storeOption == 1) {
                    System.out.print("Enter title: ");
                    String title = user.nextLine();
                    Media dvd = store.getMedia(title);
                    //check validity and print details
                    if (dvd == null) {
                        System.out.println("Invalid title.");
                    } else {
                        System.out.println("Media's detail: " + dvd);
                    }
                    //add option
                    while (dvd != null) {
                        System.out.print("Add that media to your cart? (Y/N): ");
                        String addOption = user.nextLine();
                        if (addOption.equals("Y")) {
                            cart.addMedia(dvd);
                            break;
                        } else if (addOption.equals("N")) {
                            break;
                        } else {
                            System.out.println("Invalid input.");
                        }
                    }
                    //back to store menu
                    break;
                }

                while (storeOption == 2) {
                    System.out.print("Enter title: ");
                    String title = user.nextLine();
                    Media dvd = store.getMedia(title);
                    //check validity and print details
                    if (dvd == null) {
                        System.out.println("Invalid title.");
                    } else {
                        cart.addMedia(dvd);
                    }
                    //back to store menu
                    break;
                }

                cart:
                while (storeOption == 3) {
                    cart.displayItemsOrdered();
                    cartMenu();
                    int cartOption = Integer.parseInt(user.nextLine());

                    while (cartOption == 0) {
                        //back to main menu
                        break cart;
                    }

                    filter:
                    while (cartOption == 1) {
                        filterCartMenu();
                        int filterOption = Integer.parseInt(user.nextLine());

                        if (filterOption == 0) {
                            //back to cart menu
                            break filter;
                        } else if (filterOption == 1) {
                            System.out.print("Enter ID: ");
                            int id = user.nextInt();
                            cart.searchMedia(id);
                            //back to filter menu
                        } else if (filterOption == 2) {
                            System.out.print("Enter title: ");
                            user.nextLine(); //consume blank
                            String title = user.nextLine();
                            cart.searchMedia(title);
                            //back to filter menu
                        }
                    }

                    sort:
                    while (cartOption == 2) {
                        sortCartMenu();
                        int sortOption = Integer.parseInt(user.nextLine());

                        if (sortOption == 0) {
                            //back to cart menu
                            break sort;
                        } else if (sortOption == 1) {
                            Collections.sort(cart.getItemsOrdered(), new MediaComparatorByTitleCost());
                            cart.displayItemsOrdered();
                            //back to sort menu
                        } else if (sortOption == 2) {
                            Collections.sort(cart.getItemsOrdered(), new MediaComparatorByCostTitle());
                            cart.displayItemsOrdered();
                            //back to sort menu
                        }
                    }

                    while (cartOption == 3) {
                        System.out.print("Enter title: ");
                        String title = user.nextLine();
                        ArrayList<Media> cartTmp = cart.getItemsOrdered();
                        for (Media m : cartTmp) {
                            if (m.getTitle().equals(title)) {
                                cart.removeMedia(m);
                            }
                        }
                        System.out.println("The number of medias in the cart: " + cart.getItemsOrdered().size());
                        break;
                    }

                    //place order
                    while (cartOption == 4) {
                        System.out.println("An order is created.");
                        cart.getItemsOrdered().clear();
                        //back to cart menu
                        break;
                    }

                    while (cartOption == 5) {
                        System.out.print("Enter title: ");
                        String title = user.nextLine();
                        cart.playMedia(title);
                        //back to cart menu
                        break;
                    }
                }

                while (storeOption == 4) {
                    System.out.print("Enter title: ");
                    String title = user.nextLine();
                    store.playMedia(title);
                    //back to cart menu
                    break;
                }
            }

            update:
            while (menuOption == 2) {
                updateStoreMenu();
                int updateOption = Integer.parseInt(user.nextLine());

                while (updateOption == 0) {
                    //back to main menu
                    break update;
                }

                while (updateOption == 1) {
                    //add DVD
                    System.out.println("Enter the DVD's detail: ");
                    System.out.println("--------------------------------");
                    System.out.print("Title: ");
                    String title = user.nextLine();
                    System.out.print("Category: ");
                    String category = user.nextLine();
                    System.out.print("Cost: ");
                    float cost = Float.parseFloat(user.nextLine());
                    DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, cost);
                    store.addMedia(dvd);
                    //back to update menu
                    break;
                }

                while (updateOption == 2) {
                    //remove DVD
                    System.out.print("Enter title: ");
                    String title = user.nextLine();
                    Media dvd = store.getMedia(title);
                    store.removeMedia(dvd);
                    //back to update menu
                    break;
                }

            }

            cart:
            while (menuOption == 3) {
                cart.displayItemsOrdered();
                cartMenu();
                int cartOption = Integer.parseInt(user.nextLine());

                while (cartOption == 0) {
                    //back to main menu
                    break cart;
                }

                filter:
                while (cartOption == 1) {
                    filterCartMenu();
                    int filterOption = Integer.parseInt(user.nextLine());

                    if (filterOption == 0) {
                        //back to cart menu
                        break filter;
                    } else if (filterOption == 1) {
                        System.out.println("Enter ID: ");
                        int id = Integer.parseInt(user.nextLine());
                        cart.searchMedia(id);
                        //back to filter menu
                    } else if (filterOption == 2) {
                        System.out.print("Enter title: ");
                        user.nextLine(); //consume blank
                        String title = user.nextLine();
                        cart.searchMedia(title);
                        //back to filter menu
                    }
                }

                sort:
                while (cartOption == 2) {
                    sortCartMenu();
                    int sortOption = Integer.parseInt(user.nextLine());

                    if (sortOption == 0) {
                        //back to cart menu
                        break sort;
                    } else if (sortOption == 1) {
                        Collections.sort(cart.getItemsOrdered(), new MediaComparatorByTitleCost());
                        cart.displayItemsOrdered();
                        //back to sort menu
                    } else if (sortOption == 2) {
                        Collections.sort(cart.getItemsOrdered(), new MediaComparatorByCostTitle());
                        cart.displayItemsOrdered();
                        //back to sort menu
                    }
                }

                while (cartOption == 3) {
                    System.out.print("Enter title: ");
                    String title = user.nextLine();
                    ArrayList<Media> cartTmp = cart.getItemsOrdered();
                    for (Media m : cartTmp) {
                        if (m.getTitle().equals(title)) {
                            cart.removeMedia(m);
                        }
                    }
                    System.out.println("The number of medias in the cart: " + cart.getItemsOrdered().size());
                    break;
                }

                //place order
                while (cartOption == 4) {
                    System.out.println("An order is created.");
                    cart.getItemsOrdered().clear();
                    //back to cart menu
                    break;
                }

                while (cartOption == 5) {
                    System.out.println("Enter title: ");
                    String title = user.nextLine();
                    cart.playMedia(title);
                    //back to cart menu
                    break;
                }

            }
            user.close();
        }

    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void updateStoreMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add a media to the store");
        System.out.println("2. Remove a media from the store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void filterCartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias by id");
        System.out.println("2. Filter medias by title");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void sortCartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Sort medias by title");
        System.out.println("2. Sort medias by cost");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

}