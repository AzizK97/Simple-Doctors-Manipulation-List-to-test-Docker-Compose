package com.doctor.servlet;

import com.doctor.dao.MedecinDAO;
import com.doctor.model.Medecin;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/add-medecin")
public class AddMedecinServlet extends HttpServlet {
    private MedecinDAO medecinDAO;
    
    @Override
    public void init() throws ServletException {
        medecinDAO = new MedecinDAO();
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String specialite = request.getParameter("specialite");
        String telephone = request.getParameter("telephone");
        String email = request.getParameter("email");
        String hopital = request.getParameter("hopital");
        
        Medecin medecin = new Medecin();
        medecin.setNom(nom);
        medecin.setPrenom(prenom);
        medecin.setSpecialite(specialite);
        medecin.setTelephone(telephone);
        medecin.setEmail(email);
        medecin.setHopital(hopital);
        
        try {
            medecinDAO.addMedecin(medecin);
            response.sendRedirect("list-medecins");
        } catch (Exception e) {
            throw new ServletException("Error adding doctor", e);
        }
    }
}