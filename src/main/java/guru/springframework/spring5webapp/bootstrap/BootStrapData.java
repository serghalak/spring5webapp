package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepo;
import guru.springframework.spring5webapp.repositories.BookRepo;
import guru.springframework.spring5webapp.repositories.PublisherRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BootStrapData implements CommandLineRunner {

    private AuthorRepo authorRepository;
    private BookRepo bookRepository;
    private PublisherRepo publisherRepository;

    public BootStrapData(AuthorRepo authorRepo
            , BookRepo bookRepo
            ,PublisherRepo publisherRepo) {
        this.authorRepository = authorRepo;
        this.bookRepository = bookRepo;
        this.publisherRepository=publisherRepo;
    }

    @Override
    public void run(String... args) throws Exception {
//        Author eric=new Author("Eric","Evans");
//        Book ddd=new Book("Domain Driven Design","123123");
//        eric.getBooks().add(ddd);
//        ddd.getAuthors().add(eric);
//        authorRepo.save(eric);
//        bookRepo.save(ddd);
//
//        Author rod=new Author("Rod","Johnson");
//        Book noEJB=new Book("J2EE Development without EJB","3939459459");
//        rod.getBooks().add(noEJB);
//        noEJB.getAuthors().add(rod);
//        authorRepo.save(rod);
//        bookRepo.save(noEJB);
//
//        System.out.println("startted in bootstrap");
//        System.out.println("Number of books: " + bookRepo.count());


        System.out.println("Started in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St Petersburg");
        publisher.setState("FL");

        publisherRepository.save(publisher);

        System.out.println("Publisher Count: " + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);

        noEJB.setPublisher(publisher);
        publisher.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
    }
}
