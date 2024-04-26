package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media{
    private List<String> authors = new ArrayList<String>();

    public List<String> getAuthors() {
        return authors;
    }

    @Override
    public String toString() {
        return id + ". Book - " + title + " - " + category + " - " + null + " - " + null + ": " + cost + "$";
    }

    public Book(String title, String category, float cost, List<String> authors) {
        super(title, category, cost);
        this.authors = authors;
    }

    public void addAuthor(String authorName) {
        if (this.authors.contains(authorName)) {
            System.out.println("The author "+authorName+" has already in authors' list.");
            return;
        }
        this.authors.add(authorName);
        System.out.println("The author "+authorName+" is successfully added.");
    }

    public void removeAuthor(String authorName) {
        boolean isRemove = this.authors.remove(authorName);
        if (isRemove) {
            System.out.println("The author "+authorName+" is successfully removed.");
        } else {
            System.out.println("There aren't any "+authorName+" in authors' list.");
        }
    }
}
