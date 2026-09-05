package com.example.niceapi.exception;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorResponse {
    private int errorStatus;
    private String message;
    private LocalDateTime timestamp;

    public ErrorResponse(int errorStatus, String message, LocalDateTime timestamp) {
        this.errorStatus = errorStatus;
        this.message = message;
        this.timestamp = timestamp;
    }
}
