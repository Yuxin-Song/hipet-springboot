package com.hipet.hipetspringboot.controller;

import com.hipet.hipetspringboot.entity.Vaccine;
import com.hipet.hipetspringboot.jsonify.ResponseStatusCode;
import com.hipet.hipetspringboot.jsonify.ResultJson;
import com.hipet.hipetspringboot.repository.VaccineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// REMIND: change it when you need it.
@CrossOrigin
//(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/vaccine")
public class VaccineHandler {

    @Autowired
    private VaccineRepository vaccineRepository;

    @PostMapping("/add")
    public ResultJson add(@RequestBody Vaccine vaccine) {
        Vaccine vaccine1 = new Vaccine();

        vaccine1.setPetid(vaccine.getPetid());
        vaccine1.setV1(vaccine.getV1());
        vaccine1.setV2(vaccine.getV2());
        vaccine1.setV3(vaccine.getV3());
        vaccine1.setV4(vaccine.getV4());
        vaccine1.setTest(vaccine.getTest());
        vaccine1.setV5(vaccine.getV5());

        vaccineRepository.save(vaccine1);

        return ResultJson.returnResult(ResponseStatusCode.CREATED.getStatusCode(), ResponseStatusCode.CREATED.getMsg(), vaccine1);
    }

    @PostMapping("/delete")
    public ResultJson delete(@RequestBody Vaccine vaccine) {
        if (vaccineRepository.existsByPetid(vaccine.getPetid())) {
            vaccineRepository.deleteByPetid(vaccine.getPetid());
            return ResultJson.returnResult(ResponseStatusCode.SUCCESS.getStatusCode(), ResponseStatusCode.SUCCESS.getMsg(), vaccine);
        }
        return ResultJson.returnResult(ResponseStatusCode.NOT_FOUND.getStatusCode(), ResponseStatusCode.NOT_FOUND.getMsg(), null);
    }

    @PutMapping("/update")
    public ResultJson update(@RequestBody Vaccine vaccine) {
        if (vaccineRepository.existsByPetid(vaccine.getPetid())) {
            Optional<Vaccine> vaccine1 = vaccineRepository.findByPetid(vaccine.getPetid());
            if (vaccine1.isPresent()) {
                Vaccine vaccine2 = vaccine1.get();
                if (vaccine2 != null) {
                    vaccine2.setV1(vaccine.getV1());
                    vaccine2.setV2(vaccine.getV2());
                    vaccine2.setV3(vaccine.getV3());
                    vaccine2.setV4(vaccine.getV4());
                    vaccine2.setTest(vaccine.getTest());
                    vaccine2.setV5(vaccine.getV5());
                    vaccineRepository.save(vaccine2);
                    return ResultJson.returnResult(ResponseStatusCode.SUCCESS.getStatusCode(), ResponseStatusCode.SUCCESS.getMsg(), vaccine);
                }
            }
        }
        return ResultJson.returnResult(ResponseStatusCode.NOT_FOUND.getStatusCode(), ResponseStatusCode.NOT_FOUND.getMsg(), null);
    }

    @GetMapping("/show")
    public ResultJson show(Vaccine vaccine) {
        return ResultJson.returnResult(ResponseStatusCode.SUCCESS.getStatusCode(), ResponseStatusCode.SUCCESS.getMsg(), vaccineRepository.findByPetid(vaccine.getPetid()));
    }

    @GetMapping("/findAll")
    public List<Vaccine> findAll() {
        return vaccineRepository.findAll();
    }

}
