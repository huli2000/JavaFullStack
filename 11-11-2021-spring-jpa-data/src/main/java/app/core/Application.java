package app.core;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import javax.persistence.GenerationType;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Sort;

import app.core.entities.Student;
import app.core.entities.Student.Gender;
import app.core.repo.StudentRepo;
import app.core.service.StudentService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(Application.class, args);
		StudentRepo studentRepo = ctx.getBean(StudentRepo.class);
		StudentService studentService = ctx.getBean(StudentService.class);
		{// create students
			studentRepo.save(new Student(0, "Ran", 25, "ran@gmail.com", Gender.M, LocalDate.of(2010, 1, 15), true));
			studentRepo.save(new Student(0, "Ran", 28, "ranxxx@gmail.com", Gender.M, LocalDate.of(2014, 2, 17), false));
			studentRepo.save(new Student(0, "Ran", 21, "ranmi@gmail.com", Gender.M, LocalDate.of(2012, 4, 5), true));
			studentRepo.save(new Student(0, "Ella", 40, "ella@gmail.com", Gender.F, LocalDate.of(2013, 5, 15), true));
			studentRepo.save(new Student(0, "Mika", 33, "mika@gmail.com", Gender.F, LocalDate.of(2012, 4, 5), false));
			studentRepo.save(new Student(0, "Moshe", 28, "moshe@gmail.com", Gender.M, LocalDate.of(2011, 6, 7), true));
			studentRepo.save(new Student(0, "Eli", 17, "eli@gmail.com", Gender.M, LocalDate.of(2012, 8, 29), false));

			studentRepo.deleteById(5);
		}

		{// get all students
			List<Student> list = studentRepo.findAll(Sort.by("gender", "name"));
			print(list);

		}
		{// get all Females students only

			List<Student> list = studentRepo.getFemales();
			print(list);

		}
		{// get all Males students only

			List<Student> list = studentRepo.getMales();
			print(list);

		}

		{// get all names talmid only

			List<String> list = studentRepo.getNames();
			print(list);

		}
		{// get lower age

			List<Student> list = studentRepo.getOlderThan(35);
			print(list);

		}
		{
			List<Student> list = studentRepo.findByActiveTrue();
			print(list);
		}
		String name = "Ran";
		List<Student> list = studentRepo.findByName(name);
		print(list);
		System.out.println(studentRepo.countByName(name));

	}

	public static <T> void print(Collection<T> col) {
		System.out.println("================");
		for (T curr : col) {
			System.out.println(curr);
		}
		System.out.println("================");
	}
}
