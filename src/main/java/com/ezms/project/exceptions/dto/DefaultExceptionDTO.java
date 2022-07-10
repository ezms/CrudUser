package com.ezms.project.exceptions.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DefaultExceptionDTO {
    private Integer code;
    private String userMessage;
    private String devMessage;
}
