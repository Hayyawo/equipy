package pl.javastart.equipy.Asset;

import org.springframework.stereotype.Service;
import pl.javastart.equipy.Category.Category;
import pl.javastart.equipy.Category.CategoryService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssetService {
    private final AssetRepository repository;
    private final AssetMapper assetMapper;
    private final AssetRepository assetRepository;
    private final CategoryService categoryService;

    public AssetService(AssetRepository repository, AssetMapper assetMapper, AssetRepository assetRepository, CategoryService categoryService) {
        this.repository = repository;
        this.assetMapper = assetMapper;
        this.assetRepository = assetRepository;
        this.categoryService = categoryService;
    }

    public List<AssetResponse> getAllAssets() {
        return repository.findAll()
                .stream()
                .map(AssetMapper::map)
                .collect(Collectors.toList());
    }

    public List<AssetResponse> findByNameOrSerialNumber(String name, String serialNumber) {
        return repository.findByNameContainingIgnoreCaseOrSerialNumberContainingIgnoreCase(name, serialNumber)
                .stream()
                .map(AssetMapper::map)
                .collect(Collectors.toList());
    }

    public void save(AssetRequest assetRequest) {
        Asset asset = assetMapper.map(assetRequest);
        Optional<Asset> bySerialNumber = assetRepository.findBySerialNumber(asset.getSerialNumber());
        if (bySerialNumber.isPresent()) {
            throw new SerialNumberAlreadyExists();
        } else {
            repository.save(asset);
        }
    }

    public AssetResponse findById(Long id) {
        return assetRepository.findById(id)
                .stream()
                .map(AssetMapper::map)
                .findFirst()
                .orElseThrow();
    }

    public void update(AssetRequest assetRequest) {
        Asset asset = assetRepository.findBySerialNumber(assetRequest.getSerialNumber())
                .orElseThrow();
        Category category = categoryService.findCategoryByName(assetRequest.getCategory());

        asset.setCategory(category);
        asset.setDescription(assetRequest.getDescription());
        asset.setSerialNumber(assetRequest.getSerialNumber());
        asset.setName(assetRequest.getName());
        assetRepository.save(asset);
    }
}
