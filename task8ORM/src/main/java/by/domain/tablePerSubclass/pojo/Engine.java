package by.domain.tablePerSubclass.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "t_engine")
@PrimaryKeyJoinColumn(name = "engine_id")
public class Engine extends Car {

    @Column(name = "type_engine")
    private String typeOfEngine;

    @Column(name = "number_cylinders")
    private int numberOfCylinders;

    @Column(name = "power")
    private int power;

    public Engine() {
    }

    public Engine(Integer id,String producer,String typeOfEngine, int numberOfCylinders, int power) {
        super(id,producer);
        this.typeOfEngine = typeOfEngine;
        this.numberOfCylinders = numberOfCylinders;
        this.power = power;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "id=" + getId() +
                ", typeOfEngine='" + typeOfEngine + '\'' +
                ", numberOfCylinders=" + numberOfCylinders +
                ", power=" + power +
                '}';
    }
}
