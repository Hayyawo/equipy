package pl.javastart.equipy;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {
    private final AssetRepository repository;

    public AssetService(AssetRepository repository) {
        this.repository = repository;
    }

    public List<Assets> getAllAsets() {
        repository.findAll();
        return null;
    }
}
