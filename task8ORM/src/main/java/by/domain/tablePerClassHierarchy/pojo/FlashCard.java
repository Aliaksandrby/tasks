package by.domain.tablePerClassHierarchy.pojo;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
@DiscriminatorValue("FLASH_CARD")
public class FlashCard extends Device {

    public FlashCard(Integer id, String brand, int volume, String fileSystem, int speedWrite, int speedRead) {
        super(id, brand);
        this.volume = volume;
        this.fileSystem = fileSystem;
        this.speedWrite = speedWrite;
        this.speedRead = speedRead;
    }

    @Column(name = "volume")
    private int volume;

    @Column(name = "file_system")
    private String fileSystem;

    @Column(name = "speed_write")
    private int speedWrite;

    @Column(name = "speed_read")
    private int speedRead;

    @Override
    public String toString() {
        return "FlashCard{" +
                "id=" + getId() +
                ", brand=" + getBrand() +
                ", volume=" + volume +
                ", fileSystem='" + fileSystem + '\'' +
                ", speedWrite=" + speedWrite +
                ", speedRead=" + speedRead +
                '}';
    }
}
