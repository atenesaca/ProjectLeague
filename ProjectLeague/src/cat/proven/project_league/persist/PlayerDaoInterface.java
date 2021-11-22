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
 * Class player interface where designate functions to develop in PlayerDaoList
 * 
 * @author Andres, Rudy
 */
public interface PlayerDaoInterface {

    /**
     * search the player by id.
     *
     * @param id the id to find
     * @return the data of the player
     */
    Player findPlayerById(long id);

    /**
     * search the player by fullName.
     * 
     * @param fullname the name and the surname of the player
     * @return the player
     */
    List<Player> findPlayerByFullName(String fullname);

    /**
     * search players by Team.
     *
     * @param team the data of the team to find the players
     * @return  the players of a especific team,
     *          if team is empty or don't exists this will not return players
     */
    List<Player> findPlayersByTeam(Team team);

    /**
     * add new player to the list.
     *
     * @param player the player to add
     * @return true if the player is added correctly, false otherwise.
     */
    boolean addPlayer(Player player);

    /**
     * modify data player.
     *
     * @param player the player to modify.
     * @return true if the player is modified correctly, false otherwise.
     */
    boolean modifyPlayer(Player player);

    /**
     * delete the player.
     *
     * @param player the player to delete.
     * @return true if the player is deleted correctly, false otherwise.
     */
    boolean removePlayer(Player player);

    /**
     * add player to team.
     *
     * @param team the team to add in.
     * @param player the player to add on the team.
     * @return   1 if the player is enrolled correcly in the team,
     *          -1 if player can not be added to a team
     *            if exceed the budget (it will not added)
     *          -2 if the player is already in a team
     *              (-1 in id team if player dont have a team)
     */
    int enrolPlayerToTeam(Team team, Player player);

    /**
     * remove player of a team.
     *
     * @param team the team to remove the player.
     * @param player the player to remove of the team.
     * @return 1 if the player is unenrolled correcly in a team,
     *        -1 if the players is not in a team
     *          (-1 in id team if player dont have a team)
     */
    int unenrolPlayerToTeam(Team team, Player player);
}
