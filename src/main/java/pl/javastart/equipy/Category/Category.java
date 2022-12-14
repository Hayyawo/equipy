package pl.javastart.equipy.Category;

import lombok.Data;
import pl.javastart.equipy.Asset.Asset;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @OneToMany(mappedBy = "category")
    private List<Asset> assets = new ArrayList<>();

    public Category() {
    }


    public Category(Long id, String name, String description, List<Asset> assets) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.assets = assets;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

}
