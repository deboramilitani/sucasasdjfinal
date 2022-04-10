package com.sucasasdj.app.repository;

import com.sucasasdj.app.model.Playlist;
import com.sucasasdj.app.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaylistRepository extends PagingAndSortingRepository<Playlist, Long> {

    List<Playlist> findPlaylistsByUserAndType(User user, String type);
}
