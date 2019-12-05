package com.neoproject.datacaching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

@Controller
@RequestMapping(path="/demo")
public class MainController {
    @Autowired
    private BookRepository bookRepository;
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @PostMapping(path = "/add")
    public @ResponseBody String addNewBook (@RequestParam String title, @RequestParam String isbn){
    Book book = new Book();
    book.setTitle(title);
    book.setIsbn(isbn);
    logger.info(".... Adding books");
    bookRepository.save(book);
    logger.info(".... Added a book" + title +" " + isbn);
    return "saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<Book> getAllBooks() {
        logger.info(".... Fetching books");
        return bookRepository.findAll();

    }

}
