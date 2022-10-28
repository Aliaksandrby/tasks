package by.domain.pojo;

import by.domain.pojo.addingfield.AddingWatch;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Watch")
@Table(name="t_watch")
public class SmartWatch implements Service {
    @Id
    @Column(name="watch_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "watch_seq")
    @SequenceGenerator(name = "watch_seq", sequenceName = "t_watch_seq")
    private Integer id;

    @Column(name="brand")
    private String nameOfBrand;

    @Column(name="type_system")
    private String typeSystem;

    @Column(name="body_size")
    private int bodySize;

    private AddingWatch addingWatch;
}
