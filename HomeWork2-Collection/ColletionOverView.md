# Java Collections Performance Demo

This project demonstrates the usage and performance of three core Java collection types:

- **Plain Array (`String[]`)**
- **ArrayList (`java.util.ArrayList`)**
- **LinkedList (`java.util.LinkedList`)**

---

## 📌 Overview of Collection Types

| Feature / Operation     | Array       | ArrayList     | LinkedList    |
|-------------------------|-------------|---------------|---------------|
| Size                    | Fixed       | Dynamic       | Dynamic       |
| Random Access           | ✅ O(1)      | ✅ O(1)        | ❌ O(n)        |
| Insert at End           | ❌ N/A       | ✅ O(1)*       | ✅ O(1)        |
| Insert at Beginning     | ❌ N/A       | ❌ O(n)        | ✅ O(1)        |
| Insert in Middle        | ❌ N/A       | ❌ O(n)        | ❌ O(n)        |
| Remove at End           | ❌ N/A       | ✅ O(1)        | ✅ O(1)        |
| Remove in Middle        | ❌ N/A       | ❌ O(n)        | ❌ O(n)        |
| Memory Overhead         | Low         | Moderate      | High (nodes)  |
| Best For                | Fixed data  | Fast reads    | Frequent adds/removes at ends |

\* Amortized: resizing occurs occasionally but isn't costly per operation.

---

## 🧠 Quick Summary: Strengths, Weaknesses & Use Cases

### 🔹 Array (`String[]`)
- **Strengths**:
    - Fastest access (O(1))
    - Low memory overhead
    - Ideal for fixed-size data
- **Weaknesses**:
    - Cannot resize after creation
    - Insertion/removal requires shifting or creating a new array
- **When to Use**:
    - When you know the number of elements in advance
    - Performance-critical applications with no dynamic behavior

---

### 🔸 ArrayList
- **Strengths**:
    - Fast random access (O(1))
    - Automatically resizes when full
    - Efficient iteration
- **Weaknesses**:
    - Insertion/removal at the beginning or middle is slow (O(n))
    - More memory than array (due to dynamic resizing and internal buffer)
- **When to Use**:
    - When you need dynamic resizing and fast access
    - Great for read-heavy workloads

---

### 🔻 LinkedList
- **Strengths**:
    - Fast insertion/removal at head and tail (O(1))
    - No need to shift elements
- **Weaknesses**:
    - Slow random access (O(n))
    - High memory usage (node overhead)
    - Poor cache locality
- **When to Use**:
    - When frequent insertions/deletions at both ends are needed
    - When list traversal is more common than indexing

---

## 🧪 Benchmark Tests Included

This project includes performance tests for:

1. Add to End
2. Add to Beginning
3. Random Access (get)
4. Remove from Middle

Each test runs `100,000` operations using `System.nanoTime()` to compare execution time between `ArrayList` and `LinkedList`.

---

## 📂 Files

- `CollectionsDemo.java` – Basic usage examples of each collection
- `CollectionsSpeedTest.java` – Benchmarks performance

---

## 🚀 How to Run

Compile and run from the terminal:

```bash
javac CollectionsSpeedTest.java
java collectionv1.example.CollectionsSpeedTest
