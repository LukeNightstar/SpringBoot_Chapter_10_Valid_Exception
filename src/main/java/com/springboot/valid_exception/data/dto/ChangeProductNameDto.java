package com.springboot.valid_exception.data.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ChangeProductNameDto {
    private Long number;
    private String name;
}
