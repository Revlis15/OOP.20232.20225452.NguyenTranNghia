package hust.soict.dsai.Lab02.aims.disc;

public class DigitalVideoDisc {
	public String title;
	public String category;
	public String directory;
	public int length;
	public float cost;
	private static int nbDigitalVideoDiscs = 0;
	private int id;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDirectory() {
		return directory;
	}
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.directory = "unknown";
		this.length = 0;

		nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, String directory, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.directory = directory;
		this.cost = cost;
		this.length = 0;

		nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
	}
	public DigitalVideoDisc(String title, String category, String directory, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.directory = directory;
		this.length = length;
		this.cost = cost;

		nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
	}
	public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }
	public int getId() {
        return id;
    }
	public DigitalVideoDisc(String title, String category, String directory, int length, float cost,int id) {
		super();
		this.title = title;
		this.category = category;
		this.directory = directory;
		this.length = length;
		this.cost = cost;
		
		nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
	}
	@Override
	public String toString() {
		return "DVD - " + title + " - " + category + " - " + directory + " - "
				+ length + ": " + cost + "$";
	}
	public boolean search(String string) {
		String[] words = this.title.split(" ");
		for (int i=0; i<words.length; i++) {
			if (words[i].equals(string)) {
				return true;
			}
		}
		return false;
	}
	public boolean search(int id) {
		if (this.id == id) {
			return true;
		}
		return false;
	}
}