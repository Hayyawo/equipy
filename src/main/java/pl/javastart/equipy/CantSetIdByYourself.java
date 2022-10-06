package pl.javastart.equipy;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Cannot set pesel by yourself")
public class CantSetIdByYourself extends RuntimeException {
}
