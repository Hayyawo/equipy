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
        //when
        when(userRepository.findByPesel(userRequest.getPesel())).thenReturn(Optional.of(user));
        //then
        verify(userRepository).save(user);
    }

    @Test
    void savedOk() {
        //given
        User user = new User();
        //when
        userRepository.save(user);
        //then
        verify(userRepository).save(user);
    }
    @Test
    void findByIdOk(){
        long id = 1;
        UserResponse userResponse = new UserResponse();
        User user = new User();
        userResponse.setId(id);

        when(userRepository.findById(id)).thenReturn(Optional.of(user));

        verify(userRepository).findById(id);
    }
    @Test
    void getAllUsersOk(){
        List<UserResponse> userResponses = List.of(new UserResponse());
        User users = new User();



        verify(userRepository).findAll();
    }
    @Test
    void findByLastNameOk(){

        User user = new User();
        user.setLastName("aaa");
        List<User> users = List.of(user);
        userRepository.findByLastNameContainingIgnoreCase(user.getLastName());


        verify(userRepository).findByLastNameContainingIgnoreCase("aaa");
    }


}