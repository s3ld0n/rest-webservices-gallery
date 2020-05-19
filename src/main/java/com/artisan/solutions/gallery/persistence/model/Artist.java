package com.artisan.solutions.gallery.persistence.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder

@Entity
@Table(name = "artists")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToMany(mappedBy = "artist")
    private List<Work> works;

    @Override
    public String toString() {
        return "Artist{" + "id=" + id + ", firstName='" + firstName + '\'' + ", lastName='" + lastName + '\''
                       + ", email='" + email + '\'' + '}';
    }
}
