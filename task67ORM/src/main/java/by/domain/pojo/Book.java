package by.domain.pojo;

import by.domain.pojo.addingfield.AddingBook;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Book")
@Table(name="t_book")
public class Book implements Service {
    @Id
    @Column(name="book_id")
    @TableGenerator(name="gen", table="t_book_gen",
            pkColumnName="name_column", valueColumnName="value_column",
            allocationSize=1
    )
    @GeneratedValue(strategy=GenerationType.TABLE, generator="gen")
    private Integer id;

    @Column(name="name_book")
    private String nameOfBook;

    private AddingBook addingBook;
}
