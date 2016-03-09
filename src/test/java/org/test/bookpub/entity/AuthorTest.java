package org.test.bookpub.entity;

import org.junit.Test;
import se.patrikbergman.java.utility.resource.ResourceString;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class AuthorTest extends BookPubEntityTest{

    @Test //From Java pojo to JSON string == Serialize
    public void marshallAuthor() throws IOException {
        String authorJsonString = mapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(author);
        assertNotNull(authorJsonString);
        System.out.println(authorJsonString);
    }

    @Test //From JSON to Java pojo == Deserialize
    public void unmarshallAuthor() throws IOException {
        String authorJsonString = new ResourceString("author.json").toString();
        assertNotNull(authorJsonString);
        System.out.println(authorJsonString);

        Author author = mapper.readValue(authorJsonString, Author.class);
        assertNotNull(author);
        System.out.println(author);
    }
}
