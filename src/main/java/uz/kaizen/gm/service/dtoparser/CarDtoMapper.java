package uz.kaizen.gm.service.dtoparser;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.kaizen.gm.dto.CarDto;
import uz.kaizen.gm.entity.Car;

@Mapper(componentModel = "spring")
public interface CarDtoMapper {
    Car toEntity(CarDto carDto);
}
