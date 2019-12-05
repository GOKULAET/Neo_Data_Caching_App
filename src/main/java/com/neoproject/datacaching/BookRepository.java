package com.neoproject.datacaching;

import org.springframework.data.repository.CrudRepository;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

  Book getByIsbn(String isbn);

}