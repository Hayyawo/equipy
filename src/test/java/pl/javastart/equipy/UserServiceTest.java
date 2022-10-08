package pl.javastart.equipy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.javastart.equipy.User.UserRepository;
import pl.javastart.equipy.User.UserRequest;
import pl.javastart.equipy.User.UserService;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserService userService;

    @Test
    void userRequestEqualsNull() {
        UserRequest userRequest = new UserRequest();
        userRequest.setPesel("111");
        doReturn(Optional.empty()).when(userRepository).findByPesel(anyString());


        Assertions.assertThrows(EntityNotFoundException.class, () -> userService.update(userRequest));

    }
}