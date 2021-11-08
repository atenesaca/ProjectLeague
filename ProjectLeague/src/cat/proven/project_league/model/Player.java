/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.project_league.model;

import java.util.Date;

/**
 * ADT for a Player.
 *
 * @author Andres, Rudy y Samar
 */
public class Player {

    //attributes
    private long id;
    private String name;
    private String surname;
    private Date birthday;
    private double salary;
    private long idTeam;

    //constructor
    public Player() {
    }

    public Player(long id, String name, String surname, Date birthday, double salary, long fullname, long idTeam) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.salary = salary;
        this.idTeam = idTeam;
    }

    public Player(Player other) {
        this.id = other.id;
        this.name = other.name;
        this.surname = other.surname;
        this.birthday = other.birthday;
        this.salary = other.salary;
        this.idTeam = other.idTeam;
    }

    //Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public long getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(long idTeam) {
        this.idTeam = idTeam;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + (int) (this.id ^ (this.id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    //toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(" id = ").append(id);
        sb.append(" name = ").append(name);
        sb.append(", surname = ").append(surname);
        sb.append(", birthday = ").append(birthday);
        sb.append(", salary = ").append(salary);
        sb.append(", idTeam = ").append(idTeam);
        return sb.toString();
    }

}
