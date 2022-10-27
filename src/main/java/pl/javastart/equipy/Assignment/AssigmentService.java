package pl.javastart.equipy.Assignment;

import org.springframework.stereotype.Service;
import pl.javastart.equipy.Asset.Asset;
import pl.javastart.equipy.Asset.AssetRepository;
import pl.javastart.equipy.User.User;
import pl.javastart.equipy.User.UserRepository;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AssigmentService {
    private final AssigmentRepository assigmentRepository;
    private final AssigmentMapper assigmentMapper;
    private final UserRepository userRepository;
    private final AssetRepository assetRepository;

    public AssigmentService(AssigmentRepository assigmentRepository, AssigmentMapper assigmentMapper, UserRepository userRepository, AssetRepository assetRepository) {
        this.assigmentRepository = assigmentRepository;
        this.assigmentMapper = assigmentMapper;
        this.userRepository = userRepository;
        this.assetRepository = assetRepository;
    }

    public AssigmentRequest save(AssigmentRequest assigmentRequest) {
        Assignment assignment = new Assignment();
        Optional<User> user = userRepository.findById(assigmentRequest.getUserId());
        Optional<Asset> asset = assetRepository.findById(assigmentRequest.getAssetId());
        assignment.setUsers(user.orElseThrow());
        assignment.setAsset(asset.orElseThrow());
        return assigmentMapper.map(assigmentRepository.save(assignment));
    }

    public Assignment endAssigment(Long assignmentId) {
        Optional<Assignment> assignment = assigmentRepository.findById(assignmentId);
        assignment.ifPresent(assignment1 -> assignment1.setEndTime(LocalDateTime.now()));
        return assigmentRepository.save(assignment.orElseThrow());
    }
}
