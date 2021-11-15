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
     * List all teams.
     *
     * @return list all teams, return null if the list is empty.
     */
    public List<Team> findAllTeams() {
        return teamDao.findAllTeams();
    }

    /**
     * search teams by id.
     *
     * @param id the id of the team.
     * @return the team if exist, return null if the team don't exist.
     */
    public Team findTeamById(long id) {
        return teamDao.findTeamById(id);
    }

    /**
     * search team by name.
     *
     * @param name the name of the team.
     * @return the found team, null otherwise
     */
    public Team findTeamByName(String name) {
        return teamDao.findTeamByName(name);
    }

    /**
     * search teams by category.
     *
     * @param category the category of the team.
     * @return  the teams with the same category it could be one o more,
     *          null if there aren't any teams
     */
    public List<Team> findTeamsByCategory(String category) {
        return teamDao.findTeamsByCategory(category);
    }

    /**
     * search players by id.
     *
     * @param id the id of the player.
     * @return the player, null if don't exists
     */
    public Player findPlayerById(long id) {
        return playerDao.findPlayerById(id);
    }

    /**
     * search the player by fullName.
     * @param fullname the name and the surname of the player
     * @return data of the player, null if player don't exists
     */
    public List<Player> findPlayerByFullName(String fullname) {
        return playerDao.findPlayerByFullName(fullname);
    }

    /**
     * search players by team.
     *
     * @param team the team of the player.
     * @return  the players of a especific team,
     *          if team is empty or don't exists this will not return players
     */
    public List<Player> findPlayersByTeam(Team team) {
        return playerDao.findPlayersByTeam(team);
    }

    /**
     * create a new team.
     *
     * @param team the team to add.
     * @return true if the team is adeed correctly, false otherwise.
     */
    public boolean addTeam(Team team) {
        return teamDao.addTeam(team);
    }

    /**
     * modify the data of the team.
     *
     * @param team the team to modify.
     * @return true if the team is modified correctly, false otherwise.
     */
    public boolean modifyTeam(Team team) {
        return teamDao.modifyTeam(team);
    }

    /**
     * delete a team.
     *
     * @param team the team to delete.
     * @return true if the team is removed correctly, false otherwise.
     */
    public boolean removeTeam(Team team) {
        return teamDao.removeTeam(team);
    }

    /**
     * create a new player.
     *
     * @param player the player to add.
     * @return true if the player is added correctly, false otherwise.
     */
    public boolean addPlayer(Player player) {
        return playerDao.addPlayer(player);
    }

    /**
     * modify a player.
     *
     * @param player the player to modify.
     * @return true if the player is modified correctly, false otherwise.
     */
    public boolean modifyPlayer(Player player) {
        return playerDao.modifyPlayer(player);
    }

    /**
     * delete a player.
     *
     * @param player the player to delete.
     * @return true if the player is deleted correctly, false otherwise.
     */
    public boolean removePlayer(Player player) {
        return playerDao.removePlayer(player);
    }

    /**
     * add player to a team.
     *
     * @param team the team to add in.
     * @param player the player to add on the team.
     * @return  1 if the player is enrolled correcly in the team,
     *          -1 if the team don't exists
     *          -2 if the player don't exists
     *          -3 if the data is null
     *          -4 if player can not be added to a team
     *             if exceed the budget (it will not added)
     *          -5 if the player is already in a team
     *          -6 if the player is already in the team
     */
    public int enrolPlayerToTeam(Team team, Player player) {
        return playerDao.enrolPlayerToTeam(team, player);
    }

    /**
     * remove a player of a team.
     *
     * @param team the team to remove the player.
     * @param player the player to remove of the team.
     * @return  1 if the player is unenrolled correcly in a team,
     *          -1 if the team don't exists
     *          -2 if the player don't exists
     *          -3 if the data is null
     *          -4 if the players is not in the team
     */
    public int unenrolPlayerToTeam(Team team, Player player) {
        return playerDao.unenrolPlayerToTeam(team, player);
    }
}
