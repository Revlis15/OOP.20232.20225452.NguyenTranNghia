package hust.soict.dsai.aims.screen.manager;


import hust.soict.dsai.aims.store.Store;

import javax.swing.JOptionPane;

import hust.soict.dsai.aims.media.*;

@SuppressWarnings("serial")
public class AddDVDScreen extends AddItemToStoreScreen{

    public AddDVDScreen(Store store) {
        super(store);
        setTitle("Add DVD");

        super.viewStoreItem.addActionListener(e -> {
                new StoreManagerScreen(store).setVisible(true);
                AddDVDScreen.this.setVisible(false);
        });

        super.addBookItem.addActionListener(e -> {
                new AddBookScreen(store).setVisible(true);
                AddDVDScreen.this.setVisible(false);
        });

        super.addCDItem.addActionListener(e -> {
                new AddCDScreen(store).setVisible(true);
                AddDVDScreen.this.setVisible(false);
        });

        super.submitButton.addActionListener(e -> {
            String title = titleField.getText();
            String category = categoryField.getText();
            String costText = costField.getText();
            String director = directorField.getText();
            if (title.isEmpty() || category.isEmpty() || costText.isEmpty() || director.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields must be filled out.");
            } else {
                float cost = Float.parseFloat(costText);
                DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, cost);
                if (store.dvdExists(dvd)) {
                    JOptionPane.showMessageDialog(this, "This DVD already exists in the store.");
                } else {
                    store.addMedia(dvd);
                    titleField.setText("");
                    categoryField.setText("");
                    costField.setText("");
                    directorField.setText("");
                }
            }
        });
    }

}
