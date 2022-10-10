package pl.javastart.equipy.Asset;

import org.springframework.stereotype.Component;
import pl.javastart.equipy.Category.Category;
import pl.javastart.equipy.Category.CategoryRepository;

import java.util.Optional;

@Component
public class AssetMapper {
    private final CategoryRepository categoryRepository;

    public AssetMapper(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public static AssetResponse map(Asset asset) {

        return AssetResponse
                .builder()
                .name(asset.getName())
                .description(asset.getDescription())
                .serialNumber(asset.getSerialNumber())
                .category(asset.getCategory().getName())
                .build();
    }

    public Asset map(AssetRequest assetRequest) {
        Optional<Category> category = categoryRepository.findById(assetRequest.getCategory().getId());

        return Asset.builder()
                .name(assetRequest.getName())
                .serialNumber(assetRequest.getSerialNumber())
                .description(assetRequest.getDescription())
                .category(category.get())
                .build();
    }
}