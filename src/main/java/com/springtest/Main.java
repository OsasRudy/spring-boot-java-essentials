package com.springtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/multisports")
public class Main {
    private final MultisportRepository multisportRepository;
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public Main(MultisportRepository multisportRepository) {
        this.multisportRepository = multisportRepository;
    }

    public static void main(String[] args){
        SpringApplication.run(Main.class, args);
    }
    @GetMapping
    public List<Multisport> getMultisport(){
        return multisportRepository.findAll();
    }

    record NewMultisportRequest(
            String sport_name,
            String competitions,
            String tournament,
            String fixture
    ){

    }
    @PostMapping
    public void addMultisport(@RequestBody NewMultisportRequest request){
        Multisport multisport = new Multisport();
        multisport.setSport_name(request.sport_name);
        multisport.setCompetitions(request.competitions);
        multisport.setTournament(request.tournament);
        multisport.setFixture(request.fixture);
        multisportRepository.save(multisport);
    }

    @DeleteMapping("{multisportId}")
    public void deleteMultisport(@PathVariable("multisportId") Integer id){
        multisportRepository.deleteById(id);
    }
    @PutMapping("{multisportId}")
    public void updateMultisport(@PathVariable("multisportId") Integer id, @RequestBody NewMultisportRequest request){
        Optional<Multisport> optionalMultisport = multisportRepository.findById(id);

        if (optionalMultisport.isPresent()) {
            Multisport multisport = optionalMultisport.get();

            multisport.setSport_name(request.sport_name);
            multisport.setCompetitions(request.competitions);
            multisport.setTournament(request.tournament);
            multisport.setFixture(request.fixture);
            multisportRepository.save(multisport);
        }else{
            logger.info("The id doesn't exists");
        }

    }

}
