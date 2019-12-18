package com.neoproject.datacaching;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;

import java.util.List;

@Controller
@RestController
//@RequestMapping(path="/demo")
public class MainController {
    @Autowired
    private BookRepository bookRepository;
     @Autowired
    BookService bookService;

    Pageable firstPageWithTwoElements = PageRequest.of(0, 2);
    private static final Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping(path = "/add")
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
    public List<Book> getAllBooks(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "9781588264916") String isbn)
    {
        List<Book> list = bookService.getAllBooks(0, 5, "9781588264916");
        logger.info(".... Added a book" + list);
        return list;
    }

    @PutMapping(path = "/addbook")
    public String addBook(
        @RequestParam String title,
        @RequestParam String isbn){
        return "Book Saved";}

    @GetMapping("/")
    public String showHomePage(Model model) {
        return "index";
    }
}
