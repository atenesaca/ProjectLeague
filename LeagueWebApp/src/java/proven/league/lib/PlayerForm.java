/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proven.league.lib;

import cat.proven.project_league.model.Player;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Andrés
 */
public class PlayerForm {
    
    /**
     * gets and validates data sent by client.
     * @param request http request object to get data from
     * @return palyer object with data sent from client or null in case of error.
     */
    public static Player ofPlayerForm(HttpServletRequest request) {
        Player player = null;
        try {
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String sbirthday = request.getParameter("birthday");
            String ssalary = request.getParameter("salary");
            String sidteam = request.getParameter("idteam");
            if ((name == null) || (surname==null)
                    || (sbirthday==null) || (ssalary==null)
                    || (sidteam==null)) {
                player = null;
            } else {
                double salary = Double.parseDouble(ssalary);
                long idteam = Long.parseLong(sidteam);
                
//                try{
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate birthday = LocalDate.parse(sbirthday, formatter);
                    player = new Player(name, surname, birthday, salary, idteam);
//                }
//                catch(ParseException pe){
//                    player = null;
//                }
            }            
        } catch (NumberFormatException e) {
            player = null;
        }
        return player;
    }
    
    public static Player ofPlayerModifyForm(HttpServletRequest request) {
        Player player = null;
        try {
            String sid = request.getParameter("id");
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String sbirthday = request.getParameter("birthday");
            String ssalary = request.getParameter("salary");
            String sidteam = request.getParameter("idteam");
            if ((sid == null) ||(name == null) || (surname==null)
                    || (sbirthday==null) || (ssalary==null)
                    || (sidteam==null)) {
                player = null;
            } else {
                long id = Long.parseLong(sid);
                double salary = Double.parseDouble(ssalary);
                long idteam = Long.parseLong(sidteam);
                
//                try{
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate birthday = LocalDate.parse(sbirthday, formatter);
                    player = new Player(id, name, surname, birthday, salary, idteam);
//                }
//                catch(ParseException pe){
//                    player = null;
//                }
            }            
        } catch (NumberFormatException e) {
            player = null;
        }
        return player;
    }
    
    /**
     * gets and validate Player ang return different code errors
     * -1 id not informed
     * -2 id not integer
     * -3 name not informed
     * -4 surname not informed
     * -5 birthday not informed
     * -6 birthday not informed
     * -7 salary not informed
     * -8 salary not integer
     * -9 idteam not informed
     * -10 idteam not integer
     * @param request
     * @return RequestResult (Team, code)
     */   
    public static RequestResult getParameters(HttpServletRequest request) {
        RequestResult result = null;
        Player player = null;
        int code=0;
        try {
            String sid = request.getParameter("id");
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String sbirthday = request.getParameter("birthday");
            String ssalary = request.getParameter("salary");
            String sidteam = request.getParameter("idteam");
            if (sid == null) {
                code = -1;           
            }
            else if (name == null) {
                code = -3;           
            }
            else if (surname==null){
                code = -4;
            }
            else if (sbirthday==null){
                code = -5;
            }
            else if (ssalary==null){
                code = -7;
            }
            else if (sidteam==null){
                code = -9;
            }
            else {
                long id = Long.parseLong(sid);
                double salary = Double.parseDouble(ssalary);
                long idteam = Long.parseLong(sidteam);
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate birthday = LocalDate.parse(sbirthday, formatter);
                player = new Player(id, name, surname, birthday, salary, idteam);
            }            
        } catch (NumberFormatException e) {
            code = -2;
        }
        if(player != null){
            result = new RequestResult(player,1);
        }else {
            result = new RequestResult("Error in  parameters"
                                       ,code);
        }
        return result;
    }
}
