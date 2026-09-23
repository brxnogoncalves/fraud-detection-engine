package com.brxnorafa.fraud_detection_engine.shared.exception;

import java.time.LocalDateTime;
import java.util.Map;

public record ApiError (
        LocalDateTime timestamp,
        int status,
        String error,
        Map<String, String> fields
) {
}
