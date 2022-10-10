package pl.javastart.equipy.Asset;

import lombok.Builder;

@Builder
public class AssetResponse {
    private String name;
    private String description;
    private String serialNumber;
    private String category;

    public AssetResponse() {
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public AssetResponse(String name, String description, String serialNumber, String category) {
        this.name = name;
        this.description = description;
        this.serialNumber = serialNumber;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

}
