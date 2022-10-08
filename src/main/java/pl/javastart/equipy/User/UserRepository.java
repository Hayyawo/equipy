package pl.javastart.equipy.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByLastNameContainingIgnoreCase(String lastName);

    Optional<User> findByPesel(String pesel);

}
