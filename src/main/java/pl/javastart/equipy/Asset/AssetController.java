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

    @GetMapping("api/assets")
    public List<AssetResponse> findByNameOrSerialNumber(@RequestParam(required = false) String text) {
        if (text == null) {
            return assetService.getAllAssets();
        }
        return assetService.findByNameOrSerialNumber(text, text);

    }

    @PostMapping("api/assets")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<AssetRequest> save(@RequestBody AssetRequest assetRequest) {
        assetService.save(assetRequest);
        return new ResponseEntity<>(assetRequest, HttpStatus.CREATED);
    }
}
