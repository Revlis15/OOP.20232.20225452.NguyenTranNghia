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

    public Book(String title, String category, Float cost, List<String> authors) {
        super(title, category, cost);
        this.authors = authors;
    }

    public void addAuthor(String authorName) throws IllegalArgumentException {
        if (this.authors.contains(authorName)) {
            throw new IllegalArgumentException("The author " + authorName + " is already in the authors' list.");
        }
        this.authors.add(authorName);
        System.out.println("The author " + authorName + " is successfully added.");
    }

    public void removeAuthor(String authorName) throws IllegalArgumentException {
        boolean isRemoved = this.authors.remove(authorName);
        if (isRemoved) {
            System.out.println("The author " + authorName + " is successfully removed.");
        } else {
            throw new IllegalArgumentException("Cannot find the author " + authorName + " in the authors' list.");
        }
    }
}
