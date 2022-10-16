package pl.javastart.equipy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.javastart.equipy.Category.Category;
import pl.javastart.equipy.Category.CategoryRepository;
import pl.javastart.equipy.Category.CategoryService;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @Test
    void findAllOk() {
        //when
        Category category = new Category();
        List<Category> strings = List.of(category);
        when(categoryRepository.findAll()).thenReturn(strings);
        //then
        categoryService.findAll();
        //when
        verify(categoryRepository).findAll();
    }

    @Test
    void findCategoryByNameOk() {
        //given
        String name = "jan";
        Category category = new Category();
        category.setName(name);
        when(categoryRepository.findByName(name)).thenReturn(category);
        //when
        categoryService.findCategoryByName(name);
        //then
        verify(categoryRepository).findByName(name);
    }
}
