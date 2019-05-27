package application.repositories;

import application.model.ConfirmationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConfirmationTokenRepository extends JpaRepository <ConfirmationToken, String>{
    ConfirmationToken findByConfirmationToken(String confirmationToken);
}
