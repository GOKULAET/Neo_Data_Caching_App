package com.neoproject.datacaching;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;


import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

  Page<Book> findAll(Pageable pageable);

}