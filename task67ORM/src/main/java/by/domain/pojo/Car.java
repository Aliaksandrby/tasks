package by.domain.pojo;

import by.domain.pojo.addingfield.AddingCar;
import lombok.*;
import javax.persistence.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="Car")
@Table(name="t_car")
public class Car implements Service {

    @Id
    @Column(name="car_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="brand")
    private String brand;

    @Column(name="model")
    private String model;

    private AddingCar addingCar;
}
