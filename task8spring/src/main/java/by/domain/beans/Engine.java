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
public class Engine implements PartOfCar {
    private int volume;
    private String type;

    public Engine(@Value("1800") int volume, @Value("gas") String type) {
        this.volume = volume;
        this.type = type;
    }
}
