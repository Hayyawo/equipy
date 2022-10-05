package pl.javastart.equipy;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;

    }


    public List<UserDto> getAllUsers() {
        return repository.findAll().stream()
                .map(UserDtoMapper::map)
                .collect(Collectors.toList());
    }

    public List<UserDto> findByLastName(String lastName) {
        return repository.findByLastNameContainingIgnoreCase(lastName)
                .stream()
                .map(UserDtoMapper::map)
                .collect(Collectors.toList());
    }
}
