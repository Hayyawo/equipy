package pl.javastart.equipy.User;

import org.springframework.stereotype.Service;
import pl.javastart.equipy.Assignment.AssigmentUserMapper;
import pl.javastart.equipy.Assignment.AssignmentUserResponse;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private AssigmentUserMapper assigmentUserMapper;


    public UserService(UserRepository userRepository, AssigmentUserMapper assigmentUserMapper) {
        this.userRepository = userRepository;
        this.assigmentUserMapper = assigmentUserMapper;
    }


    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserDtoMapper::mapResponse)
                .collect(Collectors.toList());
    }

    public List<UserResponse> findByLastName(String lastName) {
        return userRepository.findByLastNameContainingIgnoreCase(lastName)
                .stream()
                .map(UserDtoMapper::mapResponse)
                .collect(Collectors.toList());
    }

    public void save(UserRequest userRequest) {
        User user = UserDtoMapper.mapRequest(userRequest);
        if (userRepository.findByPesel(user.getPesel()).isPresent()) {
            throw new AlreadyExistsPesel();
        } else {
            userRepository.save(user);
        }
    }

    public UserResponse findById(Long id) {
        return userRepository.findById(id)
                .map(UserDtoMapper::mapResponse)
                .orElseThrow();
    }


    public void update(UserRequest userRequest) {
        User byPesel = userRepository.findByPesel(userRequest.getPesel())
                .orElseThrow(EntityNotFoundException::new);
        byPesel.setFirstName(userRequest.getFirstName());
        byPesel.setLastName(userRequest.getLastName());
        byPesel.setPesel(userRequest.getPesel());
        userRepository.save(byPesel);
    }

    List<AssignmentUserResponse> getUserAssignments(Long userId) {
        return userRepository.findById(userId)
                .map(User::getAssignments)
                .orElseThrow()
                .stream()
                .map(assigment -> assigmentUserMapper.map(assigment))
                .collect(Collectors.toList());
    }


}
