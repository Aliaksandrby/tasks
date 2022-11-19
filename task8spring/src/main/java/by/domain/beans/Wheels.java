package by.domain.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
public class Wheels implements PartOfCar {
    private int diameter;
    private String type;
    private final int amount = 4;

    public Wheels(@Value("19") int diameter, @Value("sport") String type) {
        this.diameter = diameter;
        this.type = type;
    }
}
