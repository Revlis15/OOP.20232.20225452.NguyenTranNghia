package hust.soict.dsai.aims.screen.manager;
import hust.soict.dsai.aims.store.Store;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddItemToStoreScreen extends JFrame{
	@SuppressWarnings("unused")
    private Store store;
    protected JMenuItem viewStoreItem;
    protected JMenuItem addBookItem;
    protected JMenuItem addDVDItem;
    protected JMenuItem addCDItem;
    protected JTextField titleField;
    protected JTextField categoryField;
    protected JTextField costField;
    protected JButton submitButton;
    protected JTextField directorField;

	public AddItemToStoreScreen(Store store) {
		this.store = store;

		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);

		setSize(1024, 768);
		setLocationRelativeTo(null);
		setVisible(true);

	}

	public JPanel createNorth(){
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}

	public JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");

		viewStoreItem = new JMenuItem("View store");
		viewStoreItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
                // Switch to the store screen
			}
		});
		menu.add(viewStoreItem);
			

		JMenu smUpdateStore = new JMenu("Update Store");
		addBookItem = new JMenuItem("Add Book");
		addBookItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Switch to the screen for adding a book
			}
		});
		smUpdateStore.add(addBookItem);

		addDVDItem = new JMenuItem("Add DVD");
		addDVDItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Switch to the screen for adding a DVD
			}
		});
		smUpdateStore.add(addDVDItem);

		addCDItem = new JMenuItem("Add CD");
		addCDItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Switch to the screen for adding a CD
			}
		});
		smUpdateStore.add(addCDItem);
		menu.add(smUpdateStore);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);

		return menuBar;
	}

	public JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);

		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());

		return header;
		
	}

	JPanel createCenter() {
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

        // Create and add the director field
        JLabel director = new JLabel("Director:");
        director.setFont(font);
        center.add(director);
        directorField = new JTextField();
        directorField.setFont(font);
        center.add(directorField);

        // Create and add the submit button
        submitButton = new JButton("Submit");
        submitButton.setFont(font);
        center.add(submitButton);
		
		return center;
	}


	
}