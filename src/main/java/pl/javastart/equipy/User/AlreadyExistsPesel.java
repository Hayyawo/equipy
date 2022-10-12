package pl.javastart.equipy.User;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "User with this pesel already exists")
public class AlreadyExistsPesel extends RuntimeException {
}
