package com.example.music.controller;

import com.example.music.model.AlbumModel;
import com.example.music.model.UserModel;
import com.example.music.service.AlbumService;
import com.example.music.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private AlbumService albumService;

    @PostMapping("/register")
    public UserModel registerUser(@RequestBody UserModel user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public UserModel loginUser(@RequestBody UserModel user) {
        return userService.loginUser(user.getUsername(), user.getPassword());
    }

    @PostMapping("/create-album")
    public AlbumModel createAlbum(@RequestBody AlbumModel album) {
        return albumService.registerAlbum(album);
    }

    @GetMapping("/albums")
    public List<AlbumModel> getAllAlbums() {
        return albumService.getAllAlbums();
    }

    @DeleteMapping("/delete-album/{albumId}")
    public void deleteAlbum(@PathVariable Long albumId) {
        albumService.deleteAlbum(albumId);
    }

    @PutMapping("/update-album")
    public void updateAlbum(@RequestBody AlbumModel album) {
        albumService.updateAlbum(album);
    }
}
