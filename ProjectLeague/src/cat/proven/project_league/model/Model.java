/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.project_league.model;

import java.util.List;

/**
 * Class Model: Methods.
 * @author Andres, Rudy y Samar
 */
public class Model {
    
    /**
     * List a list of all the teams.
     * @return list of all the teams, return null if the list is empty.
     */
    public List<Team> findAllTeams(){
        return null;
    }
    
    /**
     * search the team by id.
     * @param id the id of the team.
     * @return the team if exist, return null if the team don't exist.
     */
    public Team findTeamById(long id){
        return null;
    }
    
    /**
     * search the team by name.
     * @param name the name of the team.
     * @return the team if exist and return null if don't exist.
     */
    public Team findTeamByName(String name){
        return null;
    }
    
    /**
     * search the team by category.
     * @param Category the category of the team.
     * @return the team list if exist and return null if don't exist.
     */
    public List<Team> findTeamsByCategory(String Category){
        return null;
    }
    
    /**
     * search the player by id.
     * @param id the id of the player.
     * @return the player if exist and return null if don't exist.
     */
    public Player findPlayerById(long id){
        return null;
    }
    
    /**
     * search the player by fullName.
     * @param fullname fullname of the player.
     * @return the player list if exist and return null if don't exist.
     */
    public List<Player> findPlayerByFullName(String fullname){
        return null;
    }
    
    /**
     * search the player by Team.
     * @param team the team of the player.
     * @return the player list if exist and return null if don't exist.
     */
    public List<Player> findPlayersByTeam(Team team){
        return null;
    }
    
    /**
     * create a new team and add it to the list.
     * @param team the team to add.
     * @return 0 if added, 1 if exist , 2 if null, 3 user input error.
     */
    public int addTeam(Team team){
        return 0;
    }
    
    /**
     * modify the data of the team.
     * @param Team the team to modify.
     * @return 0 if added, 1 if exist , 2 if null, 3 user input error.
     */
    public int modifyTeam(Team Team){
        return 0;
    }
    
    /**
     * delete a team.
     * @param team the team to delete.
     * @return 0 if added, 1 if exist , 2 if null, 3 user input error.
     */
    public int removeTeam(Team team){
        return 0;
    }
    
    /**
     * add new player to the list.
     * @param player the player to add
     * @return 0 if added, 1 if exist , 2 if null, 3 user input error.
     */
    public int addPlayer(Player player){
        return 0;
    }
    
    /**
     * modify data player.
     * @param player the player to modify.
     * @return 0 if added, 1 if exist , 2 if null, 3 user input error.
     */
    public int modifyPlayer(Player player){
        return 0;
    }
    
    /**
     * delete the player.
     * @param player the player to delete.
     * @return 0 if added, 1 if exist , 2 if null, 3 user input error.
     */
    public int removePlayer(Player player){
        return 0;
    }
    
    /**
     * add player to team.
     * @param team the team to add in.
     * @param player the player to add on the team.
     * @return 0 if added, 1 if exist , 2 if null, 3 user input error.
     */
        public int enrolPlayerToTeam(Team team, Player player){
        return 0;
    }
    
    /**
     * remove player of a team.
     * @param team the team to remove the player.
     * @param player the player to remove of the team.
     * @return 0 if added, 1 if exist , 2 if null, 3 user input error.
     */
    public int unenrolPlayerToTeam(Team team, Player player){
        return 0;
    }

}
