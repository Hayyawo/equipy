package pl.javastart.equipy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.javastart.equipy.Asset.*;
import pl.javastart.equipy.Category.Category;
import pl.javastart.equipy.Category.CategoryService;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AssetServiceTest {
    @Mock
    private AssetRepository assetRepository;
    @Mock
    private AssetMapper assetMapper;
    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private AssetService assetService;

    @Test
    void getAllAssetsOk() {
        //given
        Asset asset = new Asset();
        Category category = new Category();
        category.setName("test category");
        asset.setCategory(category);
        List<Asset> assets = List.of(asset);
        when(assetRepository.findAll()).thenReturn(assets);
        //when
        assetService.getAllAssets();
        //then
        verify(assetRepository).findAll();
    }

    @Test
    void findByNameOrSerialNumberOk() {
        //given
        String name = "jan";
        String serialNumber = "123";
        Asset asset = new Asset();
        asset.setCategory(new Category());
        asset.setName(name);
        asset.setSerialNumber(serialNumber);
        List<Asset> assets = List.of(asset);
        when(assetRepository
                .findByNameContainingIgnoreCaseOrSerialNumberContainingIgnoreCase
                        (name, serialNumber))
                .thenReturn(assets);
        //when
        assetService.findByNameOrSerialNumber(name, serialNumber);
        //then
        verify(assetRepository).findByNameContainingIgnoreCaseOrSerialNumberContainingIgnoreCase(name, serialNumber);
    }

    @Test
    void findByNameOrSerialNumberEqualsNull() {
        //given
        String name = "jan";
        String serialNumber = null;
        Asset asset = new Asset();
        asset.setCategory(new Category());
        asset.setName(name);
        asset.setSerialNumber(serialNumber);
        List<Asset> assets = List.of(asset);
        when(assetRepository
                .findByNameContainingIgnoreCaseOrSerialNumberContainingIgnoreCase
                        (name, serialNumber))
                .thenReturn(assets);
        //when
        assetService.findByNameOrSerialNumber(name, serialNumber);
        //then
        verify(assetRepository).findByNameContainingIgnoreCaseOrSerialNumberContainingIgnoreCase(name, serialNumber);
    }

    @Test
    void findByNameEqualsNullOrSerialNumber() {
        //given
        String name = null;
        String serialNumber = "123";
        Asset asset = new Asset();
        asset.setCategory(new Category());
        asset.setName(name);
        asset.setSerialNumber(serialNumber);
        List<Asset> assets = List.of(asset);
        when(assetRepository
                .findByNameContainingIgnoreCaseOrSerialNumberContainingIgnoreCase
                        (name, serialNumber))
                .thenReturn(assets);
        //when
        assetService.findByNameOrSerialNumber(name, serialNumber);
        //then
        verify(assetRepository).findByNameContainingIgnoreCaseOrSerialNumberContainingIgnoreCase(name, serialNumber);
    }

    @Test
    void saveOk() {
        //given
        Asset asset = new Asset();
        Category category = new Category();
        AssetRequest assetRequest = new AssetRequest();
        asset.setCategory(category);
        assetRequest.setCategory(category.getName());

        when(assetMapper.map(assetRequest)).thenReturn(asset);
        when(assetRepository.save(asset)).thenReturn(any());
        //when
        assetService.save(assetRequest);
        //then
        verify(assetRepository).save(asset);
    }

    @Test
    void saveThrowSerialNumberAlreadyExists() {
        //given
        Asset assetGiven = new Asset();
        assetGiven.setSerialNumber("123");
        AssetRequest assetRequest = new AssetRequest();
        assetRequest.setSerialNumber("123");
        Asset assetExpected = new Asset();
        assetExpected.setSerialNumber("123");

        when(assetMapper.map(assetRequest)).thenReturn(assetExpected);
        when(assetRepository.findBySerialNumber(assetGiven.getSerialNumber()))
                .thenReturn(Optional.of(assetExpected));
        //when
        //then
        Assertions.assertThrows(SerialNumberAlreadyExists.class, () -> assetService.save(assetRequest));
    }

    @Test
    void findByIdOk() {
        //given
        long id = 1;
        Asset asset = new Asset();
        asset.setCategory(new Category());
        when(assetRepository.findById(id)).thenReturn(Optional.of(asset));
        //when
        assetService.findById(id);
        //then
        verify(assetRepository).findById(id);
    }

    @Test
    void findByIdThrowNoSuchElementException() {
        //given
        long id = 1;
        when(assetRepository.findById(id)).thenReturn(Optional.empty());
        //when
        //then
        Assertions.assertThrows(NoSuchElementException.class, () -> assetService.findById(id));
    }

    @Test
    void updateOk() {
        //given
        String serialNumber = "123";
        Asset asset = new Asset();
        Category category = new Category();
        AssetRequest assetRequest = new AssetRequest();
        assetRequest.setCategory(category.getName());
        asset.setSerialNumber(serialNumber);
        assetRequest.setSerialNumber(serialNumber);

        when(assetRepository.findBySerialNumber(serialNumber)).thenReturn(Optional.of(asset));
        when(categoryService.findCategoryByName(assetRequest.getCategory())).thenReturn(category);
        when(assetRepository.save(asset)).thenReturn(any());
        //when
        assetService.update(assetRequest);
        //then
        verify(assetRepository).save(asset);
    }
}
