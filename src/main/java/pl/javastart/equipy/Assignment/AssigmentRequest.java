package pl.javastart.equipy.Assignment;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class AssigmentRequest {
    private Long id;
    private Long userId;
    private Long assetId;
    private LocalDateTime start;
    private LocalDateTime end;


    public AssigmentRequest(Long id, Long userId, Long assetId, LocalDateTime start, LocalDateTime end) {
        this.id = id;
        this.userId = userId;
        this.assetId = assetId;
        this.start = start;
        this.end = end;
    }

    public AssigmentRequest() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
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
