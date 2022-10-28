package by.domain.pojo.addingfield;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class AddingCar {

    @Column(name = "transmission")
    private String transmission;

    @Column(name = "engine_volume")
    private int engineVolume;

    @Column(name = "color")
    private String color;
}
