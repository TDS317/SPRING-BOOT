# LeetCode Practice Suite (Spring Boot Java)

This project is a Spring Boot console application that demonstrates clean, modular solutions to **9 popular LeetCode-style problems**, organized into two categories:

* **Array & ArrayList Problems** (6)
* **Linked List Problems** (3)

Each problem is encapsulated in its own Java class with a `solve()` method, and the main application runs all of them at startup.

---

## 🚀 Run Instructions

* **Java Version**: 17
* **Spring Boot**: 3.5.4
* **Build Tool**: Maven

### ▶️ To Run:

```bash
./mvnw spring-boot:run
```

Or in IDE: run the `LeetCodeApplication.java` main class.

---

## 🧠 Problem Overview

### 📂 Array & ArrayList Problems

|  # | Problem Name                 | Class Name           | Description                                               | Difficulty |
| -: | ---------------------------- | -------------------- | --------------------------------------------------------- | ---------- |
|  1 | Two Sum                      | `TwoSum`             | Find indices of two numbers that add up to a target.      | Easy       |
|  2 | Best Time to Buy Stock       | `BestTimeToBuyStock` | Find max profit from one buy-sell transaction.            | Easy       |
|  3 | Product of Array Except Self | `ProductExceptSelf`  | Return array where each element is the product of others. | Medium     |
|  4 | Pascal's Triangle            | `PascalsTriangle`    | Generate the first N rows of Pascal’s Triangle.           | Easy       |
|  5 | Summary Ranges               | `SummaryRanges`      | Summarize consecutive number ranges in a sorted array.    | Easy       |
|  6 | Spiral Matrix                | `SpiralMatrix`       | Return elements of a matrix in spiral order.              | Medium     |

---

### 🔗 Linked List Problems

|  # | Problem Name           | Class Name            | Description                                       | Difficulty |
| -: | ---------------------- | --------------------- | ------------------------------------------------- | ---------- |
|  7 | Reverse Linked List    | `ReverseLinkedList`   | Reverse the entire singly linked list.            | Easy       |
|  8 | Merge Two Sorted Lists | `MergeTwoSortedLists` | Merge two sorted linked lists into one.           | Easy       |
|  9 | Linked List Cycle      | `LinkedListCycle`     | Detect whether a cycle exists in the linked list. | Easy       |

---

## 🏗 Project Structure

```bash
src/main/java/com/example/LeetCode/
├── LeetCodeApplication.java        # Spring Boot app starter
├── Main.java                       # Runs all problems with example input
├── ListNode.java                   # Shared ListNode class for Linked List problems
├── TwoSum.java
├── BestTimeToBuyStock.java
├── ProductExceptSelf.java
├── PascalsTriangle.java
├── SummaryRanges.java
├── SpiralMatrix.java
├── ReverseLinkedList.java
├── MergeTwoSortedLists.java
└── LinkedListCycle.java
```

---

## ✨ Features

* 🧩 Modular problem separation
* 🎯 Simple and testable structure
* 📦 Uses Spring Boot lifecycle (`@PostConstruct`) to run all problems automatically

---

## 📌 Notes

* All problems are run from the `Main` class or `@PostConstruct` in `LeetCodeApplication`.

---

