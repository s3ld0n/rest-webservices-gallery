package com.artisan.solutions.gallery.web.dto;

import com.artisan.solutions.gallery.persistence.model.Artist;
import com.artisan.solutions.gallery.persistence.model.Work;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DtoConverter {

    private ModelMapper modelMapper;

    @Autowired
    public DtoConverter(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public ArtistDto convertArtistToDto(Artist artist) {

        ArtistDto artistDto = modelMapper.map(artist, ArtistDto.class);
        artistDto.setWorks(Optional.ofNullable(artist.getWorks())
                                     .map(Collection::stream)
                                     .orElseGet(Stream::empty)
                                     .map(work -> modelMapper.map(work, WorkDto.class))
                                     .collect(Collectors.toList())
                            );
        return artistDto;
    }

    public List<ArtistDto> convertAllArtistToDtos(List<Artist> artists) {
        return artists.stream()
                      .map(this::convertArtistToDto)
                      .collect(Collectors.toList());
    }

    public Artist convertArtistDtoToEntity(ArtistDto artistDto) {
        Artist artist = modelMapper.map(artistDto, Artist.class);

        artist.setWorks(Optional.ofNullable(artistDto.getWorks())
                                .map(Collection::stream)
                                .orElseGet(Stream::empty)
                                .map(work -> modelMapper.map(work, Work.class))
                                .collect(Collectors.toList())
                       );
        return artist;
    }

    public WorkDto convertWorkToDto(Work work) {
        return modelMapper.map(work, WorkDto.class);
    }

    public List<WorkDto> convertAllWorksToDtos(List<Work> works) {
        return works.stream()
                    .map(this::convertWorkToDto)
                    .collect(Collectors.toList());
    }

    public Work convertWorkDtoToEntity(WorkDto workDto) {
        return modelMapper.map(workDto, Work.class);
    }
}
