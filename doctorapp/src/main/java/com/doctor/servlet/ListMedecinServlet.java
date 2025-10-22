package com.doctor.servlet;

import com.doctor.dao.MedecinDAO;
import com.doctor.model.Medecin;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet({"/", "/list-medecins"})
public class ListMedecinServlet extends HttpServlet {
    private MedecinDAO medecinDAO;
    
    @Override
    public void init() throws ServletException {
        medecinDAO = new MedecinDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        try {
            List<Medecin> medecins = medecinDAO.getAllMedecins();
            request.setAttribute("medecins", medecins);
            request.getRequestDispatcher("/list-medecins.jsp").forward(request, response);
        } catch (Exception e) {
            throw new ServletException("Error retrieving doctors", e);
        }
    }
}