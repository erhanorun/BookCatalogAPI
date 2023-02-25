package com.opensource.BookCatalogAPI.repository;


import com.opensource.BookCatalogAPI.model.Books;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Books, Long> {

}
