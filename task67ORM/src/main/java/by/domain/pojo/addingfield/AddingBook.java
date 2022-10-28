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
public class AddingBook {

    @Column(name = "writer")
    private String writer;

    @Column(name = "year_publishing")
    private int yearOfPublishing;

    @Column(name = "publishing_office")
    private String publishingOffice;
}
