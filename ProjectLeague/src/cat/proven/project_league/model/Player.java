/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.project_league.model;

import java.util.Date;
import java.util.Objects;

/**
 *
 * @author alumne
 */
public class Player {
    
    //attributes
    private String name;
    private String surname;
    private Date birthday;
    private double salary;
    private long fullname;
    private long idTeam;
    
    //constructor

    public Player() {
    }

    public Player(String name, String surname, Date birthday, double salary, long fullname, long idTeam) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.salary = salary;
        this.fullname = fullname;
        this.idTeam = idTeam;
    }
    
    public Player(Player other) {
        this.name = other.name;
        this.surname = other.surname;
        this.birthday = other.birthday;
        this.salary = other.salary;
        this.fullname = other.fullname;
        this.idTeam = other.idTeam;
    }

    public Player(long fullname) {
        this.fullname = fullname;
    }
    
    //Getters and Setters
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

    public long getFullname() {
        return fullname;
    }

    public void setFullname(long fullname) {
        this.fullname = fullname;
    }

    public long getIdTeam() {
        return idTeam;
    }

    public void setIdTeam(long idTeam) {
        this.idTeam = idTeam;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.surname);
        hash = 97 * hash + Objects.hashCode(this.birthday);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.salary) ^ (Double.doubleToLongBits(this.salary) >>> 32));
        hash = 97 * hash + (int) (this.fullname ^ (this.fullname >>> 32));
        hash = 97 * hash + (int) (this.idTeam ^ (this.idTeam >>> 32));
        return hash;
    }

    //Equals and Hascode
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
        if (Double.doubleToLongBits(this.salary) != Double.doubleToLongBits(other.salary)) {
            return false;
        }
        if (this.fullname != other.fullname) {
            return false;
        }
        if (this.idTeam != other.idTeam) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.surname, other.surname)) {
            return false;
        }
        if (!Objects.equals(this.birthday, other.birthday)) {
            return false;
        }
        return true;
    }

    //toString

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("Name = ").append(name);
        sb.append(", surname = ").append(surname);
        sb.append(", birthday = ").append(birthday);
        sb.append(", salary = ").append(salary);
        sb.append(", fullname = ").append(fullname);
        sb.append(", idTeam = ").append(idTeam);
        return sb.toString();
    }
    
    
    
}
