package org.test.bookpub.entity;

import lombok.Getter;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.Arrays;
import java.util.List;

public enum BookPubTestEntityBuilder {
    INSTANCE;

    @Getter private Book book;
    @Getter private Author author;
    @Getter private Publisher publisher;
    @Getter private Reviewer reviewer;

    BookPubTestEntityBuilder() {
        setup();
    }

    private void setup() {

        book = Book.builder()
                .id(0L)
                .title("A Wizard of Earthsea")
                .description("A Wizard of Earthsea is a young-adult fantasy novel written by the American author " +
                        "Ursula K. Le Guin, first published by the small press Parnassus in 1968. ")
                .isbn("9780606005739")
                .build();

        author = Author.builder()
                .id(0L)
                .firstName("Ursula K")
                .lastName("Le Guin")
                .books(Arrays.asList(book))
                .build();

        publisher = Publisher.builder()
                .id(0L)
                .name("Nordstedts")
                .books(Arrays.asList(book))
                .build();

        reviewer = Reviewer.builder()
                .id(0L)
                .firstName("King")
                .lastName("Diamond")
                .build();

        ReflectionTestUtils.setField(book, "author", author, Author.class);
        ReflectionTestUtils.setField(book, "publisher", publisher, Publisher.class);
        ReflectionTestUtils.setField(book, "reviewers", Arrays.asList(reviewer), List.class);
    }
}
