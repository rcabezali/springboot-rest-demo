package org.grostarin.springboot.demorest.controllers;
import org.grostarin.springboot.demorest.domain.BannedBook;
import org.grostarin.springboot.demorest.services.BannedBookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/banned-books")
public class BannedBookController {

    @Autowired
    private BannedBookServices bannedBookServices;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BannedBook create(@RequestBody BannedBook bannedBook) {
        return bannedBookServices.addBannedBook(bannedBook);
    }

}