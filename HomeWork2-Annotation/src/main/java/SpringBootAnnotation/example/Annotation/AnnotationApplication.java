package SpringBootAnnotation.example.Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class AnnotationApplication implements CommandLineRunner {

	@Autowired
	private ApplicationContext context;

	public static void main(String[] args) {
		SpringApplication.run(AnnotationApplication.class, args);
	}

	@Override
	public void run(String... args) {
		System.out.println("💡 Beans discovered by @ComponentScan:");
		String[] beanNames = context.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String name : beanNames) {
			System.out.println("🔹 " + name);
		}

	}
}