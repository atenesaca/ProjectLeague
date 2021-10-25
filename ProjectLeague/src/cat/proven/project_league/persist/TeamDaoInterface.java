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
     * List all teams
     *
     * @return list of all the teams
     */
    List<Team> findAllTeams();

    /**
     * search the team by id.
     *
     * @param id the id of the team.
     * @return the team
     */
    Team findTeamById(long id);

    /**
     * search the team by name.
     *
     * @param name the name of the team.
     * @return the team
     */
    Team findTeamByName(String name);

    /**
     * search the team by category.
     *
     * @param Category the category of the team.
     * @return the team
     */
    List<Team> findTeamsByCategory(String Category);

    /**
     * create a new team
     *
     * @param team the team to add.
     * @return number of entries affected by the operation
     */
    int addTeam(Team team);

    /**
     * modify the data of the team.
     *
     * @param Team the team to modify.
     * @return number of entries affected by the operation
     */
    int modifyTeam(Team Team);

    /**
     * delete a team.
     *
     * @param team the team to delete.
     * @return number of entries affected by the operation
     */
    int removeTeam(Team team);
}
