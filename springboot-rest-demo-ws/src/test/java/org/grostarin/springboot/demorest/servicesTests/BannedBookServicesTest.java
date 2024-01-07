package org.grostarin.springboot.demorest.servicesTests;

import org.grostarin.springboot.demorest.domain.BannedBook;
import org.grostarin.springboot.demorest.services.BannedBookServices;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class BannedBookServicesTest {

    @Autowired
    private BannedBookServices bannedBookServices;

    @Test
    void isBanned() {

        // Creation of a banned book
        String title = "Moby Dick";
        String author = "Herman Melville";
        BannedBook toCreateBBook = new BannedBook(title, author);
        bannedBookServices.addBannedBook(toCreateBBook);

        // Verifies if the book is banned
        assertTrue(bannedBookServices.isBanned(title, author));

    }

    @Test
    void addBannedBook() {
        BannedBook toCreateBBook = new BannedBook();
        assertThatExceptionOfType(DataIntegrityViolationException.class).isThrownBy( () -> bannedBookServices.addBannedBook(toCreateBBook));

    }
}