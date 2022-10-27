package pl.javastart.equipy.Assignment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssigmentRepository extends JpaRepository<Assignment, Long> {
    Optional<Assignment> findByAssetIdAndEndTimeIsNull(Long assetId);
}
