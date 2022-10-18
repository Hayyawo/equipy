package pl.javastart.equipy.Assignment;

import pl.javastart.equipy.Asset.Asset;
import pl.javastart.equipy.User.User;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime start;
    private LocalDateTime end;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "asset_id")
    private Asset asset;

    public Assignment(Long id, LocalDateTime start, LocalDateTime end, User user, Asset asset) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.user = user;
        this.asset = asset;
    }

    public Assignment() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

}
