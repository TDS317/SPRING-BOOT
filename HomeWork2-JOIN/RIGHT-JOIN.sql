SELECT p.full_name, c.course_name
FROM Courses c
RIGHT JOIN Professors p ON c.assigned_prof = p.prof_id;
