package org.test.bookpub;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.test.bookpub.entity.Author;
import org.test.bookpub.entity.Book;
import org.test.bookpub.entity.Publisher;
import org.test.bookpub.entity.Reviewer;
import org.test.bookpub.repository.AuthorRepository;
import org.test.bookpub.repository.BookRepository;
import org.test.bookpub.repository.PublisherRepository;
import org.test.bookpub.repository.ReviewerRepository;

import java.util.Arrays;
//import org.test.bookpub.repository.PublisherRepository;
//import org.test.bookpub.repository.ReviewerRepository;

@Order(Ordered.LOWEST_PRECEDENCE - 15)
public class PopulateDatabaseRunner implements CommandLineRunner {
    protected final Log logger = LogFactory.getLog(getClass());

    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private BookRepository bookRepository;
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private AuthorRepository authorRepository;
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private PublisherRepository publisherRepository;
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private ReviewerRepository reviewerRepository;

    @Override
    public void run(String... args) throws Exception {
        Author author = Author.builder()
                .firstName("Patrik")
                .lastName("Bergman")
                .books(null)
                .build();
        authorRepository.save(author);

        Reviewer reviewer1 = Reviewer.builder()
                .firstName("King")
                .lastName("Diamond")
                .build();
        reviewerRepository.save(reviewer1);

        Reviewer reviewer2 = Reviewer.builder()
                .firstName("Lauren")
                .lastName("Hill")
                .build();
        reviewerRepository.save(reviewer2);

        Publisher publisher = Publisher.builder()
                .name("Nordstedths")
                .build();
        publisherRepository.save(publisher);

        Book book = Book.builder()
                .title("Varats olidliga tyngd")
                .description("En bok om hur olidligt tungt det kan vara att vara")
                .isbn("978-1-78528-415-1")
                .author(author)
                .publisher(publisher)
                .reviewers(Arrays.asList(reviewer1, reviewer2))
                .build();
        bookRepository.save(book);
    }

//    @Scheduled(initialDelay = 1000, fixedRate = 10000)
//    public void run() {
//        logger.info("Number of books: " + bookRepository.count());
//    }
}
