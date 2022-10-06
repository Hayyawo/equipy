package pl.javastart.equipy;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserDtoMapper {
    static UserResponse mapResponse(User user) {
        UserResponse dto = new UserResponse();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPesel(user.getPesel());
        return dto;
    }

    User mapRequest(UserRequest userRequest) {
        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setPesel(userRequest.getPesel());
        return user;
    }
}
