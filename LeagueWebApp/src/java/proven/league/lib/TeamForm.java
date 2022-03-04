/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proven.league.lib;

import cat.proven.project_league.model.Team;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Andrés
 */
public class TeamForm {
    /**
     * gets and validates data sent by client.
     * @param request http request object to get data from
     * @return team object with data sent from client or null in case of error.
     */
    public static Team ofTeamForm(HttpServletRequest request) {
        Team team = null;
        try {
            String sid = request.getParameter("id");
            String name = request.getParameter("name");
            String coach = request.getParameter("coach");
            String category = request.getParameter("category");
            String sbudget = request.getParameter("budget");
            if ((sid == null) || (name == null) || (coach==null)
                    || (category==null) || (sbudget==null)) {
                team = null;
            } else {
                long id = Long.parseLong(sid);
                double budget = Double.parseDouble(sbudget);
                team = new Team(id, name, coach, category, budget);                
            }            
        } catch (NumberFormatException e) {
            team = null;
        }
        return team;
    }
    
    /**
     * gets and validate Team ang return different code errors
     * -1 id not informed
     * -2 id not integer
     * -3 name not informed
     * -4 coach not informed
     * -5 category not informed
     * -6 budget not informed
     * -7 budget not double
     * @param request
     * @return RequestResult (Team, code)
     */   
    public static RequestResult getParameters(HttpServletRequest request) {
        RequestResult result = null;
        Team team = null;
        int code=0;
        try {
            String sid = request.getParameter("id");
            String name = request.getParameter("name");
            String coach = request.getParameter("coach");
            String category = request.getParameter("category");
            String sbudget = request.getParameter("budget");
            if (sid == null) {
                code = -1;           
            }
            else if (name == null) {
                code = -3;           
            } else if (coach == null){
                code = -4;
            }else if (category==null){
                code = -5;
            }
            else if (sbudget==null){
                code = -6;
            }
            else {
                long id = Long.parseLong(sid);
                try{
                    double budget = Double.parseDouble(sbudget);
                    team = new Team(id, name, coach, category, budget);   
                }
                catch(NumberFormatException e){
                    code = -7;
                }
                           
            }            
        } catch (NumberFormatException e) {
            code = -2;
        }
        if(team != null){
            result = new RequestResult(team,1);
        }else {
            result = new RequestResult("Error in  parameters"
                                       ,code);
        }
        return result;
    }
}
