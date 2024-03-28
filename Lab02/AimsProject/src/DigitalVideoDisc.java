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
	}
	public DigitalVideoDisc(String title, String category, String directory, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.directory = directory;
		this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String directory, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.directory = directory;
		this.length = length;
		this.cost = cost;
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
}