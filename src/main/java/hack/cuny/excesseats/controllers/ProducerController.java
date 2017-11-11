package hack.cuny.excesseats.controllers;

import hack.cuny.excesseats.model.Producer;
import hack.cuny.excesseats.model.ProducerDTO;
import hack.cuny.excesseats.repos.ProducerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/prods")
public class ProducerController {

    private final ProducerRepo producerRepo;

    @Autowired
    ProducerController(ProducerRepo producerRepo) {
        this.producerRepo = producerRepo;
    }


    @RequestMapping(method = RequestMethod.GET)
    List<ProducerDTO> findAll() {
        List<Producer> list = producerRepo.findAll();
        return list.stream().map(producer -> new ProducerDTO(producer)).collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, path="/{id}")
    ProducerDTO findOne(@PathVariable("id") long id) {
        Producer p = producerRepo.findById(id);
        return new ProducerDTO(p);
    }





}
