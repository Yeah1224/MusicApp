package com.example.musicapp.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.musicapp.model.Playlist;

import java.util.ArrayList;
import java.util.List;

public class PlaylistViewModel extends ViewModel {
    private MutableLiveData<List<Playlist>> playlists = new MutableLiveData<>(new ArrayList<>());

    public LiveData<List<Playlist>> getPlaylists() {
        return playlists;
    }

    public void loadPlaylists() {
        List<Playlist> playlistList = new ArrayList<>();
        playlistList.add(new Playlist("Playlist 1", "Image URL 1", "Mô tả Playlist 1", new ArrayList<String>(), "2023-10-26"));
        playlistList.add(new Playlist("Playlist 2", "Image URL 2", "Mô tả Playlist 2", new ArrayList<String>(), "2023-10-26"));
        playlists.setValue(playlistList);
    }

    public PlaylistViewModel() {
        loadPlaylists();
    }
}