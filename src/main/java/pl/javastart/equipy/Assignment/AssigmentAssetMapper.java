package pl.javastart.equipy.Assignment;

import org.springframework.stereotype.Component;
import pl.javastart.equipy.User.User;

@Component
public class AssigmentAssetMapper {
    public static AssignmentAssetResponse map(Assignment assignment) {
        User user = assignment.getUsers();
      return   AssignmentAssetResponse.builder()
                .id(assignment.getId())
                .start(assignment.getStartTime())
                .end(assignment.getEndTime())
                .userId(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .pesel(user.getPesel())
                .build();
    }
}
