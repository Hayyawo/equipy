package pl.javastart.equipy.Asset;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssetService {
    private final AssetRepository repository;
    private final AssetMapper assetMapper;

    public AssetService(AssetRepository repository, AssetMapper assetMapper) {
        this.repository = repository;
        this.assetMapper = assetMapper;
    }

    public List<AssetResponse> getAllAssets() {
        return repository.findAll()
                .stream()
                .map(AssetMapper::map)
                .collect(Collectors.toList());
    }

    public List<AssetResponse> findByNameOrSerialNumber(String name, String serialNumber) {
        return repository.findByNameContainingIgnoreCaseOrSerialNumberContainingIgnoreCase(name,serialNumber)
                .stream()
                .map(AssetMapper::map)
                .collect(Collectors.toList());
    }

    public void save(AssetRequest assetRequest) {
        Asset asset = assetMapper.map(assetRequest);
        repository.save(asset);
    }
}
