package pk.Fast.Hub.Dto.FacultyDto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import pk.Fast.Hub.Entity.Designation;

public class FacultyRequestDto {
    @NotBlank(message = "Name is required")
    private String name;
    @Min(value = 18 , message = "Age cann't be less then 18")
    @NotNull(message = "Inter the age")
    private Integer age;
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email")
    private String email;
    @NotBlank(message = "Employee ID is required")
    private String employeeId;
    @NotBlank(message = "Department cann't be empty")
    private String department;
    @NotNull(message = "Designation is required")
    private Designation role;

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

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Designation getRole() {
        return role;
    }

    public void setRole(Designation role) {
        this.role = role;
    }
}
