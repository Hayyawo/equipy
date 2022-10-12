package pl.javastart.equipy.Asset;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Asset with this SN already exists")
public class SerialNumberAlreadyExists extends RuntimeException {
}
