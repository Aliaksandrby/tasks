package by.domain.tablePerConcreteClass.pojo;


import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "t_programmer")
public class Programmer extends Person{

    @Column(name = "language")
    private String language;

    public Programmer(Integer id, String name, String surname, String language) {
        super(id, name, surname);
        this.language = language;
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "id=" + getId() +
                ", name='" + getName() + '\'' +
                ", surname='" + getSurname() + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
