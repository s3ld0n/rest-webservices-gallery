package com.artisan.solutions.gallery.web.dto;

import com.artisan.solutions.gallery.persistence.model.Artist;
import com.artisan.solutions.gallery.persistence.model.Work;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DtoConverter {

    public static ArtistDto convertArtistToDto(Artist artist) {
        ArtistDto artistDto = ArtistDto
                                      .builder()
                                      .id(artist.getId())
                                      .firstName(artist.getFirstName())
                                      .lastName(artist.getLastName())
                                      .email(artist.getEmail())
                                      .build();

        artistDto.setWorks(Optional.ofNullable(artist.getWorks())
                                     .map(Collection::stream)
                                     .orElseGet(Stream::empty)
                                     .map(DtoConverter::convertWorkToDto)
                                     .collect(Collectors.toList())
                            );
        return artistDto;
    }

    public static List<ArtistDto> convertAllArtistToDtos(List<Artist> artists) {
        return artists.stream()
                      .map(DtoConverter::convertArtistToDto)
                      .collect(Collectors.toList());
    }

    public static Artist convertArtistDtoToEntity(ArtistDto artistDto) {
        return Artist.builder()
                           .id(artistDto.getId())
                           .firstName(artistDto.getFirstName())
                           .lastName(artistDto.getLastName())
                           .email(artistDto.getEmail())
                           .password(artistDto.getPassword())
                           .build();
    }

    public static WorkDto convertWorkToDto(Work work) {
        return WorkDto.builder()
                      .id(work.getId())
                      .title(work.getTitle())
                      .dateCreated(work.getDateCreated())
                      .build();
    }

    public static List<WorkDto> convertAllWorksToDtos(List<Work> works) {
        return works.stream()
                    .map(DtoConverter::convertWorkToDto)
                    .collect(Collectors.toList());
    }

    public static Work convertWorkDtoToEntity(WorkDto workDto) {
        return Work.builder()
                   .dateCreated(workDto.getDateCreated())
                   .id(workDto.getId())
                   .title(workDto.getTitle())
                   .build();
    }
}
