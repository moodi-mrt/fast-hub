package pk.Fast.Hub.Services;

import pk.Fast.Hub.Dto.FacultyDto.FacultyRequestDto;
import pk.Fast.Hub.Dto.FacultyDto.FacultyResponseDto;
import pk.Fast.Hub.Dto.FacultyDto.UpdateFacultyDto;
import pk.Fast.Hub.Dto.StudentDto.CreateStudentRequestDto;
import pk.Fast.Hub.Entity.Faculty;
import pk.Fast.Hub.Entity.Student;
import pk.Fast.Hub.Repositories.FacultyRespository;

import java.time.LocalDateTime;

public class FacultyService {
    private FacultyRespository facultyRespository;

    public FacultyService(FacultyRespository facultyRespository) {
        this.facultyRespository = facultyRespository;
    }

    public FacultyResponseDto CreateFaculty(FacultyRequestDto requestDto){

    }

    private Faculty mapToEntity(FacultyRequestDto requestDto){
        Faculty faculty = new Faculty();
        faculty.setName(requestDto.getName());
        faculty.setAge(requestDto.getAge());
        faculty.setEmployeeId(requestDto.getEmployeeId());
        faculty.setDepartment(requestDto.getDepartment());
        faculty.setEmail(requestDto.getEmail());
        faculty.setRole(requestDto.getRole());
        faculty.setCreatedAt(LocalDateTime.now());
        faculty.setUpdatedAt(LocalDateTime.now());

        return faculty;
    }
    private FacultyResponseDto maptoDto(Faculty faculty){
        FacultyResponseDto responseDto = new FacultyResponseDto();

        responseDto.setName(faculty.getName());
        responseDto.setAge(faculty.getAge());
        responseDto.setEmail(faculty.getEmail());
        responseDto.setEmployeeId(faculty.getEmployeeId());
        responseDto.setDepartment(faculty.getDepartment());
        responseDto.setMessage("Faculty Saved successfuly");
        responseDto.setCreatedAt(faculty.getCreatedAt());
        responseDto.setUpdatedAt(faculty.getUpdatedAt());

        return responseDto;
    }

    private UpdateFacultyDto mapToUpdateDto(Faculty faculty){
        UpdateFacultyDto response = new UpdateFacultyDto();

        response.setName(faculty.getName());
        response.setAge(faculty.getAge());

    }

}
