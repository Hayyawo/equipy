package pl.javastart.equipy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }


    @GetMapping("api/users")
    public List<User> getUsers() {
        return service.getAllUsers();
    }
}
