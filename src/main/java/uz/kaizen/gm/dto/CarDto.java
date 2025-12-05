package uz.kaizen.gm.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarDto {

    @NotBlank(message = "bo'sh bomasin")
    @Size(min = 3, max = 50, message = "3 va 50 orasida bo'lishi kerak")
    private String name;
    @NotBlank
    @Size(min = 3, max = 50)
    private String model;
    @NotBlank
    @Size(min = 3, max = 50)
    private String color;
    @NotNull
    private LocalDate year;

    @Min(value = 0)
    @Max(value = 1_000_000_000)
    private double price;
    @NotBlank
    private String insonId;
}
