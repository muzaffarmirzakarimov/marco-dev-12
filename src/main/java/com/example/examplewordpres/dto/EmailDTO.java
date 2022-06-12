package com.example.examplewordpres.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmailDTO {
    private String email;
    private String subject;
    private String text;
}
