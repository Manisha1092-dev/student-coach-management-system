package com.management.org.student_coach_management.Student;

import com.management.org.student_coach_management.Student.dto.StudentDTO;
import jakarta.validation.Valid;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller exposing endpoints to manage Student resources.
 * Supports creating, listing (with pagination/sorting), retrieving, updating
 * and deleting Student records.
 */
@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentDTO> createStudent(@Valid @RequestBody StudentDTO studentDTO) {
        return new ResponseEntity<>(studentService.createStudent(studentDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getStudents(@RequestParam(required = false, defaultValue = "0") int pageNo,
                                                        @RequestParam(required = false, defaultValue = "5") int pageSize,
                                                        @RequestParam(required = false, defaultValue = "id") String sortBy,
                                                        @RequestParam(required = false, defaultValue = "asc") String sortDir,
                                                        @RequestParam(required = false) String firstName,
                                                        @RequestParam(required = false) String lastName,
                                                        @RequestParam(required = false) String major,
                                                        @RequestParam(required = false) String email) {
        Sort sort = Sort.by(sortDir.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC, sortBy);
        return new ResponseEntity<>(studentService.getStudents(firstName, lastName, major, email, PageRequest.of(pageNo, pageSize, sort)), HttpStatus.OK);

        /**
         *
         * /*
         *  How pagination + sorting works in Spring Data:
         *
         *  1. Sorting is applied first across the entire dataset
         *     (e.g., ORDER BY firstName ASC or DESC in SQL).
         *
         *  2. Pagination is applied next using LIMIT and OFFSET
         *     (pageNo decides the offset, pageSize decides how many rows to fetch).
         *
         *  Examples:
         *  - curl ...?pageSize=15 → returns all coaches (since total < 15),
         *    default sort by id ascending.
         *
         *  - curl ...?pageNo=0&pageSize=3&sortBy=firstName&sortDir=asc →
         *    sorts all coaches alphabetically A→Z, then returns the first 3.
         *
         *  - curl ...?pageNo=0&pageSize=3&sortBy=firstName&sortDir=desc →
         *    sorts all coaches alphabetically Z→A, then returns the first 3.
         *
         *  In short: Spring Data always sorts the full dataset first,
         *  then slices out the requested page.
         *
         *
         * SELECT * FROM students
         * ORDER BY first_name DESC
         * LIMIT 3 OFFSET 0;
         */

    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable int id) {
        return new ResponseEntity<>(studentService.getStudent(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@PathVariable int id, @RequestBody StudentDTO studentDTO) {
        StudentDTO updatedStudent = studentService.updateStudent(id, studentDTO);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int id) {
        studentService.deleteStudent(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
