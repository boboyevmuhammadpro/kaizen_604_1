package uz.kaizen.gm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetAllCarWithInsonId {
    private String id;
    private String name;
    private String model;
    private String color;
    private LocalDate year;
    private double price;
    private String fullName;
    private String insonId;
}
