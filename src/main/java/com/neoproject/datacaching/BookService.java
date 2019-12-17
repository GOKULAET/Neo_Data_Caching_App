package com.neoproject.datacaching;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    BookRepository bookRepository;
    public List<Book> getAllBooks(Integer pageNo, Integer pageSize, String isbn)
    {
               Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(isbn));
        Page<Book> pagedResult = bookRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Book>();
        }
    }
}
