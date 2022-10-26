package pl.javastart.equipy.Asset;

import lombok.Builder;
import pl.javastart.equipy.Assignment.Assignment;
import pl.javastart.equipy.Category.Category;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "asset")
@Builder
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Column(unique = true)
    private String serialNumber;
    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "asset")
    private List<Assignment> assignments = new ArrayList<>();
    public Asset() {
    }

    public Asset(Long id, String name, String description, String serialNumber, Category category, List<Assignment> assignments) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.serialNumber = serialNumber;
        this.category = category;
        this.assignments = assignments;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

}


