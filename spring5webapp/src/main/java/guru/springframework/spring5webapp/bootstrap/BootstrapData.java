package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Yemi Shin on 06/18/20.
 */
@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Started in Bootstrap");

        Publisher publisher1 = new Publisher();
        publisher1.setName("SFG Publishing");
        publisher1.setCity("St.Petersburg");
        publisher1.setCity("Seoul");

        publisherRepository.save(publisher1);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design", "12345");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher1);
        publisher1.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher1);

        Author rod = new Author("Rod","Johnson");
        Book hello = new Book("J2EE Development without EJB","dlkjslkjal");
        rod.getBooks().add(hello);
        hello.getAuthors().add(rod);

        hello.setPublisher(publisher1);
        publisher1.getBooks().add(hello);

        authorRepository.save(rod);
        bookRepository.save(hello);
        publisherRepository.save(publisher1);


        System.out.println("Number of Books: " +bookRepository.count());
        System.out.println("Number of Publishers: " +publisherRepository.count());
    }
}
