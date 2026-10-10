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


-- Fresh seed data for coach table
INSERT INTO coach (first_name, last_name, specialty, experience_years, email)
VALUES
    ('Arjun', 'Nair', 'Tennis', 12, 'arjun.nair@example.com'),
    ('Neha', 'Kapoor', 'Badminton', 6, 'neha.kapoor@example.com'),
    ('Vikram', 'Reddy', 'Cricket', 15, 'vikram.reddy@example.com'),
    ('Pooja', 'Desai', 'Yoga', 9, 'pooja.desai@example.com'),
    ('Kabir', 'Chowdhury', 'Table Tennis', 11, 'kabir.chowdhury@example.com'),
    ('Rina', 'Mukherjee', 'Athletics', 7, 'rina.mukherjee@example.com');

-- Fresh seed data for student table
INSERT INTO student (first_name, last_name, email, enrollment_date, major, coach_id)
VALUES
    ('Divya', 'Rao', 'divya.rao@example.com', '2026-06-18', 'Economics', 12),
    ('Manish', 'Gupta', 'manish.gupta@example.com', '2026-07-22', 'Physics', 6),
    ('Ritika', 'Bansal', 'ritika.bansal@example.com', '2026-08-30', 'Chemistry', 7),
    ('Siddharth', 'Iyer', 'siddharth.iyer@example.com', '2026-09-14', 'Mathematics', 8),
    ('Alok', 'Chopra', 'alok.chopra@example.com', '2026-09-25', 'History', 12),
    ('Nisha', 'Thakur', 'nisha.thakur@example.com', '2026-10-01', 'Political Science', 6),
    ('Rohan', 'Das', 'rohan.das@example.com', '2026-10-05', 'Philosophy', 7),
    ('Mehul', 'Saxena', 'mehul.saxena@example.com', '2026-10-10', 'English Literature', 8),
    ('Tanya', 'Arora', 'tanya.arora@example.com', '2026-10-12', 'Fine Arts', 6),
    ('Deepak', 'Menon', 'deepak.menon@example.com', '2026-10-15', 'Computer Engineering', 12);


-- Fresh student seed data (coach_id 1–4, 6–12 only)
INSERT INTO student (first_name, last_name, email, enrollment_date, major, coach_id)
VALUES
    ('Ishita', 'Kapoor', 'ishita.kapoor@example.com', '2026-10-20', 'Data Science', 1),
    ('Raghav', 'Shah', 'raghav.shah@example.com', '2026-10-22', 'Electrical Engineering', 2),
    ('Maya', 'Pillai', 'maya.pillai@example.com', '2026-10-25', 'Psychology', 3),
    ('Aditya', 'Rana', 'aditya.rana@example.com', '2026-10-28', 'Civil Engineering', 4),
    ('Sonal', 'Bhatt', 'sonal.bhatt@example.com', '2026-11-01', 'Statistics', 6),
    ('Varun', 'Chatterjee', 'varun.chatterjee@example.com', '2026-11-03', 'Political Science', 7),
    ('Kavya', 'Menon', 'kavya.menon@example.com', '2026-11-05', 'Economics', 8),
    ('Nitin', 'Yadav', 'nitin.yadav@example.com', '2026-11-07', 'Computer Engineering', 9),
    ('Pallavi', 'Sethi', 'pallavi.sethi@example.com', '2026-11-09', 'Fine Arts', 10),
    ('Armaan', 'Gill', 'armaan.gill@example.com', '2026-11-11', 'Philosophy', 11),
    ('Shruti', 'Deshmukh', 'shruti.deshmukh@example.com', '2026-11-13', 'Mathematics', 12);


-- Additional student seed data for coach_id = 12
INSERT INTO student (first_name, last_name, email, enrollment_date, major, coach_id)
VALUES
    ('Ananya', 'Sharma', 'ananya.sharma@example.com', '2026-11-15', 'Computer Science', 12),
    ('Rohit', 'Verma', 'rohit.verma@example.com', '2026-11-16', 'Mechanical Engineering', 12),
    ('Snehal', 'Patil', 'snehal.patil@example.com', '2026-11-17', 'Biotechnology', 12),
    ('Kunal', 'Rastogi', 'kunal.rastogi@example.com', '2026-11-18', 'Economics', 12),
    ('Meera', 'Iyer', 'meera.iyer@example.com', '2026-11-19', 'Mathematics', 12),
    ('Dev', 'Chopra', 'dev.chopra@example.com', '2026-11-20', 'Political Science', 12),
    ('Pooja', 'Reddy', 'pooja.reddy@example.com', '2026-11-21', 'Fine Arts', 12),
    ('Arvind', 'Nair', 'arvind.nair@example.com', '2026-11-22', 'Philosophy', 12),
    ('Tanya', 'Singh', 'tanya.singh@example.com', '2026-11-23', 'History', 12),
    ('Suresh', 'Menon', 'suresh.menon@example.com', '2026-11-24', 'Statistics', 12);

-- Additional student seed data for coach_id = 3
INSERT INTO student (first_name, last_name, email, enrollment_date, major, coach_id)
VALUES
    ('Harsh', 'Tiwari', 'harsh.tiwari@example.com', '2026-11-25', 'Microbiology', 3),
    ('Shalini', 'Mishra', 'shalini.mishra@example.com', '2026-11-26', 'Zoology', 3),
    ('Vivek', 'Agarwal', 'vivek.agarwal@example.com', '2026-11-27', 'Botany', 3),
    ('Nidhi', 'Chauhan', 'nidhi.chauhan@example.com', '2026-11-28', 'Genetics', 3),
    ('Rajeev', 'Bhatnagar', 'rajeev.bhatnagar@example.com', '2026-11-29', 'Biochemistry', 3),
    ('Pallavi', 'Joshi', 'pallavi.joshi@example.com', '2026-11-30', 'Environmental Science', 3),
    ('Saurabh', 'Khanna', 'saurabh.khanna@example.com', '2026-12-01', 'Molecular Biology', 3),
    ('Ankita', 'Rao', 'ankita.rao@example.com', '2026-12-02', 'Neuroscience', 3),
    ('Deepak', 'Shukla', 'deepak.shukla@example.com', '2026-12-03', 'Biomedical Engineering', 3),
    ('Kritika', 'Sen', 'kritika.sen@example.com', '2026-12-04', 'Pharmacology', 3);

