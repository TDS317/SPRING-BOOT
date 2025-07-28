package com.example.LeetCode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;
import java.util.*;

@SpringBootApplication
public class LeetCodeApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeetCodeApplication.class, args);
	}

	@PostConstruct
	public void runAllLeetCodeSolutions() {
		System.out.println("=== TwoSum ===");
		System.out.println(Arrays.toString(TwoSum.solve(new int[]{2, 7, 11, 15}, 9)));

		System.out.println("\n=== BestTimeToBuyStock ===");
		System.out.println(BestTimeToBuyStock.solve(new int[]{7, 1, 5, 3, 6, 4}));

		System.out.println("\n=== ProductExceptSelf ===");
		System.out.println(Arrays.toString(ProductExceptSelf.solve(new int[]{1, 2, 3, 4})));

		System.out.println("\n=== PascalsTriangle ===");
		List<List<Integer>> triangle = PascalsTriangle.generate(5);
		triangle.forEach(System.out::println);

		System.out.println("\n=== SummaryRanges ===");
		System.out.println(SummaryRanges.solve(new int[]{0, 1, 2, 4, 5, 7}));

		System.out.println("\n=== SpiralMatrix ===");
		int[][] input = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		System.out.println(SpiralMatrix.solve(input));


		System.out.println("\n=== ReverseLinkedList ===");
		ListNode head = ListNode.fromArray(new int[]{1, 2, 3, 4, 5});
		ListNode reversed = ReverseLinkedList.solve(head);
		ListNode.print(reversed);

		System.out.println("\n=== MergeTwoSortedLists ===");
		ListNode l1 = ListNode.fromArray(new int[]{1, 2, 4});
		ListNode l2 = ListNode.fromArray(new int[]{1, 3, 4});
		ListNode merged = MergeTwoSortedLists.solve(l1, l2);
		ListNode.print(merged);

		System.out.println("\n=== LinkedListCycle ===");
		ListNode cycleHead = ListNode.fromArray(new int[]{3, 2, 0, -4});
		cycleHead.next.next.next.next = cycleHead.next; // create cycle
		System.out.println(LinkedListCycle.solve(cycleHead)); // true
	}
}
