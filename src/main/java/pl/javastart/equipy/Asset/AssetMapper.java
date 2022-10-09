package pl.javastart.equipy.Asset;

import org.springframework.stereotype.Component;

@Component
public class AssetMapper {
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
        return Asset.builder()
                .name(assetRequest.getName())
                .serialNumber(assetRequest.getSerialNumber())
                .description(assetRequest.getDescription())
                .category(assetRequest.getCategory())
                .build();
    }
}
