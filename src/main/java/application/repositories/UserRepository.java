package application.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import application.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}

