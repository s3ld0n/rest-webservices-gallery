package com.artisan.solutions.gallery.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder

@Entity
@Table(name = "works")
public class Work {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @Column(name = "date_created")
    private LocalDate dateCreated;

    @Override
    public String toString() {
        return "Work{" + "id=" + id + ", title=" + title + ", createdDate=" + dateCreated + '}';
    }
}
