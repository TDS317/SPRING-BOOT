SELECT c.course_name, p.full_name, p.department
FROM Courses c
INNER JOIN Professors p ON c.assigned_prof = p.prof_id;
