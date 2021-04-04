package com.example.project_test.controller;

import com.example.project_test.domain.Inform;
import com.example.project_test.domain.InformPK;
import com.example.project_test.repo.InformRepo;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/inform")
@AllArgsConstructor
@Log
@CrossOrigin
public class ProjectController {

    private InformRepo informRepo;

    @PostMapping("/save")
    public Inform Create(@RequestBody Inform inform){
        log.info("Handling save users: " + informRepo);
        return informRepo.save(inform);
    }


    @GetMapping("/findAll")
    public List<Inform> findAllInforms(){
        log.info("Handling find all informs request");

        return informRepo.findAll();
    }

    @DeleteMapping("/delete")
    public void Delete(@RequestBody InformPK id){
        log.info("Handling delete inform request: " + id);
        informRepo.deleteById(id);
    }

    @PutMapping("/update")
    public void Update(@RequestBody Struct struct){
        InformPK informPK = new InformPK(struct.getOldDate(), struct.getOldName());
        informRepo.deleteById(informPK);
        Inform inform = new Inform(struct.getNewDate(), struct.getNewName(), struct.getNewPrice());
        this.Create(inform);
    }
}

