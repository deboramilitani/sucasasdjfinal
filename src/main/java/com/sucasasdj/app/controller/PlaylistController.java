package com.sucasasdj.app.controller;

import com.sucasasdj.app.model.Playlist;
import com.sucasasdj.app.model.User;
import com.sucasasdj.app.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class PlaylistController {

    @Autowired
    HttpSession session;

    @Autowired
    private PlaylistRepository repository;

    @GetMapping("/home")
    public String showPlaylist(@RequestParam(required = false) String type, Model model) {
       User user = (User) session.getAttribute("user");

       if (user == null) {
           return "redirect:/index";
       }

       if (type == null || type.isEmpty()) {
           type = "playlist";
       }

       List<Playlist> playlist = repository.findPlaylistsByUserAndType(user, type);
       model.addAttribute("playlist", playlist);

       return "home";
    }

    @GetMapping("/addMedia")
    public String addMedia(Playlist playlist) {
        return "add-media";
    }

    @GetMapping("/about")
    public String about(Playlist playlist) {
        return "about";
    }

    @PostMapping("/addMedia")
    public String addUser(@Valid Playlist playlist) {
        playlist.setUser((User) session.getAttribute("user"));
        repository.save(playlist);

        return "redirect:home";
    }


}
