package com.pl.premier_zone.Service;

import com.pl.premier_zone.Model.Player;
import com.pl.premier_zone.Repo.PremierRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.Transient;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PlayerService  {
    private final PremierRepo premierRepo;
    @Autowired
    public PlayerService(PremierRepo premierRepo) {
        this.premierRepo = premierRepo;
    }
    public List<Player> getPlayers(){
        return premierRepo.findAll();
    }
    public List<Player> getPlayersFromTeam(String teamName){
        return premierRepo.findAll().stream()
                .filter(player -> teamName.equals(player.getTeam()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayerByName(String searchText){
        return  premierRepo.findAll().stream()
                .filter(player -> player.getName().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByPos(String searchText){
        return premierRepo.findAll().stream()
                .filter(player -> player.getPos().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }
    public List<Player> getPlayersByNation(String searchText){
        return premierRepo.findAll().stream()
                .filter(player -> player.getNation().toLowerCase().contains(searchText.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Player> getPlayersByTeamAndPosition(String team, String position){
        return premierRepo.findAll().stream()
                .filter(player -> team.equals(player.getTeam()) && position.equals(player.getPos()))
                .collect(Collectors.toList());
    }


    public Player addPlayer(Player player){
        premierRepo.save(player);
        return player;
    }
    public Player updatePlayer(Player updatePlayer){
        Optional<Player> existingPlayer = premierRepo.findByName(updatePlayer.getName());
        if(existingPlayer.isPresent()){
            Player playerToUpdate = existingPlayer.get();
            playerToUpdate.setName(updatePlayer.getName());
            playerToUpdate.setTeam(updatePlayer.getTeam());
            playerToUpdate.setPos(updatePlayer.getPos());
            playerToUpdate.setNation(updatePlayer.getNation());

            premierRepo.save(playerToUpdate);
            return playerToUpdate;
        }
        return  null;
    }
    @Transactional
    public void deletePlayer(String playerName){
        premierRepo.deleteByName(playerName);
    }
}
