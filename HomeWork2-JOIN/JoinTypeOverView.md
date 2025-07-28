# 🔗 SQL JOINs – Professors & Courses Example

This README explains all SQL JOIN types using two related tables:

---

## 📚 Table: Professors

| prof\_id | full\_name      | department    |
| -------- | --------------- | ------------- |
| 1        | Dr. Alice Smith | Computer Sci. |
| 2        | Dr. Bob Johnson | Mathematics   |
| 3        | Dr. Carol Baker | Physics       |

---

## 🏫 Table: Courses

| course\_id | course\_name      | assigned\_prof |
| ---------- | ----------------- | -------------- |
| 101        | Data Structures   | 1              |
| 102        | Calculus          | 2              |
| 103        | Quantum Mechanics | 4              |

---

## 1. 🤝 INNER JOIN

Returns only matching records from both tables.

```sql
SELECT * FROM Professors
INNER JOIN Courses ON Professors.prof_id = Courses.assigned_prof;
```

📀 Shows professors who have courses assigned.

| prof\_id | full\_name      | department    | course\_id | course\_name    | assigned\_prof |
| -------- | --------------- | ------------- | ---------- | --------------- | -------------- |
| 1        | Dr. Alice Smith | Computer Sci. | 101        | Data Structures | 1              |
| 2        | Dr. Bob Johnson | Mathematics   | 102        | Calculus        | 2              |

---

## 2. 🖙 LEFT JOIN

Returns all records from the left table (`Professors`), and matched rows from the right (`Courses`).

```sql
SELECT * FROM Professors
LEFT JOIN Courses ON Professors.prof_id = Courses.assigned_prof;
```

📀 Shows all professors, even those with no assigned course.

| prof\_id | full\_name      | department    | course\_id | course\_name    | assigned\_prof |
| -------- | --------------- | ------------- | ---------- | --------------- | -------------- |
| 1        | Dr. Alice Smith | Computer Sci. | 101        | Data Structures | 1              |
| 2        | Dr. Bob Johnson | Mathematics   | 102        | Calculus        | 2              |
| 3        | Dr. Carol Baker | Physics       | NULL       | NULL            | NULL           |

---

## 3. 🖜 RIGHT JOIN

Returns all records from the right table (`Courses`), and matched rows from the left (`Professors`).

```sql
SELECT * FROM Professors
RIGHT JOIN Courses ON Professors.prof_id = Courses.assigned_prof;
```

📀 Shows all courses, even if assigned to non-existent professors.

| prof\_id | full\_name      | department    | course\_id | course\_name      | assigned\_prof |
| -------- | --------------- | ------------- | ---------- | ----------------- | -------------- |
| 1        | Dr. Alice Smith | Computer Sci. | 101        | Data Structures   | 1              |
| 2        | Dr. Bob Johnson | Mathematics   | 102        | Calculus          | 2              |
| NULL     | NULL            | NULL          | 103        | Quantum Mechanics | 4              |

---

## 4. 🌐 FULL OUTER JOIN

Returns all records from both tables. Unmatched data will have `NULL` values.

> ⚠️ MySQL doesn't support `FULL JOIN` natively — you can emulate it using `UNION`.

```sql
SELECT * FROM Professors
LEFT JOIN Courses ON Professors.prof_id = Courses.assigned_prof
UNION
SELECT * FROM Professors
RIGHT JOIN Courses ON Professors.prof_id = Courses.assigned_prof;
```

📀 All professors and all courses — whether matched or not.

| prof\_id | full\_name      | department    | course\_id | course\_name      | assigned\_prof |
| -------- | --------------- | ------------- | ---------- | ----------------- | -------------- |
| 1        | Dr. Alice Smith | Computer Sci. | 101        | Data Structures   | 1              |
| 2        | Dr. Bob Johnson | Mathematics   | 102        | Calculus          | 2              |
| 3        | Dr. Carol Baker | Physics       | NULL       | NULL              | NULL           |
| NULL     | NULL            | NULL          | 103        | Quantum Mechanics | 4              |

---

## 5. ❌ CROSS JOIN

Returns the **Cartesian product** — all combinations of professors and courses.

```sql
SELECT * FROM Professors
CROSS JOIN Courses;
```

🚨 3 professors × 3 courses = **9 rows** total.

Use carefully in large tables!

---

## 6. 🔁 SELF JOIN

Join a table with itself — useful for hierarchical relationships.

```sql
-- If Professors had a supervisor_id column:
SELECT A.full_name AS professor, B.full_name AS supervisor
FROM Professors A
JOIN Professors B ON A.supervisor_id = B.prof_id;
```

---

## ✅ Summary Table

| Join Type    | Description                                        |
| ------------ | -------------------------------------------------- |
| `INNER JOIN` | Matching rows from both tables                     |
| `LEFT JOIN`  | All from left + matched rows from right            |
| `RIGHT JOIN` | All from right + matched rows from left            |
| `FULL JOIN`  | All rows from both tables                          |
| `CROSS JOIN` | Cartesian product (every A with every B)           |
| `SELF JOIN`  | Table joined with itself (e.g., parent-child link) |

---

## 💡 When to Use Each

* Use **`INNER JOIN`** when you only want matching records
* Use **`LEFT JOIN`** when left-side data is the focus (e.g., all professors)
* Use **`RIGHT JOIN`** when right-side data is the focus (e.g., all courses)
* Use **`FULL JOIN`** when you want a full picture of both tables
* Use **`CROSS JOIN`** only when all combinations are needed
* Use **`SELF JOIN`** for hierarchical or recursive relationships

---
