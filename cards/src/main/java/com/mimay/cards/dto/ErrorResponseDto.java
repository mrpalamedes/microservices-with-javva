package com.mimay.cards.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ErrorResponseDto {

    private String apiPath;

    private String errorCode;

    private String errorMessage;

    private LocalDateTime errorTime;
}
