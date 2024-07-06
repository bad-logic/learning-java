package com.example.partA;

import com.example.partA.dto.BookDTO;
import com.example.partA.dto.CreateBookDTO;
import com.example.partA.dto.UpdateBookDTO;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookController {
    private final Map<String,Book> books = new HashMap<>();

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks(){
        List<BookDTO> data = this.books.values().stream().toList().stream().map(BookAdapter::toBookDTO).toList();
        return new ResponseEntity<List<BookDTO>>(data,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookDTO> addBook(@Valid @RequestBody CreateBookDTO book) throws RestException{
        Book exist = books.get(book.getIsbn());
        if(exist != null) throw new RestException("Book already exists with the isbn", HttpStatus.CONFLICT);
        Book bookToAdd = BookAdapter.toEntity(book);
        this.books.put(book.getIsbn(), BookAdapter.toEntity(book));
        return new ResponseEntity<BookDTO>(BookAdapter.toBookDTO(bookToAdd),HttpStatus.CREATED);
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<BookDTO> getBook(@PathVariable String isbn) throws RestException{
        Book book = books.get(isbn);
        if(book == null) throw new RestException("Book not found", HttpStatus.NOT_FOUND);
        return new ResponseEntity<BookDTO>(BookAdapter.toBookDTO(book),HttpStatus.OK);
    }

    @PutMapping("/{isbn}")
    public ResponseEntity<BookDTO> updateBook(@Valid @RequestBody UpdateBookDTO book, @PathVariable String isbn) throws RestException{
        Book exist = books.get(isbn);
        if(exist == null) throw new RestException("Book not found", HttpStatus.NOT_FOUND);

        if(book.getAuthor()!= null){
            exist.setAuthor(book.getAuthor());
        }
        if(book.getPrice() > 0){
            exist.setPrice(book.getPrice());
        }
        if(book.getTitle() != null){
            exist.setTitle(book.getTitle());
        }
        this.books.put(isbn, exist);
        return new ResponseEntity<BookDTO>(BookAdapter.toBookDTO(exist),HttpStatus.CREATED);
    }

    @DeleteMapping("/{isbn}")
    public ResponseEntity<String> deleteBook(@PathVariable String isbn) throws RestException{
        books.remove(isbn);
        return new ResponseEntity<String>(isbn,HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<BookDTO>> searchBooks(@RequestParam String author){
        List<BookDTO> data = this.books.values().stream().toList().stream().filter(x->x.getAuthor().equals(author)).map(BookAdapter::toBookDTO).toList();
        return new ResponseEntity<List<BookDTO>>(data,HttpStatus.OK);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public final ResponseEntity<Map<String,String>> handleValidationExceptions(MissingServletRequestParameterException ex, WebRequest request) {
        Map<String, String> errors = new HashMap<String, String>();
        errors.put("message",ex.getMessage());
        return new ResponseEntity<Map<String, String>>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public final ResponseEntity<Map<String, List<String>>> handleValidationExceptions(MethodArgumentNotValidException ex, WebRequest request) {
        Map<String, List<String>> errors = new HashMap<String, List<String>>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error -> {
                    if (errors.containsKey(error.getField())) {
                        errors.get(error.getField()).add(error.getDefaultMessage());
                    } else {
                        errors.put(error.getField(), new ArrayList<String>() {{
                            add(error.getDefaultMessage());
                        }});
                    }
                });
        return new ResponseEntity<Map<String, List<String>>>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RestException.class)
    public ResponseEntity<Object> handleOperationalExceptions(RestException exception) {
        Map<String, String> errors = new HashMap<String, String>();
        errors.put("message", exception.getMessage());
        return new ResponseEntity<Object>(errors,exception.getStatusCode());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleUnknownExceptions(Exception exception) {
        System.out.println(exception);
        Map<String, String> errors = new HashMap<String, String>();
        errors.put("message", "Something went wrong");
        return new ResponseEntity<Object>(errors,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
