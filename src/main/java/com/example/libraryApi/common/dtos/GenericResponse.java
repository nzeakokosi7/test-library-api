package com.example.libraryApi.common.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class GenericResponse<T> {
    private boolean error;
    private String message;
    private T data;
}
