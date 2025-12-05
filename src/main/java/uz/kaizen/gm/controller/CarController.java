package uz.kaizen.gm.controller;

import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.kaizen.gm.dto.ApiResponse;
import uz.kaizen.gm.dto.CarDto;
import uz.kaizen.gm.dto.InsonDto;
import uz.kaizen.gm.service.CarService;
import uz.kaizen.gm.service.InsonService;

@RestController
@RequestMapping("/api/car")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CarController {

    private final CarService carService;

    @PostMapping("/add")
    public ResponseEntity<?> add(@Valid @RequestBody CarDto carDto) {
        ApiResponse apiResponse = carService.add(carDto);
        return ResponseEntity.status(apiResponse.getCode()).body(apiResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<?> all(@RequestParam(required = false, defaultValue = "0") int page) {
        ApiResponse apiResponse = carService.all(page);
        return ResponseEntity.status(apiResponse.getCode()).body(apiResponse);
    }

}
