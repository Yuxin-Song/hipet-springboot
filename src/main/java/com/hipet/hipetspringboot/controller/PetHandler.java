package com.hipet.hipetspringboot.controller;

import com.hipet.hipetspringboot.entity.Pet;
import com.hipet.hipetspringboot.jsonify.ResponseStatusCode;
import com.hipet.hipetspringboot.jsonify.ResultJson;
import com.hipet.hipetspringboot.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// REMIND: change it when you need it.
@CrossOrigin
        //(origins = "http://localhost:8080", maxAge = 3600)
@RestController
@RequestMapping("/pet")
public class PetHandler {
    @Autowired
    private PetRepository petRepository;

    @PostMapping("/add")
    public ResultJson add(@RequestBody Pet pet) {
        Pet pet1 = new Pet();
        pet1.setOwnerid(pet.getOwnerid());
        pet1.setPetname(pet.getPetname());
        pet1.setPetsex(pet.getPetsex());
        pet1.setPetbreed(pet.getPetbreed());
        pet1.setPetbirth(pet.getPetbirth());
        pet1.setPetpreg(pet.getPetpreg());
        pet1.setPetdeworm(pet.getPetdeworm());

        petRepository.save(pet1);

        return ResultJson.returnResult(ResponseStatusCode.CREATED.getStatusCode(), ResponseStatusCode.CREATED.getMsg(), pet1);
    }

    @DeleteMapping("/delete")
    public ResultJson delete(@RequestBody Pet pet) {
        if (petRepository.existsById(pet.getPetid())) {
            petRepository.deleteById(pet.getPetid());
            return ResultJson.returnResult(ResponseStatusCode.SUCCESS.getStatusCode(), ResponseStatusCode.SUCCESS.getMsg(), pet);
        }
        return ResultJson.returnResult(ResponseStatusCode.NOT_FOUND.getStatusCode(), ResponseStatusCode.NOT_FOUND.getMsg(), null);
    }

    @PutMapping("/update")
    public ResultJson update(@RequestBody Pet pet) {
        if (petRepository.existsById(pet.getPetid())) {
            Optional<Pet> pet1 = petRepository.findById(pet.getPetid());
            if (pet1.isPresent()) {
                Pet pet2 = pet1.get();
                if (pet2 != null) {
                    pet2.setPetname(pet.getPetname());
                    pet2.setPetsex(pet.getPetsex());
                    pet2.setPetbreed(pet.getPetbreed());
                    pet2.setPetbirth(pet.getPetbirth());
                    pet2.setPetpreg(pet.getPetpreg());
                    pet2.setPetdeworm(pet.getPetdeworm());
                    petRepository.save(pet2);
                    return ResultJson.returnResult(ResponseStatusCode.SUCCESS.getStatusCode(), ResponseStatusCode.SUCCESS.getMsg(), pet2);
                }
            }
        }
        return ResultJson.returnResult(ResponseStatusCode.NOT_FOUND.getStatusCode(), ResponseStatusCode.NOT_FOUND.getMsg(), null);
    }

    /**
     * Show all the pet of the owner.
     * */

    @GetMapping("/showAll")
    public ResultJson show(@RequestBody Pet pet) {
        return ResultJson.returnResult(ResponseStatusCode.SUCCESS.getStatusCode(), ResponseStatusCode.SUCCESS.getMsg(), petRepository.findAllByOwnerid(pet.getOwnerid()));
    }

    /**
     * Show one of the pet's details.
     * */

    @GetMapping("/showOne")
    public ResultJson showOne(@RequestBody Pet pet) {
        return ResultJson.returnResult(ResponseStatusCode.SUCCESS.getStatusCode(), ResponseStatusCode.SUCCESS.getMsg(), petRepository.findById(pet.getPetid()));
    }

    @GetMapping("/findAll")
    public List<Pet> findAll() {
        return petRepository.findAll();
    }
}
