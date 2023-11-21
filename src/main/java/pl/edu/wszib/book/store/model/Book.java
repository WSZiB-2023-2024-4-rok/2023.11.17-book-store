package pl.edu.wszib.book.store.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Book {
    private int id;
    private String title;
    private String author;
    private String isbn;
    private double price;
    private int quantity;
}
