package pl.javastart.equipy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.javastart.equipy.User.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

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

    @Test
    void updatedOk() {
        //given
        UserRequest userRequest = new UserRequest();
        userRequest.setPesel("1234");
        User user = new User();
        user.setPesel(userRequest.getPesel());
        when(userRepository.findByPesel(userRequest.getPesel())).thenReturn(Optional.of(user));
        //when
        userService.update(userRequest);
        //then
        verify(userRepository).findByPesel(user.getPesel());
        verify(userRepository).save(user);
        verifyNoMoreInteractions(userRepository);
    }

    @Test
    void savedOk() {
        //given
        User user = new User();
        UserRequest userRequest = new UserRequest();
        userRequest.setPesel("1545");
        user.setPesel(userRequest.getPesel());
        //when
        userService.save(userRequest);
        //then
        verify(userRepository).save(user);
    }

    @Test
    void saveThrowAlreadyExistsPesel() {
        //given
        UserRequest userRequest = new UserRequest();
        User user = new User();
        user.setPesel("1");
        userRequest.setPesel("1");
        when(userRepository.findByPesel(userRequest.getPesel())).thenReturn(Optional.of(user));
        //when
        //then
        Assertions.assertThrows(AlreadyExistsPesel.class, () -> userService.save(userRequest));
    }

    @Test
    void findByIdOk() {
        //given
        long id = 1;
        User user = new User();
        user.setId(id);
        when(userRepository.findById(id)).thenReturn(Optional.of(user));
        //when
        userService.findById(id);
        //then
        verify(userRepository).findById(id);
    }

    @Test
    void findByIdNotFounded() {
        //given
        long id = 1;
        User user = new User();
        user.setId(id);
        when(userRepository.findById(id)).thenReturn(Optional.empty());
        //when
        //then
        Assertions.assertThrows(NoSuchElementException.class, () -> userService.findById(id));
    }

    @Test
    void getAllUsersOk() {
        //then
        User user = new User();
        List<User> users = List.of(user);
        when(userRepository.findAll()).thenReturn(users);
        //when
        userService.getAllUsers();
        //then
        verify(userRepository).findAll();
    }

    @Test
    void findByLastNameOk() {

        User user = new User();
        user.setLastName("aaa");
        List<User> users = List.of(user);
        when(userRepository.findByLastNameContainingIgnoreCase(user.getLastName())).thenReturn(users);


        userService.findByLastName(user.getLastName());

        verify(userRepository).findByLastNameContainingIgnoreCase("aaa");
    }


}