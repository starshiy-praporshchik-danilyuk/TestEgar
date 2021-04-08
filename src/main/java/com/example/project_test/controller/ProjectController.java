package com.example.project_test.controller;

import com.example.project_test.domain.Inform;
import com.example.project_test.domain.InformPK;
import com.example.project_test.repo.InformRepo;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/inform")
@AllArgsConstructor
@Log
@CrossOrigin
public class ProjectController {

    private final InformRepo informRepo;

    @PostMapping
    public Inform Create(@RequestBody Inform inform){
        return informRepo.save(inform);
    }

    @GetMapping
    public List<Inform> findAllInforms(){
        return informRepo.findAll(Sort.by("date"));
    }

    @DeleteMapping
    public void Delete(@RequestBody InformPK id){
        informRepo.deleteById(id);
    }

    @PutMapping
    public void Update(@RequestBody Struct struct){
        InformPK informPK = new InformPK(struct.getOldDate(), struct.getOldName());
        informRepo.deleteById(informPK);
        Inform inform = new Inform(struct.getNewDate(), struct.getNewName(), struct.getNewPrice());
        this.Create(inform);
    }
}

