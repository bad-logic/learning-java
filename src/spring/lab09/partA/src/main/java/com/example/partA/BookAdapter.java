package com.example.partA;

import com.example.partA.dto.BookDTO;
import com.example.partA.dto.CreateBookDTO;
import com.example.partA.dto.UpdateBookDTO;

public class BookAdapter {
    public static Book toEntity(CreateBookDTO book){
        return new Book(book.getAuthor(),book.getIsbn(),book.getPrice(),book.getTitle());
    }

    public static Book toEntity(String isbn,UpdateBookDTO book){
        return new Book(book.getAuthor(),isbn,book.getPrice(),book.getTitle());
    }

    public static BookDTO toBookDTO(Book book){
        return new BookDTO(book.getAuthor(),book.getIsbn(),book.getPrice(),book.getTitle());
    }
}
