package com.bookger.app.repertory;

import com.bookger.app.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepertory extends JpaRepository<Book, Long> {
    // Search books by author
    List<Book> findByAuthor(String author);

    // Search books by year
    List<Book> findByPublishedYear(int publishedYear);
/*
    @Query("SELECT * FROM Book b WHERE publishedYear = :publishedYear")
    List<Book> findBooksByPublishedYear(@Param("publishedYear") String publishedYear);
*/

}
