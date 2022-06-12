package com.example.examplewordpres.service;

import com.example.examplewordpres.dto.ApiResponse;
import com.example.examplewordpres.dto.TestWorkDTO;
import com.example.examplewordpres.dto.WorkerHomeworkDTO;
import com.example.examplewordpres.entity.Nomalum;
import com.example.examplewordpres.entity.TestWork;
import com.example.examplewordpres.entity.WorkerHomework;
import com.example.examplewordpres.repository.NomalumRepository;
import com.example.examplewordpres.repository.TestWorkRepository;
import com.example.examplewordpres.repository.WorkerHomeworkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WorkerHomeworkService {

    private final WorkerHomeworkRepository workerRepository;
    private final NomalumRepository nomalumRepository;
    private final TestWorkRepository testWorkRepository;


    public ApiResponse save(WorkerHomework homeworkDTO) {
         if (!homeworkDTO.getFuse().equals(workerRepository.findById(homeworkDTO.getFuse()))){
            workerRepository.save(homeworkDTO);
        }else {
            return new ApiResponse("Bu Pechda malumot mavjud",false);
        }
        return new ApiResponse("save", true);

    }

    public ApiResponse updete(Long id, WorkerHomeworkDTO homeworkDTO) {

        Optional<WorkerHomework> byId = workerRepository.findById(id);
        if (byId.isPresent()) {
            WorkerHomework workerHomework = byId.get();
            workerHomework.setBake(homeworkDTO.getBake());
            workerHomework.setFuse(homeworkDTO.getFuse());
            workerHomework.setSmelter(homeworkDTO.getSmelter());
            workerHomework.setModa1(homeworkDTO.getModa1());
            workerHomework.setModa2(homeworkDTO.getModa2());
            workerHomework.setModa3(homeworkDTO.getModa3());
            workerHomework.setModa4(homeworkDTO.getModa4());
            workerHomework.setModa5(homeworkDTO.getModa5());
            workerHomework.setChemicalName(homeworkDTO.getChemicalName());

            List<TestWorkDTO> testWorkDTOS = homeworkDTO.getTestList();
            List<TestWork> testList = workerHomework.getTestList();

            for (int i = 0; i < homeworkDTO.getTestList().size(); i++) {

                TestWorkDTO testWorkDTO = testWorkDTOS.get(i);

                TestWork testWork = testList.get(i);
                Nomalum nomalum = testWork.getNomalum();

                Nomalum nomalum1 = testWorkDTO.getNomalum();
                testWork.setName(testWorkDTO.getName());
                testWorkRepository.save(testWork);
                nomalum.setConstant(nomalum1.getConstant());
                nomalum.setFill(nomalum1.getFill());
                nomalum.setMacca(nomalum1.getMacca());
                nomalum.setStart(nomalum1.getStart());
                nomalum.setFinish(nomalum1.getFinish());
                nomalum.setContinus(nomalum1.getContinus());
                nomalumRepository.save(nomalum);
            }

//            workerHomework.setTestList();
            workerRepository.save(workerHomework);
            return new ApiResponse("update", true);
        } else {
            return new ApiResponse("Not found", false);
        }


    }
}
