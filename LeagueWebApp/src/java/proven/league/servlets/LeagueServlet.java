package proven.league.servlets;

import javax.servlet.http.HttpServlet;
import cat.proven.project_league.model.LeagueModel;
import cat.proven.project_league.model.Team;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andrés Tenesaca, Rudy Pasache
 */
public class LeagueServlet extends HttpServlet {
    private LeagueModel model;
    
    @Override
    public void init() throws ServletException {
        this.model = new LeagueModel();
    }
    
    /**
     * Handles the HTTP (code)GET(/code) method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    /**
     * <strong>processRequest()</strong>
     * executes actions to manage categories.
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    public void processRequest(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException {
        
        listAllTeamsTxt(request, response);
    }
    
    /**
     * serves a list of all friends in text format 
     *
     * @param request
     * @param response
     * @throws javax.servlet.ServletException
     * @throws java.io.IOException
     */
    public void listAllTeamsTxt(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Team> teamList = model.findAllTeams();
        try (PrintWriter out = response.getWriter()) {
        
            for (Team team : teamList) {
                System.out.println(team.toString());
                out.print(team.toString());
            }
        }
    }
}
