package pl.edu.wszib.book.store.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Order {
    private Set<OrderPosition> orderPositions = new HashSet<>();
    private LocalDateTime date;
    private Status status;
    private User user;

    public enum Status {
        NEW,
        PAID,
        SENT,
        DONE
    }
}
