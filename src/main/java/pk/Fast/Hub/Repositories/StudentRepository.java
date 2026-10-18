package pk.Fast.Hub.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pk.Fast.Hub.Entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {


    boolean existsByEmail(String email);
}
