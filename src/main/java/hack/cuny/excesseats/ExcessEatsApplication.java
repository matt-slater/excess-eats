package hack.cuny.excesseats;

import hack.cuny.excesseats.model.Eats;
import hack.cuny.excesseats.model.Producer;
import hack.cuny.excesseats.repos.EatsRepo;
import hack.cuny.excesseats.repos.ProducerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class ExcessEatsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExcessEatsApplication.class, args);
	}

	@Bean
	CommandLineRunner init(EatsRepo eatsRepo, ProducerRepo producerRepo) {

		return args -> {

			Producer p = producerRepo.save(new Producer("Casa Sushi", "555 1st Avenue, New York, NY 10012", "212-555-3455", "8am-8pm"));
			Producer p1 = producerRepo.save(new Producer("J'aime Le Pain", "318 W 71st St, New York, NY 10035", "212-567-4243", "7am-5pm"));
			Producer p2 = producerRepo.save(new Producer("Pasta World", "1390 Broadway, New York, NY 10001", "718-912-4383", "9am-12am"));
			eatsRepo.save(new Eats("Half off Veggie Gyoza", p, new Date(), false, 2.00, .5, 200));
			eatsRepo.save(new Eats("California Rolls 75% off!", p, new Date(), false, 5.00, .75, 346));
			eatsRepo.save(new Eats("Miso Soup 25% off.", p, new Date(), false, 2.00, .25, 29));
			eatsRepo.save(new Eats("Discounted side salads", p2, new Date(), false, 2.00, .25, 72));
			eatsRepo.save(new Eats("Baked Ziti on the cheap!", p2, new Date(), false, 7.00, .50, -5));
			eatsRepo.save(new Eats("Fresh Squid Ink Pasta", p2, new Date(), false, 7.00, .15, 14));
			eatsRepo.save(new Eats("Pain au Chocolat", p1, new Date(), false, 2.00, .50, 674));
			eatsRepo.save(new Eats("Semolina Loaf Half Off!", p1, new Date(), false, 2.00, .5, 23));
			eatsRepo.save(new Eats("Petite Cupcakes on sale!", p1, new Date(), false, 2.00, .25, 742));
			eatsRepo.findAll().forEach(System.out::println);
		};


	}

}
