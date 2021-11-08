/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.project_league.model;

import cat.proven.project_league.persist.PlayerDaoInterface;
import cat.proven.project_league.persist.PlayerDaoList;
import cat.proven.project_league.persist.TeamDaoInterface;
import cat.proven.project_league.persist.TeamDaoList;
import java.util.List;

/**
 * Model.java Model class for Teams and players
 *
 * @author Andres, Rudy
 */
public class Model {

    /**
     * DAO for Player and Team objects
     */
    private final PlayerDaoInterface playerDao;
    private final TeamDaoInterface teamDao;

    public Model() {
        playerDao = PlayerDaoList.getInstance();
        teamDao = TeamDaoList.getInstance();
    }

    /**
     * List a list of all the teams.
     *
     * @return list of all the teams, return null if the list is empty.
     */
    public List<Team> findAllTeams() {
        return teamDao.findAllTeams();
    }

    /**
     * search the team by id.
     *
     * @param team the object which contains the id of the team.
     * @return the team if exist, return null if the team don't exist.
     */
    public Team findTeamById(Team team) {
        return teamDao.findTeamById(team);
    }

    /**
     * search the team by name.
     *
     * @param team the object which contains the name of the team.
     * @return the team if exist and return null if don't exist.
     */
    public Team findTeamByName(Team team) {
        return teamDao.findTeamByName(team);
    }

    /**
     * search the team by category.
     *
     * @param team the object which contains the category of the team.
     * @return the team list if exist and return null if don't exist.
     */
    public List<Team> findTeamsByCategory(Team team) {
        return teamDao.findTeamsByCategory(team);
    }

    /**
     * search the player by id.
     *
     * @param player the id of the player.
     * @return the player if exist and return null if don't exist.
     */
    public Player findPlayerById(Player player) {
        return playerDao.findPlayerById(player);
    }

    /**
     * search the player by fullName.
     *
     * @param player fullname of the player.
     * @return the player list if exist and return null if don't exist.
     */
    public List<Player> findPlayerByFullName(Player player) {
        return playerDao.findPlayerByFullName(player);
    }

    /**
     * search the player by Team.
     *
     * @param team the team of the player.
     * @return the player list if exist and return null if don't exist.
     */
    public List<Player> findPlayersByTeam(Team team) {
        return playerDao.findPlayersByTeam(team);
    }

    /**
     * create a new team and add it to the list.
     *
     * @param team the team to add.
     * @return 0 if added, 1 if exist , 2 if null, 3 user input error.
     */
    public int addTeam(Team team) {
        return teamDao.addTeam(team);
    }

    /**
     * modify the data of the team.
     *
     * @param team the team to modify.
     * @return 0 if added, 1 if exist , 2 if null, 3 user input error.
     */
    public int modifyTeam(Team team) {
        return teamDao.modifyTeam(team);
    }

    /**
     * delete a team.
     *
     * @param team the team to delete.
     * @return 0 if added, 1 if exist , 2 if null, 3 user input error.
     */
    public int removeTeam(Team team) {
        return teamDao.removeTeam(team);
    }

    /**
     * add new player to the list.
     *
     * @param player the player to add
     * @return 0 if added, 1 if exist , 2 if null, 3 user input error.
     */
    public int addPlayer(Player player) {
        return playerDao.addPlayer(player);
    }

    /**
     * modify data player.
     *
     * @param player the player to modify.
     * @return 0 if added, 1 if exist , 2 if null, 3 user input error.
     */
    public int modifyPlayer(Player player) {
        return playerDao.modifyPlayer(player);
    }

    /**
     * delete the player.
     *
     * @param player the player to delete.
     * @return 0 if added, 1 if exist , 2 if null, 3 user input error.
     */
    public int removePlayer(Player player) {
        return playerDao.removePlayer(player);
    }

    /**
     * add player to team.
     *
     * @param team the team to add in.
     * @param player the player to add on the team.
     * @return 0 if added, 1 if exist , 2 if null, 3 user input error.
     */
    public int enrolPlayerToTeam(Team team, Player player) {
        return playerDao.enrolPlayerToTeam(team, player);
    }

    /**
     * remove player of a team.
     *
     * @param team the team to remove the player.
     * @param player the player to remove of the team.
     * @return 0 if added, 1 if exist , 2 if null, 3 user input error.
     */
    public int unenrolPlayerToTeam(Team team, Player player) {
        return playerDao.unenrolPlayerToTeam(team, player);
    }

}
