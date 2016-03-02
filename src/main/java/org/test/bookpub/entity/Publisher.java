package org.test.bookpub.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true) //Needed by Hibernate
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Value
@Builder
@Entity
public class Publisher {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @JsonBackReference
    @OneToMany(mappedBy = "publisher")
    private List<Book> books;
}
