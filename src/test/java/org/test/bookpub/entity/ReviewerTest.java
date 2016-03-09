package org.test.bookpub.entity;

import org.junit.Test;
import se.patrikbergman.java.utility.resource.ResourceString;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class ReviewerTest extends BookPubEntityTest{

    @Test //From Java pojo to JSON string == Serialize
    public void marshallReviewer() throws IOException {
        String reviewerJsonString = mapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(reviewer);
        assertNotNull(reviewerJsonString);
        System.out.println();
        System.out.println(reviewerJsonString);
    }

    @Test //From JSON to Java pojo == Deserialize
    public void unmarshallReviewer() throws IOException {
        String reviewerJsonString = new ResourceString("reviewer.json").toString();
        assertNotNull(reviewerJsonString);
        System.out.println(reviewerJsonString);

        Reviewer reviewer = mapper.readValue(reviewerJsonString, Reviewer.class);
        assertNotNull(reviewer);
        System.out.println(reviewer);
    }
}
