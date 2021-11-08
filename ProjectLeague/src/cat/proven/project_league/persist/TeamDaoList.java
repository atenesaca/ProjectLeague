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
 * DAO class for Team persistence in a list.
 * Implements singleton pattern.
 * @author Andres, Rudy
 */
public class TeamDaoList implements TeamDaoInterface{
    
    private static TeamDaoList instance;
    private final List<Team> data;
    
    private TeamDaoList(){
        data = new ArrayList<>();
    }
    
    public static TeamDaoList getInstance(){
      if (instance == null) {
           instance = new TeamDaoList();
      }
      return instance;
    }

    @Override
    public List<Team> findAllTeams() {
        if(data.isEmpty()){
            return null;
        }
        else {
            return data;
        }
    }

    @Override
    public Team findTeamById(Team team) {
        int index = data.indexOf(team.getId());
        return data.get(index);
    }

    @Override
    public Team findTeamByName(Team team) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Team> findTeamsByCategory(Team team) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int addTeam(Team team) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public int modifyTeam(Team Team) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int removeTeam(Team team) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
