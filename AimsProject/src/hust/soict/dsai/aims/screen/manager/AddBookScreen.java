package hust.soict.dsai.aims.screen.manager;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.*;

@SuppressWarnings("serial")
public class AddBookScreen extends AddItemToStoreScreen{
    public JTextField authorField;

    public AddBookScreen(Store store) {
        super(store);
        setTitle("Add Book");

        super.viewStoreItem.addActionListener(e -> {
            new StoreManagerScreen(store).setVisible(true);
            AddBookScreen.this.setVisible(false);
        });

        super.addCDItem.addActionListener(e ->{
            new AddCDScreen(store).setVisible(true);
            AddBookScreen.this.setVisible(false);
        });

        super.addDVDItem.addActionListener(e ->{
            new AddDVDScreen(store).setVisible(true);
            AddBookScreen.this.setVisible(false);
        });

        super.submitButton.addActionListener(e ->{
            String title = titleField.getText();
            String category = categoryField.getText();
            String costText = costField.getText();
            String authorText = authorField.getText();
        
            if (title.isEmpty() || category.isEmpty() || costText.isEmpty() || authorText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields must be filled out.");
            } else {
                float cost = Float.parseFloat(costText);
                String[] list = authorText.split(",");
                List<String> authors = Arrays.asList(list);
                Book book = new Book(title, category, cost, authors);
                if (store.bookExists(book)) {
                    JOptionPane.showMessageDialog(this, "This book already exists in the store.");
                } else {
                    store.addMedia(book);
                    titleField.setText("");
                    categoryField.setText("");
                    costField.setText("");
                    authorField.setText("");
                }
            }
        });
    }

    @Override
    JPanel createCenter(){
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(5, 2));
        Font font = new Font("Arial", Font.PLAIN, 35);

        // Create and add the title field
        JLabel title = new JLabel("Title:");
        title.setFont(font);
        center.add(title);
        titleField = new JTextField();
        titleField.setFont(font);
        center.add(titleField);

        // Create and add the category field
        JLabel category = new JLabel("Category:");
        category.setFont(font);
        center.add(category);
        categoryField = new JTextField();
        categoryField.setFont(font);
        center.add(categoryField);

        // Create and add the cost field
        JLabel cost = new JLabel("Cost:");
        cost.setFont(font);
        center.add(cost);
        costField = new JTextField();
        costField.setFont(font);
        center.add(costField);

        JLabel authorLabel = new JLabel("Author: ");
        authorLabel.setFont(font);
        authorField = new JTextField();
        authorField.setFont(font);
        center.add(authorLabel);
        center.add(authorField);

        submitButton = new JButton("Submit");
        submitButton.setFont(font);
        center.add(submitButton);

        return center;
    }
}