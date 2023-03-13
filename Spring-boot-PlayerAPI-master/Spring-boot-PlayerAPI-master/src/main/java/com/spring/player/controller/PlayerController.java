package com.spring.player.controller;

import com.spring.player.model.Player;
import com.spring.player.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

// http://localhost:9090/
@Controller
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    // http://localhost:9090/players
    @GetMapping("/players")
    public String getAllPlayers(Model model){
        model.addAttribute("players",playerService.allPlayers());
        return "home";
    }

    // http://localhost:9090/player-form
    @GetMapping("player-form")
    public String playerForm(Model model){
        model.addAttribute("player", new Player());
        return "playerform";
    }

    // http://localhost:9090/savePlayer
    @PostMapping("/savePlayer")
    public String savePlayer(@ModelAttribute("player") Player player){
        playerService.savePlayer(player);
        return "redirect:/players";
    }

    // http://localhost:9090/getPlayer
    @GetMapping("/getPlayer")
    public String getPlayer(@RequestParam("playerId") int id, Model model){
        model.addAttribute("player",playerService.showPlayer(id));
        return "playerform";
    }

    @GetMapping("/removePlayer")
    public String removePlayer(@RequestParam("playerId") int id){
        playerService.deletePlayer(id);
        return "redirect:/players";
    }
}
