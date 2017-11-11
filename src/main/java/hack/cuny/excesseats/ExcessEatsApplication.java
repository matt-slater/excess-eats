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

			Producer p = producerRepo.save(new Producer("Cafe"));
			eatsRepo.save(new Eats("cheap food", p, new Date(), false, 2.00));
			eatsRepo.save(new Eats("bjdwbdwjk", p, new Date(), false, 2.00));
			eatsRepo.save(new Eats("cdwdwidiwj", p, new Date(), false, 2.00));
			eatsRepo.save(new Eats("dwdwhduihdwuhdiuwhd", p, new Date(), false, 2.00));
			eatsRepo.findAll().forEach(System.out::println);
		};


	}

}
