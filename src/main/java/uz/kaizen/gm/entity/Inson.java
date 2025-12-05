package uz.kaizen.gm.entity;

import jakarta.persistence.Entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Inson extends BaseEntity {
    private String fullName;
    private String passport;
}
