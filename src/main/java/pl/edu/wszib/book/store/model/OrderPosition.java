package pl.edu.wszib.book.store.model;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class OrderPosition {
    private Book book;
    private int quantity;

    public void incrementQuantity() {
        this.quantity++;
    }
}
