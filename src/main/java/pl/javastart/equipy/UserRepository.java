package pl.javastart.equipy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByLastNameContainingIgnoreCase(String lastName);
    User findByPesel(String pesel);

}
