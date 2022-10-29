package pl.javastart.equipy.Assignment;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Assignment end is already set")
public class AlreadyEnded extends RuntimeException {
}