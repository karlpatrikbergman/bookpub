package org.test.bookpub.entity;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

abstract class BookPubEntityTest {
    protected ObjectMapper mapper;
    protected Book book;
    protected Author author;
    protected Publisher publisher;
    protected Reviewer reviewer;
    protected BookPubTestEntityBuilder bookPubTestEntityBuilder;

    @Before
    public void setup() {
        mapper = new ObjectMapper();
        bookPubTestEntityBuilder = BookPubTestEntityBuilder.INSTANCE;
        book = bookPubTestEntityBuilder.getBook();
        author = bookPubTestEntityBuilder.getAuthor();
        publisher = bookPubTestEntityBuilder.getPublisher();
        reviewer = bookPubTestEntityBuilder.getReviewer();
        assertNotNull(book);
        assertNotNull(author);
        assertNotNull(publisher);
        assertNotNull(reviewer);
        assertTrue(author.hasWritten(book));
    }
}
