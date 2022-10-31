package by.domain.tablePerClassHierarchy.pojo;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("PLAYER")
public class Player extends Device {

    public Player(Integer id, String brand, String osType, int screenSize, String screenType) {
        super(id, brand);
        this.osType = osType;
        this.screenSize = screenSize;
        this.screenType = screenType;
    }

    @Column(name = "os_type")
    private String osType;

    @Column(name = "screen_size")
    private int screenSize;

    @Column(name = "screen_type")
    private String screenType;

    @Override
    public String toString() {
        return "Player{" +
                "id=" + getId() +
                ", brand=" + getBrand() +
                ", osType='" + osType + '\'' +
                ", screenSize=" + screenSize +
                ", screenType='" + screenType + '\'' +
                '}';
    }
}
