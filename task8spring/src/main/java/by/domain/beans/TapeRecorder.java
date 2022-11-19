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
public class TapeRecorder implements PartOfCar {
    private String nameSong;

    public TapeRecorder(@Value("Aerosmith - I Don't Want to Miss a Thing") String nameSong) {
        this.nameSong = nameSong;
    }
}
