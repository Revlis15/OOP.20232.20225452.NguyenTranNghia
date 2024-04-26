package hust.soict.dsai.aims.media;

import java.util.Comparator;
import java.util.Objects;

public abstract class Media {
    protected static int nbMedias = 0;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    protected int id;
    protected String title;
    protected String category;

    protected float cost;

    public int getId() {
        return id;
    }

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

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public Media(String title) {
        this.title = title;
        nbMedias++;
        this.id = nbMedias;
    }

    public Media(String title, String category, float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        this.id = nbMedias;
    }

    public boolean isMatch(String title) {
        return Objects.equals(this.title, title);
    }

    @Override
    public boolean equals(Object o) {
        //Compare with itself
        if (o == this) {
            return true;
        }
        //Check if o is an instance of Media class
        if (!(o instanceof Media)) {
            return false;
        }
        //Cast o to Media
        Media m = (Media) o;
        //Compare
        return Objects.equals(this.title, m.getTitle());
    }
}
