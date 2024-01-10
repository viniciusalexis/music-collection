package com.example.music.repository;

import com.example.music.model.AlbumModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlbumRepository extends JpaRepository<AlbumModel, Long> {
    Optional<AlbumModel> findByAlbumName(String albumName);
}
