package proven.league.servlets;

import cat.proven.project_league.model.LeagueModel;
import cat.proven.project_league.model.Player;
import cat.proven.project_league.model.Team;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import proven.league.lib.PlayerForm;
import proven.league.lib.RequestResult;
import proven.league.lib.TeamForm;
import proven.users.model.persist.PermissionDaoList;

/**
 * Servlet to resolve requests in Project League application
 *
 * @author Andrés Tenesaca, Rudy Pasache
 */
public class LeagueServletJson extends HttpServlet{
    
    /**
     * the model: provides data access.
     */
    private LeagueModel model;
    private PermissionDaoList permission;
    
    @Override
    public void init() throws ServletException {
        this.model = new LeagueModel();
        this.permission = new PermissionDaoList();
    }

    /**
     * Handles the HTTP GET method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String action = request.getParameter("action");
        if (action != null) {
            if(secured(request)){
                switch (action) {
                    case "list_all_teams": //list all teams
                        listAllTeams(request, response);
                        break;
                    case "find_team_by_id": //find team by id
                        findTeamById(request, response);
                        break;
                    case "find_team_by_name": //find team by name
                        findTeamByName(request, response);
                        break;
                    case "find_team_by_category": //find team by category
                        findTeamByCategory(request, response);
                        break;
                    case "find_player_by_id": //find player by id
                        findPlayerById(request, response);
                        break;
                    case "find_player_by_fullname": //find player by fullname
                        findPlayerByFullname(request, response);
                        break;
                    case "find_player_by_idteam": //find player by idtem
                        findPlayerByIdteam(request, response);
                        break;
                    default: //unknown option.
                        redirectError(request, response, "method_not_allowed");
                        break;
                }
            }
            else {
                redirectError(request, response, "not_authorized");
            }
        } else { // parameter action needed
            redirectError(request, response, "no_action");
        }
    }
    
    /**
     * Handles the HTTP POST method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "add_player": //add a new player
                    if(secured(request)){
                        addNewPlayer(request, response);
                    }
                    break;
                case "modify_player": //modify a player
                    if(secured(request)){
                        modifyPlayer(request, response);
                    }
                    break;
                case "remove_player": //remove a player
                    if(secured(request)){
                        removePlayer(request, response);
                    }
                    break;
                case "unenrol_player": //unenrol a player from a team
                    if(secured(request)){
                        unenrolPlayer(request, response);
                    }
                    break;
                case "enrol_player": //enrol a player to a team
                    if(secured(request)){
                        enrolPlayer(request, response);
                    }
                    break;
                case "add_team": //add a new team
                    if(secured(request)){
                        addTeam(request, response);
                    }
                    break;
                case "modify_team": //modify a team
                    if(secured(request)){
                        modifyTeam(request, response);
                    }
                    break;
                case "remove_team": //remove a team
                    if(secured(request)){
                       removeTeam(request, response);
                    }
                    break;
                default: //unknown option.
                    redirectError(request, response, "method_not_allowed");
                    break;
            }
        } else { // parameter action needed
            redirectError(request, response, "no_action");
        }
    }
    
    /**
     * Handles the HTTP PUT method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        redirectError(request, response, "method_not_allowed");
    }
    
    /**
     * Handles the HTTP DELETE method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        redirectError(request, response, "method_not_allowed");
    }
    
    /**
     * serves error responses.
     *
     * @param request
     * @param response
     * @param error
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    public void redirectError(HttpServletRequest request, HttpServletResponse response, String error)
            throws ServletException, IOException {
        String errorMsg;
        int errorCode;
        switch (error) {
            case "bad_parameter": // bad parameter action
                errorMsg = "Invalid action parameter";
                errorCode = HttpServletResponse.SC_BAD_REQUEST;
                break;
            case "method_not_allowed": //method not allowed.
                errorMsg = "Method not allowed";
                errorCode = HttpServletResponse.SC_METHOD_NOT_ALLOWED;
                break;
            case "not_authorized":
                errorMsg = "Permission denied";
                errorCode = HttpServletResponse.SC_UNAUTHORIZED;
                break;
            default: // need parameter action
                errorMsg = "Parameter action needed";
                errorCode = HttpServletResponse.SC_BAD_REQUEST;
                break;
        }
        response.sendError(errorCode, errorMsg);
    }

    /**
     * serves a list of all Teams
     *
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    private void listAllTeams(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Team> teamList = model.findAllTeams();
        RequestResult result = new RequestResult(teamList, 1);
        request.setAttribute("result", result);
        RequestDispatcher rd = getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/json-result.jsp");
        rd.forward(request, response);
    }

    /**
     * Search a Team by id in data source of Model
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void findTeamById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        RequestResult result;
        if(id > 0){
            Team found = model.findTeamById(id);
            
            if (found != null) {
                result = new RequestResult(found, 1);
            } else {
                result = new RequestResult(null, -2);
            }
        } else {
            result = new RequestResult(null, -1);
        }
        request.setAttribute("result", result);
        RequestDispatcher rd = getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/json-result.jsp");
        rd.forward(request, response);
    }
    
    /**
     * Search a Team by name in data source of Model
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void findTeamByName(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        RequestResult result;
        if(name != null){
            Team found = model.findTeamByName(name);
            
            if (found != null) {
                result = new RequestResult(found, 1);
            } else {
                result = new RequestResult(null, -2);
            }
        } else {
            result = new RequestResult(null, -1);
        }
        request.setAttribute("result", result);
        RequestDispatcher rd = getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/json-result.jsp");
        rd.forward(request, response);
    }

    /**
     * Search a list of Teams by category in data source of Model
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void findTeamByCategory(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String category = request.getParameter("category");
        RequestResult result;
        if(category != null){
            List<Team> found = model.findTeamsByCategory(category);
            
            if (found != null) {
                result = new RequestResult(found, 1);
            } else {
                result = new RequestResult(null, -2);
            }
        } else {
            result = new RequestResult(null, -1);
        }
        request.setAttribute("result", result);
        RequestDispatcher rd = getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/json-result.jsp");
        rd.forward(request, response);
    }
    
    /**
     * Search a Player by id in data source of Model
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void findPlayerById(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long id = Long.parseLong(request.getParameter("id"));
        RequestResult result;
        if(id > 0){
            Player found = model.findPlayerById(id);
            
            if (found != null) {
                result = new RequestResult(found, 1);
            } else {
                result = new RequestResult(null, -2);
            }
        } else {
            result = new RequestResult(null, -1);
        }
        request.setAttribute("result", result);
        RequestDispatcher rd = getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/json-result.jsp");
        rd.forward(request, response);
    }
    
    /**
     * Search a Player by fullname in data source of Model
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void findPlayerByFullname(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String fullname = request.getParameter("fullname");
        RequestResult result;
        if(fullname != null){
            Player found = model.findPlayerByFullName(fullname);
            
            if (found != null) {
                result = new RequestResult(found, 1);
            } else {
                result = new RequestResult(null, -2);
            }
        } else {
            result = new RequestResult(null, -1);
        }
        request.setAttribute("result", result);
        RequestDispatcher rd = getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/json-result.jsp");
        rd.forward(request, response);
    }

    /**
     * Search a List of Players by team in data source of Model
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void findPlayerByIdteam(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestResult result;
        try{
            Long idteam = Long.parseLong(request.getParameter("idteam"));
            if(idteam > 0){
                Team team = new Team(idteam);
                List<Player> found = model.findPlayersByIdteam(team);

                if (found != null) {
                    result = new RequestResult(found, 1);
                } else {
                    result = new RequestResult(null, -2);
                }
            } else {
                result = new RequestResult(null, -1);
            }
            request.setAttribute("result", result);
            RequestDispatcher rd = getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsp/json-result.jsp");
            rd.forward(request, response);
        }
        catch(NumberFormatException nfe){
            result = new RequestResult(null, -3);
            request.setAttribute("result", result);
            RequestDispatcher rd = getServletContext()
                    .getRequestDispatcher("/WEB-INF/jsp/json-result.jsp");
            rd.forward(request, response);
        }
    }
    
    /**
     * Add a Player to data source of Model
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void addNewPlayer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean flag;
        int resultCode = -1;
        Player player = PlayerForm.ofPlayerForm(request);
        if (player != null) {
            flag = model.addPlayer(player);
            if(flag){
                resultCode = 1;
            }
        } else {
            resultCode = -1;
        }
        RequestResult result = new RequestResult(player, resultCode);
        request.setAttribute("result", result);
        RequestDispatcher rd = getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/json-result.jsp");
        rd.forward(request, response);
    }

    /**
     * Modify a Player fronm data source of Model
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void modifyPlayer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Player player = PlayerForm.ofPlayerModifyForm(request);
        int resultCode = -1;
        boolean flag;
        if (player != null) {
            flag = model.modifyPlayer(player);
            if(flag){
                resultCode = 1;
            }
        } else {
            resultCode = -1;
        }
        RequestResult result = new RequestResult(player, resultCode);
        request.setAttribute("result", result);
        RequestDispatcher rd = getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/json-result.jsp");
        rd.forward(request, response);
    }
    
    /**
     * Remove a Player from data source of Model
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void removePlayer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Player player = PlayerForm.ofPlayerForm(request);
        int resultCode = -1;
        boolean flag;
        if (player != null) {
            flag = model.removePlayer(player);
            if(flag){
                resultCode = 1;
            }
        }
        RequestResult result = new RequestResult(player, resultCode);
        request.setAttribute("result", result);
        RequestDispatcher rd = getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/json-result.jsp");
        rd.forward(request, response);
    }

    /**
     * Unenrol a Player from a team from data source of Model
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void unenrolPlayer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Player player = PlayerForm.ofPlayerForm(request);
        int resultCode = -1;
        
        if (player != null) {
            resultCode = model.unenrolPlayerToTeam(player);
        }
        RequestResult result = new RequestResult(player, resultCode);
        request.setAttribute("result", result);
        RequestDispatcher rd = getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/json-result.jsp");
        rd.forward(request, response);
    }

    /**
     * Enrol a Player to a team from data source of Model
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void enrolPlayer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Player player = PlayerForm.ofPlayerForm(request);
        Team team = TeamForm.ofTeamForm(request);
        int resultCode = -1;
        
        if (player != null & team != null) {
            resultCode = model.enrolPlayerToTeam(team, player);
        }
        RequestResult result = new RequestResult(player, resultCode);
        request.setAttribute("result", result);
        RequestDispatcher rd = getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/json-result.jsp");
        rd.forward(request, response);
    }

    /**
     * Add a team from data source of Model
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void addTeam(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        boolean flag;
        int resultCode = -1;
        Team team = TeamForm.ofTeamForm(request);
        if (team != null) {
            flag = model.addTeam(team);
            if(flag){
                resultCode = 1;
            }
        } else {
            resultCode = -1;
        }
        RequestResult result = new RequestResult(team, resultCode);
        request.setAttribute("result", result);
        RequestDispatcher rd = getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/json-result.jsp");
        rd.forward(request, response);
    }

    /**
     * Modify a team from data source of Model
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void modifyTeam(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Team team = TeamForm.ofTeamForm(request);
        int resultCode = -1;
        boolean flag;
        if (team != null) {
            flag = model.modifyTeam(team);
            if(flag){
                resultCode = 1;
            }
        } else {
            resultCode = -1;
        }
        RequestResult result = new RequestResult(team, resultCode);
        request.setAttribute("result", result);
        RequestDispatcher rd = getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/json-result.jsp");
        rd.forward(request, response);
    }
    
    /**
     * Remove a team from data source of Model
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void removeTeam(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Team team = TeamForm.ofTeamForm(request);
        int resultCode = -1;
        boolean flag;
        if (team != null) {
            flag = model.removeTeam(team);
            if(flag){
                resultCode = 1;
            }
        }
        RequestResult result = new RequestResult(team, resultCode);
        request.setAttribute("result", result);
        RequestDispatcher rd = getServletContext()
                .getRequestDispatcher("/WEB-INF/jsp/json-result.jsp");
        rd.forward(request, response);
    }
    
    /**
     * Validates role and session of authenticated User
     *
     * @param request
     * @return true if user has session authenticated , false otherwise
     */
    private boolean secured(HttpServletRequest request) {
        boolean logged = false;
        HttpSession session = request.getSession(false);
        
        if (session != null) {
            
            String action = request.getParameter("action");
            String role = (String) session.getAttribute("userrole");
            
            logged = permission.isGranted(role, action);

            
        } else {
            logged = false;
        }
        return logged;
    }
}
