package hust.soict.dsai.aims.screen.manager;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.*;

@SuppressWarnings("serial")
public class AddCDScreen extends AddItemToStoreScreen{
    public JTextField artistField;
    public JTextField trackField;

    public AddCDScreen(Store store){
        super(store);
        setTitle("Add CD");

        super.viewStoreItem.addActionListener(e -> {
            new StoreManagerScreen(store).setVisible(true);
            AddCDScreen.this.setVisible(false);
        });

        super.addBookItem.addActionListener(e ->{
            new AddBookScreen(store).setVisible(true);
            AddCDScreen.this.setVisible(false);
        });

        super.addDVDItem.addActionListener(e -> {
            new AddDVDScreen(store).setVisible(true);
            AddCDScreen.this.setVisible(false);
        });

        super.submitButton.addActionListener(e -> {
            String titleTrack;
            int lengthTrack;    
            String title = titleField.getText();
            String category = categoryField.getText();
            String costText = costField.getText();
            String director = directorField.getText();
            String artist = artistField.getText();
            String trackText = trackField.getText();

            if (title.isEmpty() || category.isEmpty() || costText.isEmpty() || director.isEmpty() ||artist.isEmpty() || trackText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "All fields must be filled out.");
            } else {
                float cost = Float.parseFloat(costText);
                String[] list = trackText.split(",");
                ArrayList<Track> tracks = new ArrayList<>();
                for (String a : list) {
                    String[] parts = a.split(",");
                    titleTrack = parts[0];
                    lengthTrack = Integer.parseInt(parts[1]);
                    Track track = new Track(titleTrack,lengthTrack); 
                    tracks.add(track);
                }
                CompactDisc cd = new CompactDisc(title, category, cost, artist, tracks);
                if (store.cdExists(cd)) {
                    JOptionPane.showMessageDialog(this, "This CD already exists in the store.");
                } else {
                    store.addMedia(cd);
                    titleField.setText("");
                    categoryField.setText("");
                    costField.setText("");
                    artistField.setText("");
                    trackField.setText("");
                }
            }
        });
    }

    @Override
    JPanel createCenter(){
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(7, 2));
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

        JLabel directorLabel = new JLabel("Director: ");
        directorLabel.setFont(font);
        directorField = new JTextField();
        directorField.setFont(font);
        center.add(directorLabel);
        center.add(directorField);

        JLabel artistLabel = new JLabel("Artist: ");
        artistLabel.setFont(font);
        artistField = new JTextField();
        artistField.setFont(font);
        center.add(artistLabel);
        center.add(artistField);

        JLabel trackLabel = new JLabel("Tracks: ");
        trackLabel.setFont(font);
        trackField = new JTextField();
        trackField.setFont(font);
        center.add(trackLabel);
        center.add(trackField);

        submitButton = new JButton("Submit");
        submitButton.setFont(font);
        center.add(submitButton);


        return center;
    }
}
