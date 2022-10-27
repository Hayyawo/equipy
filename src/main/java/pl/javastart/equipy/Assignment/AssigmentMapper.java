package pl.javastart.equipy.Assignment;

import org.springframework.stereotype.Component;
import pl.javastart.equipy.Asset.AssetRepository;
import pl.javastart.equipy.User.UserRepository;

import java.time.LocalDateTime;

@Component
public class AssigmentMapper {
    private final AssetRepository assetRepository;
    private final UserRepository userRepository;

    public AssigmentMapper(AssetRepository assetRepository, UserRepository userRepository) {
        this.assetRepository = assetRepository;
        this.userRepository = userRepository;
    }

    public AssigmentRequest map(Assignment assignment) {
        return AssigmentRequest.builder()
                .id(assignment.getId())
                .end(assignment.getEndTime())
                .start(LocalDateTime.now())
                .userId(assignment.getUsers().getId())
                .assetId(assignment.getAsset().getId())
                .build();
    }
}
