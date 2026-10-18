package pk.Fast.Hub.Entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import pk.Fast.Hub.User.User;

import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("STUDENT")
public class Student extends User {
 private String rollNo;
 private String department;
 private Integer semester;
 private LocalDateTime createdAt;
 private LocalDateTime updatedAt;

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

    public Student(){
     super();
 };

    public Student(String name, int age, String email, String rollNo, String department, Integer semester) {
        super(name, age, email);
        this.rollNo = rollNo;
        this.department = department;
        this.semester = semester;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }
}
