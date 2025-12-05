package uz.kaizen.gm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.kaizen.gm.dto.GetAllCar;
import uz.kaizen.gm.dto.GetAllCarWithInsonId;
import uz.kaizen.gm.entity.Car;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, String> {

    @Query(value = "select c from Car c where c.deleted=false order by c.name asc")
    Page<Car> findAllNotDeled(PageRequest of);

    @Query(value = """
            select new uz.kaizen.gm.dto.GetAllCar(c.id, c.name, c.model, c.color, c.year, c.price)
            from Car c where c.deleted=false order by c.year desc
            """)
    Page<GetAllCar> findAllCarFieldNotDeled(PageRequest of);

    @Query(value = """
            select new uz.kaizen.gm.dto.GetAllCarWithInsonId(c.id, c.name, c.model, c.color, c.year, c.price, i.fullName, i.id)
            from Car c
            join c.inson i
            where c.deleted=false order by c.year desc
            """)
    Page<GetAllCarWithInsonId> findAllCarFieldNotDeledWithInson(PageRequest of);
    
    
}
