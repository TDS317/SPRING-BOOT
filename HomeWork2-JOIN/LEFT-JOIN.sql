SELECT c.course_name, p.full_name
FROM Courses c
LEFT JOIN Professors p ON c.assigned_prof = p.prof_id;
