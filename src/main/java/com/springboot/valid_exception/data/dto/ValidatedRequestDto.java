package com.springboot.valid_exception.data.dto;

import com.springboot.valid_exception.config.annotation.Telephone;
import com.springboot.valid_exception.data.group.ValidationGroup1;
import com.springboot.valid_exception.data.group.ValidationGroup2;
import jakarta.validation.constraints.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ValidatedRequestDto {

    @NotBlank
    private String name;

    @Email
    private String email;

    @Telephone
    private String phonenumber;

    @Pattern(regexp = "01(?:0|1|[6-9])[.-]?(\\d{3}|\\d{4})[.-]?(\\d{4})$")
    private String phoneNumber;

    @Min(value = 20, groups = ValidationGroup1.class)
    @Max(value = 40, groups = ValidationGroup1.class)
    int age;

    @Size(min = 0, max = 40)
    private String description;

    @Positive(groups = ValidationGroup2.class)
    private int count;

    @AssertTrue
    private boolean booleanCheck;

}
