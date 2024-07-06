package com.example.partA.dto;

public class UpdateBookDTO {
    private String author;

    private String title;

    private double price;

    public UpdateBookDTO(String author, double price, String title) {
        this.author = author;
        this.price = price;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
        return "UpdateBookDTO{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
