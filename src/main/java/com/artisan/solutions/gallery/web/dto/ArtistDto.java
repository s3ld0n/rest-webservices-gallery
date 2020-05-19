package com.artisan.solutions.gallery.web.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder

public class ArtistDto {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<WorkDto> works;
}
