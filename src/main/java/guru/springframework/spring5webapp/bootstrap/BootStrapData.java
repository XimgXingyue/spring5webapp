package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

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
    Publisher publisher = new Publisher();
    publisher.setName("SPG");
    publisher.setAddress("Lenexa");

    publisherRepository.save(publisher);

    Author luna = new Author("Luna", "Xing");
    Book aaa = new Book("Domain Driven Design", "123456");
    luna.getBooks().add(aaa);
    aaa.getAuthors().add(luna);

    aaa.setPublisher(publisher);
    publisher.getBooks().add(aaa);

    authorRepository.save(luna);
    bookRepository.save(aaa);
    publisherRepository.save(publisher);

    Author lucas = new Author("Lucas", "Shang");
    Book bbb = new Book("J2EE", "67367456145");
    lucas.getBooks().add(bbb);
    bbb.getAuthors().add(lucas);

    bbb.setPublisher(publisher);
    publisher.getBooks().add(bbb);

    authorRepository.save(lucas);
    bookRepository.save(bbb);
    publisherRepository.save(publisher);
  }
}
