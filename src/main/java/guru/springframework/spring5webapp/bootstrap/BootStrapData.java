package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositoies.AuthorRepository;
import guru.springframework.spring5webapp.repositoies.BookRepository;
import guru.springframework.spring5webapp.repositoies.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author= new Author("Author1","Writer");
        Author author2= new Author("Author2","Writer2");
        Book book=new Book("The wonderful book","123574954");
        Publisher publisher=new Publisher("TheFamousPublisher","8 Publishers Street","PublisherCity","PublisherState", (long) 99900);
        author.getBooks().add(book);
        book.getAuthors().add(author);

        authorRepository.save(author);
        authorRepository.save(author2);
        bookRepository.save(book);
        publisherRepository.save(publisher);

        book.setPublisher(publisher);
        publisher.getPublishedBooks().add(book);
        bookRepository.save(book);
        publisherRepository.save(publisher);

        System.out.println("********** Test *************");
        for ( Author author1:authorRepository.findAll())
            System.out.println(author.getFirstName());

    }
}
