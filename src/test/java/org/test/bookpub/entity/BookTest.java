package org.test.bookpub.entity;

import org.junit.Test;
import se.patrikbergman.java.utility.resource.ResourceString;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class BookTest extends BookPubEntityTest{

    @Test //From Java pojo to JSON string == Serialize
    public void marshallBook() throws IOException {
        String bookJsonString = mapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(book);
        assertNotNull(bookJsonString);
        System.out.println(bookJsonString);
    }

    @Test //From JSON to Java pojo == Deserialize
    public void unmarshallBook() throws IOException {
        String jsonString = new ResourceString("book.json").toString();
        assertNotNull(jsonString);
        System.out.println(jsonString);

        Book book = mapper.readValue(jsonString, Book.class);
        assertNotNull(book);
        System.out.println(book);
    }
}