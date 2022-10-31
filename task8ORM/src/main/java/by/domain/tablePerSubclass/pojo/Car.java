package by.domain.tablePerSubclass.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "t_car")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Car {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "producer")
    private String producer;

    public Car() {
    }

    public Car(Integer id, String brand) {
        this.id = id;
        this.producer = brand;
    }
}
