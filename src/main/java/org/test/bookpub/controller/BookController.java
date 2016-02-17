package org.test.bookpub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.test.bookpub.entity.Book;
import org.test.bookpub.repository.BookRepository;

/**
 * REMEMBER!
 * I have configured some Spring Data REST services:
 * - AuthorRepository
 * - PublisherRepository
 * - ReviewerRepository
 */


@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    /**
     * My guess is that Spring sees that there is as String (isbn) that needs
     * to be converted to a Book, and looks for registered formatters. When
     * found BookFormatter is used for the conversion.
     */
//    @RequestMapping(value = "/{isbn}/reviewers", method = RequestMethod.GET)
//    public List<Reviewer> getReviewers(@PathVariable("isbn") Book book) {
//        return book.getReviewers();
//    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @RequestMapping(value = "/{isbn}", method = RequestMethod.GET)
    public Book getBook(@PathVariable String isbn) {
        return bookRepository.findBookByIsbn(isbn);
    }

//    @RequestMapping(value = "/{isbn}", method = RequestMethod.GET)
//    public Book getBook(@PathVariable Isbn isbn) {
//        return bookRepository.findBookByIsbn(isbn.getIsbn());
//    }

    /**
     * It is VERY important to know that PropertyEditor is not thread safe! See IsbnEditor.
     * Use Formatter instead
     */
//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        binder.registerCustomEditor(Isbn.class, new IsbnEditor());
//    }
}
