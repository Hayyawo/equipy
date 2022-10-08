package pl.javastart.equipy.Asset;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AssetService {
    private final AssetRepository repository;

    public AssetService(AssetRepository repository) {
        this.repository = repository;
    }

    public List<AssetResponse> getAllAssets() {
        return repository.findAll()
                .stream()
                .map(AssetMapper::map)
                .collect(Collectors.toList());
    }
}
