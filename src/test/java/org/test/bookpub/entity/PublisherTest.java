package org.test.bookpub.entity;

import org.junit.Test;
import se.patrikbergman.java.utility.resource.ResourceString;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class PublisherTest extends BookPubEntityTest{

    @Test //From Java pojo to JSON string == Serialize
    public void marshallPublisher() throws IOException {
        String publisherJsonString = mapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(publisher);
        assertNotNull(publisherJsonString);
        System.out.println();
        System.out.println(publisherJsonString);
    }

    @Test //From JSON to Java pojo == Deserialize
    public void unmarshallPublisher() throws IOException {
        String publisherJsonString = new ResourceString("publisher.json").toString();
        assertNotNull(publisherJsonString);
        System.out.println(publisherJsonString);

        Publisher publisher = mapper.readValue(publisherJsonString, Publisher.class);
        assertNotNull(publisher);
        System.out.println(publisher);
    }
}