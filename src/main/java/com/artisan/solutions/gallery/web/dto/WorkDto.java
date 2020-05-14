package com.artisan.solutions.gallery.web.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder

public class WorkDto {

    private long id;
    private Long artistId;
    private String title;
    private LocalDate dateCreated;
}
