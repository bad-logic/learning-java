package com.example.partA.dto;

public class BookDTO {

    private String isbn;
    private String author;
    private String title;
    private double price;

    public BookDTO(String author, String isbn, double price, String title) {
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "author='" + author + '\'' +
                ", isbn=" + isbn +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
