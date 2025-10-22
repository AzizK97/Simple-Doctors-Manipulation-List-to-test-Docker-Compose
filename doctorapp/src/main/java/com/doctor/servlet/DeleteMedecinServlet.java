package com.doctor.servlet;

import com.doctor.dao.MedecinDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete-medecin")
public class DeleteMedecinServlet extends HttpServlet {
    private MedecinDAO medecinDAO;
    
    @Override
    public void init() throws ServletException {
        medecinDAO = new MedecinDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String idParam = request.getParameter("id");
        if (idParam != null) {
            try {
                int id = Integer.parseInt(idParam);
                medecinDAO.deleteMedecin(id);
            } catch (Exception e) {
                throw new ServletException("Error deleting doctor", e);
            }
        }
        response.sendRedirect("list-medecins");
    }
}