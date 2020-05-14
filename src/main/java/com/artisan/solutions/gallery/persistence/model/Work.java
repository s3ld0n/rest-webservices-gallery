package com.artisan.solutions.gallery.persistence.model;

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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "artist_id", nullable = false)
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
