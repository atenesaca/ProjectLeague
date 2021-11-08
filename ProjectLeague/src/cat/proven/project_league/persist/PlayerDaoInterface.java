/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.project_league.persist;

import cat.proven.project_league.model.Player;
import cat.proven.project_league.model.Team;
import java.util.List;

/**
 * 
 * @author Andres, Rudy
 */
public interface PlayerDaoInterface {

    /**
     * search the player by id.
     *
     * @param player the player with the id to find
     * @return the player
     */
    Player findPlayerById(Player player);

    /**
     * search the player by fullName.
     *
     * @param player the player with the name
     * @return the player
     */
    List<Player> findPlayerByFullName(Player player);

    /**
     * search players by Team.
     *
     * @param team the data of the team to find the players
     * @return the player
     */
    List<Player> findPlayersByTeam(Team team);

    /**
     * add new player to the list.
     *
     * @param player the player to add
     * @return  0 if added succesfully
     *          1 if team already exist
     *          2 if there data of the team is null;
     *          3 user input error
     */
    int addPlayer(Player player);

    /**
     * modify data player.
     *
     * @param player the player to modify.
     * @return  0 if added succesfully
     *          1 if team already exist
     *          2 if there data of the team is null;
     *          3 user input error
     */
    int modifyPlayer(Player player);

    /**
     * delete the player.
     *
     * @param player the player to delete.
     * @return  0 if added succesfully
     *          1 if team already exist
     *          2 if there data of the team is null;
     *          3 user input error
     */
    int removePlayer(Player player);

    /**
     * add player to team.
     *
     * @param team the team to add in.
     * @param player the player to add on the team.
     * @return  0 if added succesfully
     *          1 if team already exist
     *          2 if there data of the team is null;
     *          3 user input error
     */
    int enrolPlayerToTeam(Team team, Player player);

    /**
     * remove player of a team.
     *
     * @param team the team to remove the player.
     * @param player the player to remove of the team.
     * @return  0 if added succesfully
     *          1 if team already exist
     *          2 if there data of the team is null;
     *          3 user input error
     */
    int unenrolPlayerToTeam(Team team, Player player);
}
