package com.spring.player.dao;

import com.spring.player.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface PlayerDAO extends JpaRepository<Player,Integer> {

    Player findByName(@RequestParam String name);

}
