package pl.javastart.equipy;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository repository;
    private final UserDtoMapper mapper;

    public UserService(UserRepository repository, UserDtoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    public List<UserResponse> getAllUsers() {
        return repository.findAll().stream()
                .map(UserDtoMapper::mapResponse)
                .collect(Collectors.toList());
    }

    public List<UserResponse> findByLastName(String lastName) {
        return repository.findByLastNameContainingIgnoreCase(lastName)
                .stream()
                .map(UserDtoMapper::mapResponse)
                .collect(Collectors.toList());
    }

    public void save(UserRequest userRequest) {
        User user = mapper.mapRequest(userRequest);
        if (repository.findByPesel(user.getPesel()) != null) {
            throw new AlreadyExistsPesel();
        } else {
            repository.save(user);
        }
    }
}
