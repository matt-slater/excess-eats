package hack.cuny.excesseats.controllers;

import hack.cuny.excesseats.model.*;
import hack.cuny.excesseats.repos.EatsRepo;
import hack.cuny.excesseats.repos.ProducerRepo;
import hack.cuny.excesseats.services.GoogleMapsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/eats")
public class EatsController {

    private final EatsRepo eatsRepo;
    private final ProducerRepo producerRepo;
    private final GoogleMapsService googleMapsService;

    @Autowired
    EatsController(EatsRepo eatsRepo, ProducerRepo producerRepo, GoogleMapsService googleMapsService) {
        this.producerRepo = producerRepo;
        this.eatsRepo = eatsRepo;
        this.googleMapsService = googleMapsService;
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
        System.out.println(googleMapsService.getDistance(e, "1297 Rogers Avenue Brooklyn, NY"));
        return new EatsDTO(e);
    }

    @RequestMapping(method = RequestMethod.POST, value="/producer/{producerId}")
    Eats addOne(@PathVariable long producerId, @RequestBody EatsPostDTO dto) {
        Producer p = producerRepo.findById(producerId);
        return eatsRepo.save(new Eats(dto, p));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/upvote/{id}")
    Eats upvote(@PathVariable long id) {
        Eats e = eatsRepo.findById(id);
        long rating = e.getRating();
        e.setRating(rating + 1);
        return eatsRepo.save(e);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/downvote/{id}")
    Eats downvote(@PathVariable long id) {
        Eats e = eatsRepo.findById(id);
        long rating = e.getRating();
        e.setRating(rating - 1);
        return eatsRepo.save(e);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/order/rating")
    List<EatsDTO> findAllOrderByRating() {
        List<Eats>  list = eatsRepo.findAllByOrderByRatingDesc();
        return list.stream().map(eat -> new EatsDTO(eat)).collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, value = "/order/expires")
    List<EatsDTO> findAllOrderByExpires() {
        List<Eats>  list = eatsRepo.findAllByOrderByExpiresDesc();
        return list.stream().map(eat -> new EatsDTO(eat)).collect(Collectors.toList());

    }

    @RequestMapping(method = RequestMethod.GET, value = "/order/distance")
    List<EatsDTO> findAllOrderByDistance() {
        List<Eats>  list = eatsRepo.findAll();
        for (Eats e : list) {
            DistanceTuple dt = googleMapsService.getDistance(e, "22 Warrington Ave Brooklyn, NY" );
            e.setDistanceString(dt.getHumanReadable());
            e.setDistance(dt.getDistance());
            eatsRepo.save(e);
        }
        Collections.sort(list, new DistanceComparator());

        return list.stream().map(eat -> new EatsDTO(eat)).collect(Collectors.toList());

    }

    @RequestMapping(method = RequestMethod.GET, value = "/order/price")
    List<EatsDTO> findAllSortByPrice() {
        List<Eats>  list = eatsRepo.findAll();
        List<EatsDTO> dtos = list.stream().map(eat -> new EatsDTO(eat)).collect(Collectors.toList());
        Collections.sort(dtos, new PriceComparator());
        return dtos;
    }


}
