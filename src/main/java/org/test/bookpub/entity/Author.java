package org.test.bookpub.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Many of open source framework, uses reflection to create instance or Object at runtime, based upon name of class. For
 * example When Hibernate creates instance of entities using reflection it uses Class.newInstance() method, which
 * require a no argument constructor to create an instance. It's effectively equivalent of new Entity(). This method
 * throws InstantiationException if it doesn't found any no argument constructor in Entity class, and that's why it's
 * advised to provide a no argument constructor.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true) //Needed by Hibernate
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Value
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Author {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;

    @JsonBackReference
    @OneToMany(mappedBy = "author")
    private List<Book> books;
}


