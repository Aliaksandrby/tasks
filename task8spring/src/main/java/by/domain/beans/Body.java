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
public class Body implements PartOfCar {
    private String color;
    private String type;

    public Body(@Value("green") String color, @Value("sedan") String type) {
        this.color = color;
        this.type = type;
    }
}
