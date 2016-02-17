package org.test.bookpub.entity;

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
 *
 * I would prefer to use @Value, but then I get an error on "id may not have been initialized"
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
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
    @OneToMany(mappedBy = "author")
    private List<Book> books;

//@ToString
//@NoArgsConstructor(access = AccessLevel.PRIVATE)
//@AllArgsConstructor(access = AccessLevel.PRIVATE)
//@Getter
//@Builder
//@EqualsAndHashCode
//@JsonIgnoreProperties(ignoreUnknown = true)
//@Entity
//public class Author {
//    @Id
//    @GeneratedValue
//    private Long id;
//    private String firstName;
//    private String lastName;
//    @OneToMany(mappedBy = "author")
//    private List<Book> books;


//
//    public Author(String firstName, String lastName, List<Book> books) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.books = books;
//    }
//
//    public Author(String firstName, String lastName) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public List<Book> getBooks() {
//        return books;
//    }
//
//    public void setBooks(List<Book> books) {
//        this.books = books;
//    }
}


