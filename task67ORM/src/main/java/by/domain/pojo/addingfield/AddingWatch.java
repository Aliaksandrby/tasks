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
public class AddingWatch {

    @Column(name = "memory")
    private int memory;

    @Column(name = "type_battery")
    private String batteryType;

    @Column(name = "screen_size")
    private int screenSize;
}
