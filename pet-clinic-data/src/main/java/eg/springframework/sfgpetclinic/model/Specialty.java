package eg.springframework.sfgpetclinic.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "SPECIALTY")
public class Specialty extends BaseEntity {

    @Builder
    public Specialty(Long id, String description) {
        super(id);
        this.description = description;
    }

    @Column(name = "DESCRIPTION")
    private String description;

}
