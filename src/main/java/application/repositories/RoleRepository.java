package application.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import application.model.Role;
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(String role);
}
