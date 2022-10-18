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
}
