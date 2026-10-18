package pk.Fast.Hub.Dto.StudentDto;

import jakarta.validation.constraints.*;

public class CreateStudentRequestDto {
    @NotBlank(message = "incorrect name")
    private String name;
    @Min(value = 18 , message = "Age cann't be less then 18")
    @NotNull(message = "Inter the age")
    private Integer age;
    @Email(message = "Email should be p243037@pwr.nu.edu.pk")
    private String email;
    @NotBlank(message = "roll number should be 24P-3037")
    private String rollNo;
    @NotNull(message = "Department cann't be null")
    private String department;
    @NotNull(message = "Semester cann't be null")
    private Integer semester;


    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

}
