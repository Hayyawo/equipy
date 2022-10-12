package pl.javastart.equipy.Asset;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {
    List<Asset> findByNameContainingIgnoreCaseOrSerialNumberContainingIgnoreCase(String name, String serialNumber);

    Optional<Asset> findBySerialNumber(String serialNumber);
}
