import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import books.domain.Book;
import org.junit.BeforeClass;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class BooksRESTTest {

    @BeforeClass
    public static void setup() {
        RestAssured.port = Integer.valueOf(8080);
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "";
    }

    @Test
    public void testGetOneBook() {
        // add the book to be fetched
        Book book = new Book("878","Book 123", 18.95, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);
        // test getting the book
        given()
                .when()
                .get("books/878")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("isbn",equalTo("878"))
                .body("title",equalTo("Book 123"))
                .body("price",equalTo(18.95f))
                .body("author",equalTo("Joe Smith"));
        //cleanup
        given()
                .when()
                .delete("books/878");
    }

    @Test
    public void testDeleteBookWithGiveIsbn(){
        Book book = new Book("878","Book 123", 18.95, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);
        given()
                .when()
                .delete("books/878");

        given()
                .when()
                .get("books/878")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .statusCode(404)
                .and()
                .body("errorMessage",equalTo("Book with isbn= 878 is not available"));
    }

    @Test
    public void testAddBook(){
        Book book = new Book("878","Book 123", 9.99, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);

        given()
                .when()
                .get("books/878")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("isbn",equalTo("878"))
                .body("title",equalTo("Book 123"))
                .body("price",equalTo(9.99f))
                .body("author",equalTo("Joe Smith"));

        given()
                .when()
                .delete("books/878");
    }

    @Test
    public void testUpdateBook(){
        Book book = new Book("878","Book 123", 9.99, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);

        book.setAuthor("Ben");

        given()
                .contentType("application/json")
                .body(book)
                .when()
                .put("books/878")
                .then()
                .statusCode(200);

        given()
                .when()
                .get("books/878")
                .then()
                .contentType(ContentType.JSON)
                .and()
                .body("isbn",equalTo("878"))
                .body("title",equalTo("Book 123"))
                .body("price",equalTo(9.99f))
                .body("author",equalTo("Ben"));

        given()
                .when()
                .delete("books/878");
    }

    @Test
    public void testGelAllBooks(){
        Book book = new Book("878","Book 123", 9.99, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);

        Book book1 = new Book("888","new Book", 5.0, "Ben");
        given()
                .contentType("application/json")
                .body(book1)
                .when().post("/books").then()
                .statusCode(200);

        given().when().get("/books").then().statusCode(200)
                .body("books.isbn",hasItems("878","888"))
                .body("books.title",hasItems("new Book","Book 123"))
                .body("books.price",hasItems(9.99F,5.0F))
                .body("books.author",hasItems("Joe Smith","Ben"));

        given()
                .when()
                .delete("books/878");

        given()
                .when()
                .delete("books/888");
    }

    @Test
    public void testGetBooksByAuthor(){
        Book book = new Book("878","Book 123", 9.99, "Joe Smith");
        given()
                .contentType("application/json")
                .body(book)
                .when().post("/books").then()
                .statusCode(200);

        Book book1 = new Book("888","new Book", 5.0, "Ben");
        given()
                .contentType("application/json")
                .body(book1)
                .when().post("/books").then()
                .statusCode(200);

        given().when().get("/books?author='Ben'").then().statusCode(200)
                .body("books.isbn",hasItems("888"))
                .body("books.title",hasItems("new Book"))
                .body("books.price",hasItems(5.0F))
                .body("books.author",hasItems("Ben"));

        given()
                .when()
                .delete("books/878");

        given()
                .when()
                .delete("books/888");

    }
}
