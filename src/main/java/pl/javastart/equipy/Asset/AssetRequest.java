package pl.javastart.equipy.Asset;

import lombok.Builder;

@Builder
public class AssetRequest {

    private String name;
    private String description;
    private String serialNumber;
    private String category;

    public AssetRequest() {
    }

    public AssetRequest(String name, String description, String serialNumber, String category) {
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

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
