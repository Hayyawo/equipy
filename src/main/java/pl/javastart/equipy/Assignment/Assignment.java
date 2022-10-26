package pl.javastart.equipy.Assignment;

import lombok.Builder;
import pl.javastart.equipy.Asset.Asset;
import pl.javastart.equipy.User.User;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Builder
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    @ManyToOne
    @JoinColumn(name = "users_id")
    private User users;
    @ManyToOne
    @JoinColumn(name = "asset_id")
    private Asset asset;

    public Assignment(Long id, LocalDateTime startTime, LocalDateTime endTime, User users, Asset asset) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.users = users;
        this.asset = asset;
    }

    public Assignment() {
    }

    public User getUsers() {
        return users;
    }

    public void setUsers(User user) {
        this.users = user;
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

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime start) {
        this.startTime = start;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime end) {
        this.endTime = end;
    }

}
