-- Seed data for coach table
INSERT INTO coach (first_name, last_name, specialty, experience_years, email)
VALUES
    ('Ravi', 'Sharma', 'Football', 10, 'ravi.sharma@example.com'),
    ('Anita', 'Verma', 'Swimming', 7, 'anita.verma@example.com'),
    ('Suresh', 'Patel', 'Fitness', 5, 'suresh.patel@example.com'),
    ('Meena', 'Kaur', 'Basketball', 8, 'meena.kaur@example.com');

-- Seed data for student table
INSERT INTO student (first_name, last_name, email, enrollment_date, major, coach_id)
VALUES
    ('Amit', 'Kumar', 'amit.kumar@example.com', '2026-01-15', 'Computer Science', 1),
    ('Priya', 'Singh', 'priya.singh@example.com', '2026-02-10', 'Business Administration', 2),
    ('Rahul', 'Mehta', 'rahul.mehta@example.com', '2026-03-05', 'Mechanical Engineering', 1),
    ('Sneha', 'Joshi', 'sneha.joshi@example.com', '2026-04-20', 'Biology', 3),
    ('Karan', 'Malhotra', 'karan.malhotra@example.com', '2026-05-12', 'Sports Science', 4);
