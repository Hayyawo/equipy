package pl.javastart.equipy.User;

public class UserDtoMapper {
    static UserResponse mapResponse(User user) {
        UserResponse dto = new UserResponse();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setPesel(user.getPesel());
        return dto;
    }

   static User mapRequest(UserRequest userRequest) {
        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        user.setPesel(userRequest.getPesel());
        return user;
    }
}
