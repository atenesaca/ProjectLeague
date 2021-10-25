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
     * @param id the id of the player.
     * @return the player
     */
    Player findPlayerById(long id);

    /**
     * search the player by fullName.
     *
     * @param fullname fullname of the player.
     * @return the player
     */
    List<Player> findPlayerByFullName(String fullname);

    /**
     * search the player by Team.
     *
     * @param team the team of the player.
     * @return the player
     */
    List<Player> findPlayersByTeam(Team team);

    /**
     * add new player to the list.
     *
     * @param player the player to add
     * @return number of entries affected by the operation
     */
    int addPlayer(Player player);

    /**
     * modify data player.
     *
     * @param player the player to modify.
     * @return number of entries affected by the operation
     */
    int modifyPlayer(Player player);

    /**
     * delete the player.
     *
     * @param player the player to delete.
     * @return number of entries affected by the operation
     */
    int removePlayer(Player player);

    /**
     * add player to team.
     *
     * @param team the team to add in.
     * @param player the player to add on the team.
     * @return number of entries affected by the operation
     */
    int enrolPlayerToTeam(Team team, Player player);

    /**
     * remove player of a team.
     *
     * @param team the team to remove the player.
     * @param player the player to remove of the team.
     * @return number of entries affected by the operation
     */
    int unenrolPlayerToTeam(Team team, Player player);
}
