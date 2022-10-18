package pl.javastart.equipy.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.javastart.equipy.Assignment.AssignmentResponse;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;
    private final UserRepository repository;

    public UserController(UserService userService, UserRepository repository) {
        this.userService = userService;
        this.repository = repository;
    }

    @GetMapping("/{id}/assignments")
    public List<AssignmentResponse> getUserAssignments(@PathVariable Long id) {
        return userService.getUserAssignments(id);
    }

    @GetMapping("api/users")
    public List<UserResponse> getUsers(@RequestParam(required = false) String lastName) {
        if (lastName == null) {
            return userService.getAllUsers();
        }
        return userService.findByLastName(lastName);
    }

    @PostMapping("api/users")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<UserRequest> save(@RequestBody UserRequest userRequest) {
        userService.save(userRequest);
        return new ResponseEntity<>(userRequest, HttpStatus.CREATED);
    }

    @GetMapping("api/users/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        UserResponse user = userService.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("api/users/{id}")
    public ResponseEntity<UserRequest> updateData(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        getUserById(id);
        userService.update(userRequest);
        return new ResponseEntity<>(userRequest, HttpStatus.OK);
    }

}
