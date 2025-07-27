-- Table: Professors
CREATE TABLE Professors (
    prof_id INT PRIMARY KEY,
    full_name VARCHAR(100),
    department VARCHAR(50)
);

-- Table: Courses
CREATE TABLE Courses (
    course_id INT PRIMARY KEY,
    course_name VARCHAR(100),
    assigned_prof INT, -- foreign key to Professors
    FOREIGN KEY (assigned_prof) REFERENCES Professors(prof_id)
);
