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

			Producer p = producerRepo.save(new Producer("Cafe", "555 1st Avenue", "212-555-3455", "8am-8pm"));
			Producer p1 = producerRepo.save(new Producer("Bakery", "318 W 71st St", "212-567-4243", "7am-5pm"));
			Producer p2 = producerRepo.save(new Producer("Restaurant", "1390 Broadway", "718-912-4383", "9am-12am"));
			eatsRepo.save(new Eats("Half off bread loaves", p, new Date(), false, 2.00, .5));
			eatsRepo.save(new Eats("Burgers", p, new Date(), false, 2.00, .7));
			eatsRepo.save(new Eats("Cupcakes 50% off", p, new Date(), false, 2.00, .4));
			eatsRepo.save(new Eats("Free Coffee", p2, new Date(), false, 2.00, .4));
			eatsRepo.save(new Eats("Pizza", p2, new Date(), false, 7.00, .4));
			eatsRepo.save(new Eats("Gyros 30% off", p2, new Date(), false, 7.00, .2));
			eatsRepo.save(new Eats("Apples 50 cents", p1, new Date(), false, 2.00, .3));
			eatsRepo.save(new Eats("Salad Greens", p1, new Date(), false, 2.00, .3));
			eatsRepo.save(new Eats("Half off Sushi!!", p1, new Date(), false, 2.00, .3));
			eatsRepo.findAll().forEach(System.out::println);
		};


	}

}
