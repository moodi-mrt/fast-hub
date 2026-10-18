package pk.Fast.Hub.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pk.Fast.Hub.Entity.Faculty;

public abstract class FacultyRespository implements JpaRepository<Faculty, Long> {
}
