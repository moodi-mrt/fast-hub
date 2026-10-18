package pk.Fast.Hub.Entity;

import jakarta.persistence.*;
import pk.Fast.Hub.User.User;

import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("FACULTY")
public class Faculty extends User {
    @Enumerated(EnumType.STRING)
    private Designation role;

    @Column(unique = true)
    private String employeeId;

    private String department;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Faculty(){}

    public Faculty(String name, int age, String email, Designation role, String employeeId, String department, LocalDateTime createdAt, LocalDateTime updatedAt) {
        super(name, age, email);
        this.role = role;
        this.employeeId = employeeId;
        this.department = department;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
    public Designation getRole() {
        return role;
    }

    public void setRole(Designation role) {
        this.role = role;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
