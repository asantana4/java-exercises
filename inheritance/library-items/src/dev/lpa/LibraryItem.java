package dev.lpa;

public class LibraryItem {

    protected String title;
    protected int yearPublished;

    public LibraryItem(String title, int yearPublished) {
        this.title = title;
        this.yearPublished = yearPublished;
    }


    public String getDescription() {
        return "Title: " + title + ", Year: " + yearPublished;
    }

    public boolean canBeBorrowed() {
        return true;
    }



}

class Book extends LibraryItem {

    private String author;


    public Book(String title, int yearPublished, String author) {
        super(title, yearPublished);
        this.author = author;

    }

    @Override
    public String getDescription() {
        return super.getDescription() + ", Author: " + author;
    }

}

class Magazine extends LibraryItem {

    private int issueNumber;


    public Magazine(String title, int yearPublished, int issueNumber) {
        super(title, yearPublished);
        this.issueNumber = issueNumber;
    }

    @Override
    public boolean canBeBorrowed() {
        return false;
    }


}