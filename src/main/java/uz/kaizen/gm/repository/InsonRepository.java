package uz.kaizen.gm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import uz.kaizen.gm.dto.InsonDtoIdFullNamePassport;
import uz.kaizen.gm.entity.Inson;

import java.util.List;

public interface InsonRepository extends JpaRepository<Inson, String> {

    @Query(value = "select * from inson i where i.deleted=false", nativeQuery = true)
    Page<Inson> findAllDeletedFalse(PageRequest of);

    @Query(value = "select * from inson i where i.deleted=true", nativeQuery = true)
    Page<Inson> findAllDeletedTrue(PageRequest of);

    @Query(value = "select * from inson i where i.full_name ilike concat(:letter,'%')", nativeQuery = true)
    List<Inson> nameStartWith(@Param("letter") String letter);

    @Query(value = "select i.full_name from inson i where i.deleted=false", nativeQuery = true)
    List<String> findAllDeletedFalseOnlyName();

    @Query(value = """
            select new uz.kaizen.gm.dto.InsonDtoIdFullNamePassport(i.id, i.fullName, i.passport) from Inson i
            where i.deleted=false
            order by i.fullName asc
            """)
    List<InsonDtoIdFullNamePassport> findAllSomeFilds();
}
