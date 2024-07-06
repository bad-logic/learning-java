package com.example.partA;

import com.example.partA.dto.BookDTO;
import com.example.partA.dto.CreateBookDTO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	private RestTemplate restTemplate = new RestTemplate();

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	/**
	 * Callback used to run the bean.
	 *
	 * @param args incoming main method arguments
	 * @throws Exception on error
	 */
	@Override
	public void run(String... args) throws Exception {
		String serverUrl = "http://localhost:8080/book";

		System.out.println("----------------- adding books ------------------");
		restTemplate.postForLocation(serverUrl, new CreateBookDTO("Frank","lskjf3243", 9.99,
				"hello world"));
		restTemplate.postForLocation(serverUrl, new CreateBookDTO("John","brfG-645", 99.99,
				"Journey To Space"));

		System.out.println("----------------- getting list of books ------------------");
		// getForObject does not handle the generic type
		BookDTO[] books = restTemplate.getForObject(serverUrl, BookDTO[].class);
		System.out.println(Arrays.asList(books));

		System.out.println("----------------- getting single book ------------------");
		BookDTO book = restTemplate.getForObject(serverUrl+"/{isbn}", BookDTO.class, "lskjf3243");
		System.out.println(book);

		System.out.println("----------------- updating title of a book ------------------");
		book.setTitle("hello world from java");
		restTemplate.put(serverUrl+"/{isbn}", book, "lskjf3243");

		System.out.println("----------------- getting updated book ------------------");
		book = restTemplate.getForObject(serverUrl+"/{isbn}", BookDTO.class, "lskjf3243");
		System.out.println(book);

		System.out.println("----------------- searching book by author ------------------");
		List<Book> bookList = restTemplate.exchange(
				serverUrl+"/search?author={author}",
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Book>>() {},
				"John"
		).getBody();
		System.out.println(bookList);

		System.out.println("----------------- Deleting a book ------------------");
		restTemplate.delete(serverUrl+"/{isbn}","brfG-645");

		System.out.println("----------------- getting list of books ------------------");
		bookList = restTemplate.exchange(
				serverUrl,
				HttpMethod.GET,
				null,
				new ParameterizedTypeReference<List<Book>>() {}
		).getBody();
		System.out.println(bookList);
	}
}
