package pl.javastart.equipy;

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
    public ResponseEntity<UserRequest> save(@RequestBody UserRequest userRequest){
        service.save(userRequest);
        return new ResponseEntity<>(userRequest,HttpStatus.CREATED);
    }

}
