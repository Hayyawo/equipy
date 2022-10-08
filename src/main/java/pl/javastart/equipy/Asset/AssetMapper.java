package pl.javastart.equipy.Asset;


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
}
