package com.example.music.service;

import com.example.music.model.AlbumModel;
import com.example.music.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public AlbumModel registerAlbum(AlbumModel album) {
        Optional<AlbumModel> optionalAlbum = albumRepository.findByAlbumName(album.getAlbumName());
        if (optionalAlbum.isPresent()) {
            throw new IllegalArgumentException("There is already an album registered with this name.");
        }
        return albumRepository.save(album);
    }

    public List<AlbumModel> getAllAlbums() {
        return albumRepository.findAll();
    }

    public void deleteAlbum(Long albumId) {
        if (albumRepository.existsById(albumId))
            albumRepository.deleteById(albumId);
        else
            throw new RuntimeException("Album not found with id: " + albumId);
    }

    public void updateAlbum(AlbumModel album) {
        if (albumRepository.existsById(album.getId())) {
            albumRepository.save(album);
        } else {
            throw new RuntimeException("Album not found with id: " + album.getId());
        }
    }
}
