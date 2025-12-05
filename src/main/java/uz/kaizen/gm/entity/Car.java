package uz.kaizen.gm.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Car extends BaseEntity {
    private String name;
    private String model;
    private String color;
    private LocalDate year;
    private double price;
    @ManyToOne
    private Inson inson;
}
