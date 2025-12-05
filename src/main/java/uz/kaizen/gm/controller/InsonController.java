package uz.kaizen.gm.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.kaizen.gm.dto.ApiResponse;
import uz.kaizen.gm.dto.InsonDto;
import uz.kaizen.gm.service.InsonService;

@RestController
@RequestMapping("/api/inson")
@RequiredArgsConstructor
@CrossOrigin("*")
public class InsonController {

    private final InsonService insonService;


    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody InsonDto insonDto) {
        ApiResponse apiResponse = insonService.add(insonDto);
        return ResponseEntity.status(apiResponse.getCode()).body(apiResponse);
    }

    @GetMapping("/all")
    public ResponseEntity<?> all(@RequestParam(required = false, defaultValue = "0") int page) {
        ApiResponse apiResponse = insonService.all(page);
        return ResponseEntity.status(apiResponse.getCode()).body(apiResponse);
    }

    @GetMapping("/allOnlyName")
    public ResponseEntity<?> allOnlyName() {
        ApiResponse apiResponse = insonService.allOnlyName();
        return ResponseEntity.status(apiResponse.getCode()).body(apiResponse);
    }

    @GetMapping("/allSomeFilds")
    public ResponseEntity<?> allSomeFilds() {
        ApiResponse apiResponse = insonService.allSomeFilds();
        return ResponseEntity.status(apiResponse.getCode()).body(apiResponse);
    }

    @DeleteMapping("/deleteSoft/{id}")
    public ResponseEntity<?> deleteSoft(@PathVariable String id) {
        ApiResponse apiResponse = insonService.deleteSoft(id);
        return ResponseEntity.status(apiResponse.getCode()).body(apiResponse);
    }

    @GetMapping("/allDeleted")
    public ResponseEntity<?> allDeleted(@RequestParam(required = false, defaultValue = "0") int page) {
        ApiResponse apiResponse = insonService.allDeleted(page);
        return ResponseEntity.status(apiResponse.getCode()).body(apiResponse);
    }

    @GetMapping("/nameStartWith")
    public ResponseEntity<?> nameStartWith(@RequestParam String letter) {
        ApiResponse apiResponse = insonService.nameStartWith(letter);
        return ResponseEntity.status(apiResponse.getCode()).body(apiResponse);
    }


}
