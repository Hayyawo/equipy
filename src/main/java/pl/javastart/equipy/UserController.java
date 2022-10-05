package pl.javastart.equipy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    public List<UserDto> getUsers(@RequestParam(required = false) String lastName) {
        if (lastName == null) {
            return service.getAllUsers();
        }
        return service.findByLastName(lastName);
    }
}
