package pl.javastart.equipy.Asset;

import org.springframework.stereotype.Component;
import pl.javastart.equipy.Category.Category;
import pl.javastart.equipy.Category.CategoryRepository;

@Component
public class AssetMapper {
    private final CategoryRepository categoryRepository;

    public AssetMapper(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public static AssetResponse map(Asset asset) {

        return AssetResponse
                .builder()
                .id(asset.getId())
                .name(asset.getName())
                .description(asset.getDescription())
                .serialNumber(asset.getSerialNumber())
                .category(asset.getCategory().getName())
                .build();
    }

    public Asset map(AssetRequest assetRequest) {
        Category byName = categoryRepository.findByName(assetRequest.getCategory());
        return Asset.builder()
                .name(assetRequest.getName())
                .serialNumber(assetRequest.getSerialNumber())
                .description(assetRequest.getDescription())
                .category(byName)
                .build();
    }

}