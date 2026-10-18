package pk.Fast.Hub.Services;

import org.springframework.stereotype.Service;
import pk.Fast.Hub.Dto.StudentDto.CreateStudentRequestDto;
import pk.Fast.Hub.Dto.StudentDto.CreateStudentResponseDto;
import pk.Fast.Hub.Dto.StudentDto.UpdatedStudentDto;
import pk.Fast.Hub.Entity.Student;
import pk.Fast.Hub.Repositories.StudentRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public CreateStudentResponseDto createStudent(CreateStudentRequestDto requestDto) {

        Student student = mapToEntity(requestDto);
        if (emailExists(student)) {
            throw new RuntimeException("Email already exists: " + student.getEmail());
        }

        Student studentResp = studentRepository.save(student);
        return mapToDto(studentResp);
    }

    public CreateStudentResponseDto getStudent(Long id){
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id " + id));
        return mapToDto(student);
    }

    public List<CreateStudentResponseDto> getAllStudents(){
        List<Student> studentResp = studentRepository.findAll();

        return studentResp.stream().map(this::mapToDto).toList();
    }
    
    
    
public UpdatedStudentDto updateStudent(Long id, UpdatedStudentDto updatedStudentDto){
        Student existingStudent = studentRepository.findById(id).orElseThrow(()-> new RuntimeException("the student is not present with " + id));


    existingStudent.setName(updatedStudentDto.getName());
    existingStudent.setRollNo(updatedStudentDto.getRollNo());
    existingStudent.setDepartment(updatedStudentDto.getDepartment());
    existingStudent.setAge(updatedStudentDto.getAge());
    existingStudent.setUpdatedAt(LocalDateTime.now());

    Student updated = studentRepository.save(existingStudent);
    return mapToUpdateDto(updated);
}
    private Student mapToEntity(CreateStudentRequestDto requestDto) {
        Student student = new Student();
        student.setName(requestDto.getName());
        student.setAge(requestDto.getAge());
        student.setEmail(requestDto.getEmail());
        student.setRollNo(requestDto.getRollNo());
        student.setDepartment(requestDto.getDepartment());
        student.setSemester(requestDto.getSemester());
        student.setCreatedAt(LocalDateTime.now());
        student.setUpdatedAt(LocalDateTime.now());

        return student;
    }

    private CreateStudentResponseDto mapToDto(Student student) {
        CreateStudentResponseDto responseDto = new CreateStudentResponseDto();

        responseDto.setName(student.getName());
        responseDto.setAge(student.getAge());
        responseDto.setEmail(student.getEmail());
        responseDto.setRollNo(student.getRollNo());
        responseDto.setDepartment(student.getDepartment());
        responseDto.setMessage("Student saved successfully");
        responseDto.setCreatedAt(student.getCreatedAt());
        responseDto.setUpdatedAt(student.getUpdatedAt());

        return responseDto;
    }


    private UpdatedStudentDto mapToUpdateDto(Student student) {
        UpdatedStudentDto responseDto = new UpdatedStudentDto();


        responseDto.setName(student.getName());
        responseDto.setAge(student.getAge());
        responseDto.setEmail(student.getEmail());
        responseDto.setRollNo(student.getRollNo());
        responseDto.setDepartment(student.getDepartment());
        responseDto.setMessage("Student updated successfully");
        responseDto.setUpdatedAt(student.getUpdatedAt());

        return responseDto;
    }

    private boolean emailExists(Student student) {
        return studentRepository.existsByEmail(student.getEmail());
    }

    public void deleteStudent(Long id) {
        Student studentTobeDeleted = studentRepository.findById(id).orElseThrow(()-> new RuntimeException("student with the " + id + "not found"));

        studentRepository.delete(studentTobeDeleted);
    }
}