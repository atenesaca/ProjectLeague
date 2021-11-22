/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.project_league.persist;

import cat.proven.project_league.model.Player;
import cat.proven.project_league.model.Team;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alumne
 */
public class PlayerDaoList implements PlayerDaoInterface {

    public static PlayerDaoList instance;
    private final List<Player> data;

    public PlayerDaoList() {
        data = new ArrayList<>();
    }

    public static PlayerDaoList getInstance() {
        if (instance == null) {
            instance = new PlayerDaoList();
        }
        return instance;
    }

    @Override
    public Player findPlayerById(long id) {
        Player player = new Player(id);
        Player player1 = null;

        for (Player p : data) {
            if (p.equals(player)) {
                player1 = p;
            }
        }
        return player1;
    }

    @Override
    public List<Player> findPlayerByFullName(String fullname) {
        List<Player> list = new ArrayList<>();

        for (Player player : data) {
            String name = player.getName();
            String surname = player.getSurname();

            String fullname1 = name + " " + surname;

            if (fullname1.equals(fullname)) {
                list.add(player);
            }
        }

        return list;
    }

    @Override
    public List<Player> findPlayersByTeam(Team team) {
        List<Player> list = new ArrayList<>();

        for (Player player : data) {
            if (player.getIdTeam() == team.getId()) {
                list.add(player);
            }
        }

        return list;
    }

    @Override
    public boolean addPlayer(Player player) {
        boolean flag = false;

        int id = data.size();
        id += 1;
        player.setId(id);

        if (data.add(player)) {
            flag = true;
        }

        return flag;
    }

    @Override
    public boolean modifyPlayer(Player player) {
        boolean flag = false;
        if (data.contains(player)) {
            for (Player player1 : data) {
                if (player1.equals(player)) {
                    player1.setName(player.getName());
                    player1.setSurname(player.getSurname());
                    player1.setBirthday(player.getBirthday());
                    player1.setSalary(player.getSalary());
                }
            }
            flag = true;
        }
        return flag;
    }

    @Override
    public boolean removePlayer(Player player) {
        boolean flag = false;

        if (data.contains(player)) {
            data.remove(player);
        }

        return flag;
    }

    @Override
    public int enrolPlayerToTeam(Team team, Player player) {
        int flag = 0;

        double budget = team.getBudget() - player.getSalary();

        if (player.getIdTeam() != -1) {
            flag = -2;
        } else {
            if (budget <= 0) {
                flag = -1;
            } else {
                player.setIdTeam(team.getId());
                flag = 1;
            }
        }
        return flag;
    }

    @Override
    public int unenrolPlayerToTeam(Team team, Player player) {
        int flag = 0;
        

        if (player.getIdTeam() == -1) {
            flag = -1;
        } else {
            player.setIdTeam(-1);
            flag = 1;
        }
        return flag;
    }

}
