package com.management.org.student_coach_management.Student;

import com.management.org.student_coach_management.Student.Exception.StudentNotFoundException;
import com.management.org.student_coach_management.Student.dto.StudentDTO;
import com.management.org.student_coach_management.Student.entity.Student;
import com.management.org.student_coach_management.Student.mapper.StudentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentDTO createStudent(StudentDTO studentDTO) {
        Student student = StudentMapper.toEntity(studentDTO);
        studentRepository.save(student);
        return StudentMapper.toDTO(student);
    }

    @Override
    public List<StudentDTO> getStudents() {
        return studentRepository.findAll().stream().map(StudentMapper::toDTO).toList();
    }

    @Override
    public StudentDTO getStudent(int id) {
        return StudentMapper.toDTO(studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found with ID " + id)));
    }

    @Override
    public StudentDTO updateStudent(int id, StudentDTO studentDTO) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found with ID " + id));
        Student updatedStudent = StudentMapper.toEntity(studentDTO);
        updatedStudent.setId(id);
        studentRepository.save(updatedStudent);
        return StudentMapper.toDTO(updatedStudent);
    }

    @Override
    public void deleteStudent(int id) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException("Student not found with ID " + id));
        studentRepository.delete(existingStudent);
    }

}
