package hust.soict.dsai.aims.media;

import java.util.Comparator;
import java.util.Objects;

public abstract class Media {
    protected static int nbMedias = 0;

    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    protected Integer id;
    protected String title;
    protected String category;
    protected Float cost;

    public Integer getId() {
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

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public Media(String title) {
        this.title = title;
        nbMedias++;
        this.id = nbMedias;
    }

    public Media(String title, String category, Float cost) {
        this.title = title;
        this.category = category;
        this.cost = cost;
        nbMedias++;
        this.id = nbMedias;
    }

    public boolean isMatch(String title) {
        return Objects.equals(this.title, title);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Media)) {
            throw new ClassCastException("The object is not an instance of Media");
        }
        Media media = (Media) obj;
        return Objects.equals(title, media.title) && Objects.equals(cost, media.cost);
    }

    public int compareTo(Media media) {
        if (media == null) {
            throw new NullPointerException("The specified media is null");
        }
        int titleComparison = this.title.compareTo(media.title);
        if (titleComparison != 0) {
            return titleComparison;
        } else {
            return this.cost.compareTo(media.cost);
        }
    }
}
