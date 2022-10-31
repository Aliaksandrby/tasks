package by.domain.tablePerClassHierarchy.pojo;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "t_device")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DEVICE_TYPE")
public abstract class Device {
    public Device(Integer id, String brand) {
        this.id = id;
        this.brand = brand;
    }

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "brand")
    private String brand;
}