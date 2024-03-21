package com.banking.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RegistRequestDto {
    String bankCode;
    String bankAccountNumber;
}
