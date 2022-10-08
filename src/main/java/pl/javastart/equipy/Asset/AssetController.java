package pl.javastart.equipy.Asset;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AssetController {
    private final AssetService service;

    public AssetController(AssetService service) {
        this.service = service;
    }

    @GetMapping("/api/assets")
    public List<AssetResponse> getAssets() {
        return service.getAllAssets();
    }
}
