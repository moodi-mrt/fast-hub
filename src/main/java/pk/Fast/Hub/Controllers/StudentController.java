package pk.Fast.Hub.Controllers;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pk.Fast.Hub.Dto.StudentDto.CreateStudentRequestDto;
import pk.Fast.Hub.Dto.StudentDto.CreateStudentResponseDto;
import pk.Fast.Hub.Dto.StudentDto.UpdatedStudentDto;
import pk.Fast.Hub.Services.StudentService;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping
    public ResponseEntity<CreateStudentResponseDto> createStudent(@Valid @RequestBody CreateStudentRequestDto request ){
        CreateStudentResponseDto resp = studentService.createStudent(request);

        return ResponseEntity.status(HttpStatus.CREATED).body(resp);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreateStudentResponseDto> getStudentInfo(@PathVariable Long id){
        CreateStudentResponseDto studentResponseDto = studentService.getStudent(id);

        return ResponseEntity.ok(studentResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<CreateStudentResponseDto>> getAllStudents(){
        List<CreateStudentResponseDto> studentList = studentService.getAllStudents();

        return ResponseEntity.ok(studentList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdatedStudentDto> updateStudent(@PathVariable Long id, @RequestBody UpdatedStudentDto updatedStudentDto){
        UpdatedStudentDto studentResp = studentService.updateStudent(id, updatedStudentDto);

        return ResponseEntity.ok(studentResp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok("Student deleted successfully");
    }
}
