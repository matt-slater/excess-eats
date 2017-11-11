package hack.cuny.excesseats.controllers;

import hack.cuny.excesseats.model.Eats;
import hack.cuny.excesseats.repos.EatsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/eats")
public class EatsController {

    private final EatsRepo eatsRepo;

    @Autowired
    EatsController(EatsRepo eatsRepo) {
        this.eatsRepo = eatsRepo;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    Collection<Eats> getAll() {
        return eatsRepo.findAll();
    }

}
