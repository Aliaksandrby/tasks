package by.domain.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
public class Car {

    private PartOfCar engine;
    private PartOfCar body;
    private PartOfCar wheels;
    private PartOfCar tapeRecorder;

    @Autowired(required = false)
    public Car(
            @Qualifier("engine") PartOfCar engine,
            @Qualifier("body") PartOfCar body,
            @Qualifier("wheels")PartOfCar wheels
    ) {
        this.engine = engine;
        this.body = body;
        this.wheels = wheels;
    }

    @Autowired(required = false)
    public Car(
            @Qualifier("engine") PartOfCar engine,
            @Qualifier("body") PartOfCar body,
            @Qualifier("wheels")PartOfCar wheels,
            @Qualifier("tapeRecorder")PartOfCar tapeRecorder
    ) {
        this.engine = engine;
        this.body = body;
        this.wheels = wheels;
        this.tapeRecorder = tapeRecorder;
    }



    public void info() {
        if(tapeRecorder != null) System.out.println("car consists from: \n"
                + engine + "\n"
                + body + "\n"
                + wheels + "\n"
                + tapeRecorder);
        else System.out.println("car consists from: \n"
                + engine + "\n"
                + body + "\n"
                + wheels + "\n");
    }
}
