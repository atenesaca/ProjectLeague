/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.project_league.persist;

import cat.proven.project_league.model.Team;
import java.util.List;

/**
 * Class team interface where designate functions to develop in TeamDaoList
 *
 * @author Andres, Rudy
 */
public interface TeamDaoInterface {

    /**
     * Search all teams
     *
     * @return the data of the teams
     */
    List<Team> findAllTeams();

    /**
     * Search all teams by id
     *
     * @param id the id of the team
     * @return a team with the same searched id, else return null
     */
    Team findTeamById(long id);

    /**
     * Search teams by name
     *
     * @param name the name to find.
     * @return  a team with the name searched, else return null
     *          team can not have the same name
     */
    Team findTeamByName(String name);

    /**
     * Search teams with the same category.
     *
     * @param category the category to find.
     * @return teams with the same category, else return an empty list
     */
    List<Team> findTeamsByCategory(String category);

    /**
     * Created a new team.
     *
     * @param team the new team to add.
     * @return  true if the team is added correctly, false otherwise.
     *          only add teams with different names and id, there can not be teams with
     *          the same name and id
     */
    boolean addTeam(Team team);

    /**
     * Modify the data of a team.
     *
     * @param team the data of the team to modify, the id will not be modified
     * @return true if the team is modified correctly, false otherwise.
     */
    boolean modifyTeam(Team team);

    /**
     * Delete a team
     *
     * @param team the team to delete.
     * @return search if the team exist ,
     *         true if the team is removed correctly, false otherwise.
     */
    boolean removeTeam(Team team);
}
