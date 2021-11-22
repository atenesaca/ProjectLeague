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
        Team team = new Team(id);
        Team team1 = null;
        
        for (Team t : data) {
            if(t.equals(team)){
               team1 = t; 
            }
        }
        return team1;
    }

    @Override
    public Team findTeamByName(String surname) {
        Team team1 = null;
        for (Team team : data) {
            if(team.getName().equals(surname)){
                team1 = team;
            }
        }
        return team1
;    }

    @Override
    public List<Team> findTeamsByCategory(String category) {
        List<Team> list = new ArrayList<>();
        
        for (Team team : data) {
            if(team.getCategory().equals(category)){
                list.add(team);
            }
        }
        return list;
    }

    @Override
    public boolean addTeam(Team team) {
        boolean flag = false;
        
        int id = data.size();
        id += 1;
        team.setId(id);
        
        if(data.add(team)){
            flag = true;
        }
        
        return flag;
    }

    @Override
    public boolean modifyTeam(Team team) {
        boolean flag = false;
        
        if(data.contains(team)){
            for (Team t1 : data) {
                if(t1.equals(team)){
                    t1.setName(team.getName());
                    t1.setCoach(team.getCoach());
                    t1.setCategory(team.getCategory());
                    t1.setBudget(team.getBudget());
                }
            }
            flag = true;
        }
        
        return flag;
    }

    @Override
    public boolean removeTeam(Team team) {
        boolean flag = false;
        
        if(data.contains(team)){
            data.remove(team);
        }
        
        return flag;
    }

}
