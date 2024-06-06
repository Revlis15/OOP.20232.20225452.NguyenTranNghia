package hust.soict.dsai.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

@SuppressWarnings("serial")
public class StoreManagerScreen extends JFrame{
	private Store store;

	public StoreManagerScreen(Store store) {
		this.store = store;

		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);

		setTitle("Store");
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

		JMenuItem viewStoreItem = new JMenuItem("View store");
		viewStoreItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Switch back to the StoreManagerScreen
			}
		});
		menu.add(viewStoreItem);
			

		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem addBookItem = new JMenuItem("Add Book");
		addBookItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Switch to the screen for adding a book
				new AddBookScreen(store).setVisible(true);
				StoreManagerScreen.this.setVisible(false);
			}
		});
		smUpdateStore.add(addBookItem);

		JMenuItem addDVDItem = new JMenuItem("Add DVD");
		addDVDItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Switch to the screen for adding a DVD
				new AddDVDScreen(store).setVisible(true);
				StoreManagerScreen.this.setVisible(false);
			}
		});
		smUpdateStore.add(addDVDItem);

		JMenuItem addCDItem = new JMenuItem("Add CD");
		addCDItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Switch to the screen for adding a CD
				new AddCDScreen(store).setVisible(true);
				StoreManagerScreen.this.setVisible(false);
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
		center.setLayout(new GridLayout(3,3,2,2));

		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i = 0; i < mediaInStore.size(); i++){
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		
		return center;
	}


	
}
