package uz.kaizen.gm.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import uz.kaizen.gm.dto.*;
import uz.kaizen.gm.entity.Car;
import uz.kaizen.gm.entity.Inson;
import uz.kaizen.gm.repository.CarRepository;
import uz.kaizen.gm.repository.InsonRepository;
import uz.kaizen.gm.service.dtoparser.CarDtoMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CarService {

    private final CarRepository carRepository;
    private final InsonRepository insonRepository;
    private final CarDtoMapper carDtoMapper;

    public ApiResponse add(CarDto carDto) {


        Inson inson = insonRepository.findById(carDto.getInsonId()).orElse(null);
        if (inson == null) {
            return new ApiResponse(404, "inson id not found");
        }

        Car car = carDtoMapper.toEntity(carDto);
        car.setInson(inson);
        Car save = carRepository.save(car);
        return new ApiResponse(201, "car saqlandi", save);
    }


    public ApiResponse all(int page) {
//        Page<GetAllCar> carPage = carRepository.findAllCarFieldNotDeled(PageRequest.of(page, 10));
        Page<GetAllCarWithInsonId> carPage = carRepository.findAllCarFieldNotDeledWithInson(PageRequest.of(page, 10));
        return new ApiResponse(200, "get all car not deleted", carPage.getContent());
    }


    public ApiResponse ont(String id) {
        Car car = carRepository.findById(id).orElse(null);
        if (car==null){
            return new ApiResponse(404, "topilmadi");
        }
        System.out.println("topildi");
        return new ApiResponse(200, "get one", car);
    }


}
