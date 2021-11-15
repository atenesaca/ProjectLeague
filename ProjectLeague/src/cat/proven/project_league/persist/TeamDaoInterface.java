/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.project_league.persist;

import cat.proven.project_league.model.Team;
import java.util.List;

/**
 * Class team interface where appoint functions to develop in TeamDaoList
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
     * @return teams with the same searched id
     */
    Team findTeamById(long id);

    /**
     * Search teams by name
     *
     * @param name the name to find.
     * @return teams with the name searched
     */
    Team findTeamByName(String name);

    /**
     * Search teams with the same category.
     *
     * @param category the category to find.
     * @return teams with the same category
     */
    List<Team> findTeamsByCategory(String category);

    /**
     * Created a new team.
     *
     * @param team the new team to add.
     * @return true if the player is added correctly, false otherwise.
     */
    boolean addTeam(Team team);

    /**
     * Modify the data of a team.
     *
     * @param Team the team to modify.
     * @return true if the player is modified correctly, false otherwise.
     */
    boolean modifyTeam(Team Team);

    /**
     * The team to delete.
     *
     * @param team the team to delete.
     * @return true if the player is removed correctly, false otherwise.
     */
    boolean removeTeam(Team team);
}
