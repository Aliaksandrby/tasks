package by.domain.tablePerSubclass.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "t_body")
@PrimaryKeyJoinColumn(name = "body_id")
public class Body extends Car {

    @Column(name = "type_body")
    private String typeOfBody;

    @Column(name = "color")
    private String color;

    @Column(name = "number_doors")
    private int numberOfDoors;

    public Body() {
    }

    public Body(Integer id,String producer,String typeOfBody, String color, int numberOfDoors) {
        super(id,producer);
        this.typeOfBody = typeOfBody;
        this.color = color;
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public String toString() {
        return "Body{" +
                "id=" + getId() +
                ", typeOfBody='" + typeOfBody + '\'' +
                ", color='" + color + '\'' +
                ", numberOfDoors=" + numberOfDoors +
                '}';
    }
}
