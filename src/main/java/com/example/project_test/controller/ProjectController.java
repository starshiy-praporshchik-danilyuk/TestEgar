package com.example.project_test.controller;

import com.example.project_test.domain.Inform;
//import com.example.project_test.dto.InformsDto;
import com.example.project_test.repo.InformRepo;
//import com.example.project_test.service.InformsService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inform")
@AllArgsConstructor
@Log
@CrossOrigin
public class ProjectController {

    //private final InformsService informsService;
    private InformRepo informRepo;

    //@Autowired
    //public ProjectController(InformRepo informRepo){
      //  this.informRepo = informRepo;
    //}

    //@GetMapping
    //public List<Inform> list(){
        //return (List<Inform>) informRepo.findAll();
    //}

   // @PostMapping("/save")
   // public InformsDto Create(@RequestBody InformsDto informsDto){
    //    log.info("Handling save users: " + informsDto);
   //     return informsService.saveInform(informsDto);
    //}

    @PostMapping("/save")
    public Inform Create(@RequestBody Inform inform){
        log.info("Handling save users: " + informRepo);
        return informRepo.save(inform);
    }

   // @GetMapping("/findAll")
   // public List<InformsDto> findAllInforms(){
   //     log.info("Handling find all informs request");
    //    return informsService.findAll();
   // }

    @GetMapping("/findAll")
    public List<Inform> findAllInforms(){
        log.info("Handling find all informs request");
        return informRepo.findAll();
    }
}

