package pl.javastart.equipy.Asset;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssetController {
    private final AssetService assetService;
    private final AssetRepository assetRepository;

    public AssetController(AssetService assetService, AssetRepository assetRepository) {
        this.assetService = assetService;

        this.assetRepository = assetRepository;
    }

    @GetMapping("/api/assets")
    public List<AssetResponse> getAssets() {
        return assetService.getAllAssets();
    }

    @GetMapping("api/assets{text}")
    public List<Asset> findByNameOrSerialNumber(@PathVariable(required = false) String text) {
        return assetService.findByNameOrSerialNumber(text, text);
    }

    @PostMapping("api/assets")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<AssetRequest> save(@RequestBody AssetRequest assetRequest) {
        assetService.save(assetRequest);
        return new ResponseEntity<>(assetRequest, HttpStatus.CREATED);
    }
}
