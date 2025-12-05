package uz.kaizen.gm.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import uz.kaizen.gm.dto.ApiResponse;
import uz.kaizen.gm.dto.InsonDto;
import uz.kaizen.gm.dto.InsonDtoIdFullNamePassport;
import uz.kaizen.gm.entity.Inson;
import uz.kaizen.gm.repository.InsonRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InsonService {

    private final InsonRepository insonRepository;

    public ApiResponse add(InsonDto insonDto) {
        Inson inson = new Inson();
        inson.setFullName(insonDto.getFullName());
        inson.setPassport(insonDto.getPassport());

        Inson save = insonRepository.save(inson);
        return new ApiResponse(201, "inson add", save);
    }


    public ApiResponse all(int page) {
        Page<Inson> insonPage = insonRepository.findAllDeletedFalse(PageRequest.of(page, 10));
        return new ApiResponse(200, "get all no deleted", insonPage.getContent());
    }


    public ApiResponse deleteSoft(String id) {

        Inson inson = insonRepository.findById(id).orElse(null);
        if (inson == null) {
            return new ApiResponse(404, "inson topilmadi");
        }

        inson.setDeleted(true);
        insonRepository.save(inson);
        return new ApiResponse(201, "deleted by soft");
    }

    public ApiResponse allDeleted(int page) {

        Page<Inson> insonPage = insonRepository.findAllDeletedTrue(PageRequest.of(page, 10));
        return new ApiResponse(201, "get all deleted", insonPage.getContent());


    }

    public ApiResponse nameStartWith(String letter) {
        List<Inson> insonList = insonRepository.nameStartWith(letter);
        return new ApiResponse(200, "findFullNameStartWith", insonList);
    }

    public ApiResponse allOnlyName() {
        List<String> allDeletedFalseOnlyName = insonRepository.findAllDeletedFalseOnlyName();
        return new ApiResponse(200, "getOnlyName", allDeletedFalseOnlyName);
    }

    public ApiResponse allSomeFilds() {

        List<InsonDtoIdFullNamePassport> allSomeFilds = insonRepository.findAllSomeFilds();
        return new ApiResponse(200, "get all some data inson", allSomeFilds);
    }
}
