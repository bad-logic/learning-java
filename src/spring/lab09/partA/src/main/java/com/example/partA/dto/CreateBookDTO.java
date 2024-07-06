package com.example.partA.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class CreateBookDTO {

    @NotBlank(message = "isbn is mandatory")
    @Size(min = 2, max = 10, message = "isbn must be between 2 and 10 characters")
    private String isbn;
    @NotBlank(message = "author is mandatory")
    @Size(min = 2, max = 15, message = "author must be between 2 and 15 characters")
    private String author;
    @NotBlank(message = "title is mandatory")
    @Size(min = 2, max = 50, message = "title must be between 2 and 50 characters")
    private String title;
    @NotNull(message = "price is mandatory")
    @Positive(message = "price must be a positive number")
    private double price;

    public CreateBookDTO(String author, String isbn, double price, String title) {
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
        return "CreateBookDTO{" +
                "author='" + author + '\'' +
                ", isbn=" + isbn +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

}
