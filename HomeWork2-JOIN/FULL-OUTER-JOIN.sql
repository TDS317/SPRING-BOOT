SELECT p.full_name, c.course_name
FROM Courses c
FULL OUTER JOIN Professors p ON c.assigned_prof = p.prof_id;
