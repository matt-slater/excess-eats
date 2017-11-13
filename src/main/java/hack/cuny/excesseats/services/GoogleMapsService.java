package hack.cuny.excesseats.services;

import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.Unit;
import hack.cuny.excesseats.model.DistanceTuple;
import hack.cuny.excesseats.model.Eats;
import hack.cuny.excesseats.repos.ProducerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class GoogleMapsService {

    @Value("${google.maps.api.key}")
    private String apiKey;

    private final ProducerRepo producerRepo;

    private GeoApiContext geoApiContext;

    @Autowired
    GoogleMapsService(ProducerRepo producerRepo) {
        this.producerRepo = producerRepo;
        System.out.println(apiKey);

    }

    @PostConstruct
    public void init() {
        geoApiContext = new GeoApiContext.Builder()
                .apiKey(apiKey)
                .build();
    }

    public DistanceTuple getDistance(Eats e, String userAddress) {
        DistanceMatrix result = null;
        String eatAddress = producerRepo.findById(e.getProducer().getId()).getAddress();
        String[] origin = {userAddress};
        String[] destination = {eatAddress};
        try {
            result = DistanceMatrixApi.getDistanceMatrix(geoApiContext, origin, destination).units(Unit.IMPERIAL).await();
        } catch (Exception err) {
            err.printStackTrace();
        }
        return new DistanceTuple(result.rows[0].elements[0].distance.humanReadable, result.rows[0].elements[0].distance.inMeters);
    }

}
