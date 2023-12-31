package pl.edu.wszib.book.store.dao.impl.memory;

import org.springframework.stereotype.Repository;
import pl.edu.wszib.book.store.dao.IBookDAO;
import pl.edu.wszib.book.store.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BookRepository implements IBookDAO {
    private final List<Book> books = new ArrayList<>();

    public BookRepository() {
        this.books.add(
                new Book(1, "Java. Przewodnik doświadczonego programisty. Wydanie III",
                        "Cay S. Horstmann", "978-83-289-0140-7",
                        62.30, 10));
        this.books.add(
                new Book(2, "Java w pigułce. Wydanie VIII",
                        "Benjamin Evans, Jason Clark, David Flanagan",
                        "978-83-289-0161-2",
                        62.30, 10));
        this.books.add(
                new Book(3, "Java. Kompendium programisty. Wydanie XII",
                        "Herbert Schildt", "978-83-832-2156-4",
                        139.30, 10));
        this.books.add(
                new Book(4, "Java. Rusz głową! Wydanie III",
                        "Kathy Sierra, Bert Bates, Trisha Gee", "978-83-283-9984-6",
                        104.30, 10));
    }

    @Override
    public Optional<Book> getById(final int id) {
        return this.books.stream().filter(b -> b.getId() == id).findFirst();
    }

    @Override
    public List<Book> getAll() {
        return this.books;
    }

    @Override
    public void delete(final int id) {
        this.books.removeIf(b -> b.getId() == id);
    }

    @Override
    public void update(Book book) {
        //TODO jak bedzie baza SQL
    }

    @Override
    public List<Book> getByPattern(String pattern) {
        return this.books.stream()
                .filter(b -> b.getAuthor().toLowerCase().contains(pattern.toLowerCase()) ||
                        b.getTitle().toLowerCase().contains(pattern.toLowerCase()))
                .toList();
    }
}
