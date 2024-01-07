package org.grostarin.springboot.demorest.controllersTests;

import org.grostarin.springboot.demorest.domain.BannedBook;
import org.grostarin.springboot.demorest.repositories.BannedBookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BannedBookControllerTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    @Autowired
    private BannedBookRepository bannedBookRepository;

    @Test
    void create() {

        // We create the new banned book by the title and the author
        BannedBook bannedBook = new BannedBook("title", "author");
        BannedBook result = this.testRestTemplate.postForObject("/api/banned-books", bannedBook, BannedBook.class);
        
        // AssertEquals
        assertEquals(bannedBook.getTitle(), result.getTitle());
        assertEquals(bannedBook.getAuthor(), result.getAuthor());
        
        // Query the bannedBookRepository to check if the created BannedBook is persisted in the database
        Optional<BannedBook> book = bannedBookRepository.findById(result.getId());
        
        // Assert that the book is present in the database
        assertTrue(book.isPresent());
        
        // AssertEquals
        assertEquals(bannedBook.getTitle(), book.get().getTitle());
        assertEquals(bannedBook.getAuthor(), book.get().getAuthor());
    }
}