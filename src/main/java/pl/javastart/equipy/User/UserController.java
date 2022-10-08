package pl.javastart.equipy.User;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService service;
    private final UserRepository repository;

    public UserController(UserService service, UserRepository repository) {
        this.service = service;
        this.repository = repository;
    }


    @GetMapping("api/users")
    public List<UserResponse> getUsers(@RequestParam(required = false) String lastName) {
        if (lastName == null) {
            return service.getAllUsers();
        }
        return service.findByLastName(lastName);
    }

    @PostMapping("api/users")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<UserRequest> save(@RequestBody UserRequest userRequest) {
        service.save(userRequest);
        return new ResponseEntity<>(userRequest, HttpStatus.CREATED);
    }

    @GetMapping("api/users/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable Long id) {
        UserResponse user = service.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("api/users/{id}")
    public ResponseEntity<UserRequest> updateData(@PathVariable Long id, @RequestBody UserRequest userRequest) {
        getUserById(id);
        service.update(userRequest);
        return new ResponseEntity<>(userRequest, HttpStatus.OK);
    }

}
