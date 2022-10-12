package pl.javastart.equipy.Asset;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AssetController {
    private final AssetService assetService;


    public AssetController(AssetService assetService) {
        this.assetService = assetService;


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
    @GetMapping("api/assets/{id}")
    public ResponseEntity<AssetResponse> findById(@PathVariable long id){
        AssetResponse assetResponse = assetService.findById(id);
        return new ResponseEntity<>(assetResponse,HttpStatus.OK);
    }

    @PutMapping("api/assets/{id}")
    public ResponseEntity<AssetRequest> update(@PathVariable long id, @RequestBody AssetRequest assetRequest){
        findById(id);
        assetService.update(assetRequest);
        return new ResponseEntity<>(assetRequest,HttpStatus.OK);
    }
}
