/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.project_league.persist;

import cat.proven.project_league.model.Team;
import java.util.ArrayList;
import java.util.List;

/**
 * DAO class for Team persistence in a list. Implements singleton pattern.
 *
 * @author Andres, Rudy
 */
public class TeamDaoList implements TeamDaoInterface {

    private static TeamDaoList instance;
    private final List<Team> data;

    private TeamDaoList() {
        data = new ArrayList<>();
    }

    public static TeamDaoList getInstance() {
        if (instance == null) {
            instance = new TeamDaoList();
        }
        return instance;
    }

    @Override
    public List<Team> findAllTeams() {
        if (data.isEmpty()) {
            return null;
        } else {
            return data;
        }
    }

    @Override
    public Team findTeamById(long id) {
        return null;
    }

    @Override
    public Team findTeamByName(String surname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Team> findTeamsByCategory(String category) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean addTeam(Team team) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean modifyTeam(Team Team) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeTeam(Team team) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
