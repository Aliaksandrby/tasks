package by.domain.tablePerConcreteClass.pojo;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "t_driver")
public class Driver extends Person{

    @Column(name = "car_name")
    private String carName;

    public Driver(Integer id, String name, String surname, String carName) {
        super(id, name, surname);
        this.carName = carName;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", carName='" + carName + '\'' +
                '}';
    }
}
