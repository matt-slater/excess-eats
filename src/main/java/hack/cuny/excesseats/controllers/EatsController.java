package hack.cuny.excesseats.controllers;

import hack.cuny.excesseats.model.Eats;
import hack.cuny.excesseats.model.EatsDTO;
import hack.cuny.excesseats.model.EatsPostDTO;
import hack.cuny.excesseats.model.Producer;
import hack.cuny.excesseats.repos.EatsRepo;
import hack.cuny.excesseats.repos.ProducerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/eats")
public class EatsController {

    private final EatsRepo eatsRepo;
    private final ProducerRepo producerRepo;

    @Autowired
    EatsController(EatsRepo eatsRepo, ProducerRepo producerRepo) {
        this.producerRepo = producerRepo;
        this.eatsRepo = eatsRepo;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    Collection<EatsDTO> getAll() {
        List<Eats> eats = eatsRepo.findAll();
        return eats.stream().map(eat -> new EatsDTO(eat)).collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/producer/{id}")
    Collection<EatsDTO> getByProducerId(@PathVariable("id") long id) {
        List<Eats> eats = eatsRepo.findByProducerId(id);

        return eats.stream().map(eat -> new EatsDTO(eat)).collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, value ="/{id}")
    EatsDTO findOne(@PathVariable("id") long id) {
        Eats e = eatsRepo.findById(id);
        return new EatsDTO(e);
    }

    @RequestMapping(method = RequestMethod.POST, value="/producer/{producerId}")
    Eats addOne(@PathVariable long producerId, @RequestBody EatsPostDTO dto) {
        Producer p = producerRepo.findById(producerId);
        return eatsRepo.save(new Eats(dto, p));
    }

}
