/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.project_league.persist;

import cat.proven.project_league.model.Team;
import java.util.List;

/**
 *
 * @author Andres, Rudy
 */
public interface TeamDaoInterface {

    /**
     * Displays all the teams in the list
     *
     * @return list of all the teams
     */
    List<Team> findAllTeams();

    /**
     * Display all the teams searched by id given by user.
     *
     * @param team the team with the id to find.
     * @return teams with the same searched id
     */
    Team findTeamById(Team team);

    /**
     * Display teams which name equals with the name to search
     *
     * @param team the theam with the name to find.
     * @return teams with the name searched
     */
    Team findTeamByName(Team team);

    /**
     * Search teams with the same category given by user.
     *
     * @param team the team with the category to find.
     * @return teams with the same category
     */
    List<Team> findTeamsByCategory(Team team);

    /**
     * Created a new team with data given by user.
     *
     * @param team the new team to add to the list.
     * @return  0 if an error ocurred while deleting the team
     *          1 if added succesfully
     *          2 if there is an error with the format of the data
     */
    int addTeam(Team team);

    /**
     * Modify the data of an existing team
     *
     * @param Team the team to modify.
     * @return  0 if an error ocurred while deleting the team
     *          1 if added succesfully
     *          2 if there is an error with the format of the data
     */
    int modifyTeam(Team Team);

    /**
     * The team to delte from the list.
     *
     * @param team the team to delete.
     * @return  0 if an error ocurred while deleting the team
     *          1 if added succesfully
     *          2 if there is an error with the format of the data
     */
    int removeTeam(Team team);
}
