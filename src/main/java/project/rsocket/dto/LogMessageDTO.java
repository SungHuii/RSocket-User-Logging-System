package project.rsocket.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogMessageDTO {
    private String userId;
    private String action;
    private String timestamp;
}
