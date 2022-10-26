package pl.javastart.equipy.Assignment;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class AssignmentResponse {
    private Long id;
    private LocalDateTime start;
    private LocalDateTime end;
    private Long assetId;
    private String assetName;
    private String assetSerialNumber;

    public AssignmentResponse() {
    }

    public AssignmentResponse(Long id, LocalDateTime start, LocalDateTime end, Long assetId, String assetName, String assetSerialNumber) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.assetId = assetId;
        this.assetName = assetName;
        this.assetSerialNumber = assetSerialNumber;
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

    public Long getAssetId() {
        return assetId;
    }

    public void setAssetId(Long assetId) {
        this.assetId = assetId;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetSerialNumber() {
        return assetSerialNumber;
    }

    public void setAssetSerialNumber(String assetSerialNumber) {
        this.assetSerialNumber = assetSerialNumber;
    }
}
