package org.test.bookpub.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true) //Needed by Hibernate
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Value
@Builder
@Entity
public class Book {
    @Id
    @GeneratedValue
    private Long id;
    private String isbn;
    private String title;
    private String description;

    @JsonManagedReference("book-author")
    @ManyToOne
    private Author author;

    @JsonManagedReference("book-publisher")
    @ManyToOne
    private Publisher publisher;

    @JsonManagedReference("book-reviewers")
    @ManyToMany
    private List<Reviewer> reviewers;
}
