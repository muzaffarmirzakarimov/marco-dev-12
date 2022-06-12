package com.example.examplewordpres.service;

import com.example.examplewordpres.dto.ApiResponse;
import com.example.examplewordpres.dto.DetailDescriptionDTO;
import com.example.examplewordpres.entity.DetailDescription;
import com.example.examplewordpres.entity.Pourer;
import com.example.examplewordpres.repository.DetailDescriptionRepository;
import com.example.examplewordpres.repository.PourerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DetailDescriptionService {

    private final PourerRepository pourerRepository;
    private final DetailDescriptionRepository detailDescriptionRepository;


    public ApiResponse save(DetailDescription detailDescription) {
        DetailDescription save = detailDescriptionRepository.save(detailDescription);
        return new ApiResponse("Save", true);
    }


    public ApiResponse updete(Long id, DetailDescriptionDTO dto){

        Optional<DetailDescription> byId = detailDescriptionRepository.findById(id);
        if (byId.isPresent()) {
            DetailDescription detailDescription = byId.get();

            List<Pourer> list = dto.getList();

            detailDescription.setCaster1(dto.getCaster1());
            detailDescription.setCaster2(dto.getCaster2());
            List<Pourer> list1 = detailDescription.getList();

            for (int i = 0; i < dto.getList().size(); i++) {
                Pourer pourer = list.get(i);
                Pourer pourer1 = list1.get(i);
                pourer1.setNameCastings(pourer.getNameCastings());
                pourer1.setKolform(pourer.getKolform());
                pourer1.setBalls(pourer.getBalls());
                pourer1.setWeightPcs(pourer.getWeightPcs());
                pourer1.setGeneralMassa(pourer.getGeneralMassa());
                pourer1.setTemperaFills(pourer.getTemperaFills());
                pourer1.setNote(pourer.getNote());
                pourerRepository.save(pourer1);
            }
            detailDescriptionRepository.save(detailDescription);

        }
        return new ApiResponse("Updete",true);
    }

}
