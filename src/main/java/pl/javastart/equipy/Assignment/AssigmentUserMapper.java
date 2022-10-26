package pl.javastart.equipy.Assignment;

import org.springframework.stereotype.Component;
import pl.javastart.equipy.Asset.Asset;

@Component
public class AssigmentUserMapper {
    public AssignmentUserResponse map(Assignment assignment) {
        Asset asset = assignment.getAsset();
        return AssignmentUserResponse.builder()
                .id(assignment.getId())
                .start(assignment.getStartTime())
                .end(assignment.getEndTime())
                .assetId(asset.getId())
                .assetName(asset.getName())
                .assetSerialNumber(asset.getSerialNumber())
                .build();
    }

}
