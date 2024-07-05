package com.example.musicapp.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.musicapp.R;
import com.example.musicapp.adapter.PlaylistAdapter;
import com.example.musicapp.databinding.FragmentPlaylistBinding;
import com.example.musicapp.viewmodel.PlaylistViewModel;

public class PlaylistFragment extends Fragment {
    private FragmentPlaylistBinding binding; // Kiểu chính xác
    private PlaylistViewModel viewModel;
    private PlaylistAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_playlist, container, false); // Kiểu chính xác
        viewModel = new ViewModelProvider(this).get(PlaylistViewModel.class);

        // Observer LiveData để cập nhật adapter và group
        viewModel.getPlaylists().observe(getViewLifecycleOwner(), playlists -> {
            adapter = new PlaylistAdapter(playlists);
            binding.playlistRV.setLayoutManager(new LinearLayoutManager(getContext()));
            binding.playlistRV.setAdapter(adapter);

            // Xử lý logic hiển thị Group
            binding.noPlaylistGroup.setVisibility(playlists.isEmpty() ? View.VISIBLE : View.GONE);
            binding.playlistsGroup.setVisibility(playlists.isEmpty() ? View.GONE : View.VISIBLE);
        });

        // Set data cho binding
        binding.setLifecycleOwner(this); // Gọi phương thức trên "binding"
        binding.setViewModel(viewModel); // Gọi phương thức trên "binding"

        return binding.getRoot();
    }
}