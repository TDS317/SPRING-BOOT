package CollectionV1.example.Collection;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class CollectionApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CollectionApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		demoArray();
		demoArrayList();
		demoLinkedList();
	}

	// 1. Plain Java array
	private void demoArray() {
		// fixed size at creation time
		String[] fruits = new String[3];
		fruits[0] = "Apple";
		fruits[1] = "Banana";
		fruits[2] = "Cherry";

		System.out.println("=== Array Demo ===");
		// super‐fast random access (O(1)):
		System.out.println("fruits[1] = " + fruits[1]);

		// strength: minimal overhead, predictable memory
		System.out.println("Array length = " + fruits.length);
		System.out.println();
	}

	// 2. ArrayList
	private void demoArrayList() {
		List<String> colors = new ArrayList<>();

		// dynamic resizing; no need to know final size up‑front
		colors.add("Red");
		colors.add("Green");
		colors.add("Blue");

		System.out.println("=== ArrayList Demo ===");
		// still O(1) random access:
		System.out.println("colors.get(2) = " + colors.get(2));

		// can insert/remove:
		colors.add(1, "Yellow");
		colors.remove("Green");

		System.out.println("After insert/remove: " + colors);
		// strength: great for read‑heavy workloads, good cache locality
		System.out.printf("Current size = %d (capacity grows automatically)%n", colors.size());
		System.out.println();
	}

	// 3. LinkedList
	private void demoLinkedList() {
		LinkedList<Integer> numbers = new LinkedList<>();

		// no resizing needed—nodes link dynamically
		numbers.add(10);
		numbers.add(20);
		numbers.addFirst(5);
		numbers.addLast(30);

		System.out.println("=== LinkedList Demo ===");
		// fast insert/remove at ends (O(1) for addFirst/addLast):
		System.out.println("First element = " + numbers.getFirst());
		System.out.println("Last element = " + numbers.getLast());

		// removal in the middle by value:
		numbers.remove(Integer.valueOf(20));
		System.out.println("After removal: " + numbers);

		// strength: ideal for frequent insertions/deletions (especially at head/tail)
		System.out.printf("List size = %d, iteration cost ~O(n)%n", numbers.size());
		System.out.println();
	}
}