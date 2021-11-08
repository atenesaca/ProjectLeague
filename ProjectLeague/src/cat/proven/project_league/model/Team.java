/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cat.proven.project_league.model;

/**
 * ADT for Team.
 *
 * @author Andres, Rudy y Samar
 */
public class Team {

    //attributes
    private long id;
    private String name;
    private String coach;
    private String category;
    private double budget;

    //constructor
    public Team() {
    }

    public Team(long id, String name, String coach, String category, double budget) {
        this.id = id;
        this.name = name;
        this.coach = coach;
        this.category = category;
        this.budget = budget;
    }

    public Team(Team other) {
        this.id = other.id;
        this.name = other.name;
        this.coach = other.coach;
        this.category = other.category;
        this.budget = other.budget;
    }

    public Team(String name) {
        this.name = name;
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

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    //Equals and Hashcode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Team other = (Team) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    //toString
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("id = ").append(id);
        sb.append(", name = ").append(name);
        sb.append(", coach = ").append(coach);
        sb.append(", category = ").append(category);
        sb.append(", budget = ").append(budget);
        return sb.toString();
    }
}
