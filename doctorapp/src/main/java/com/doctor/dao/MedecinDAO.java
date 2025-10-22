package com.doctor.dao;

import com.doctor.model.Medecin;
import com.doctor.util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedecinDAO {
    
    public void addMedecin(Medecin medecin) throws SQLException {
        String sql = "INSERT INTO medecin (nom, prenom, specialite, telephone, email, hopital) VALUES (?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, medecin.getNom());
            stmt.setString(2, medecin.getPrenom());
            stmt.setString(3, medecin.getSpecialite());
            stmt.setString(4, medecin.getTelephone());
            stmt.setString(5, medecin.getEmail());
            stmt.setString(6, medecin.getHopital());
            
            stmt.executeUpdate();
        }
    }
    
    public List<Medecin> getAllMedecins() throws SQLException {
        List<Medecin> medecins = new ArrayList<>();
        String sql = "SELECT * FROM medecin ORDER BY id DESC";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Medecin medecin = new Medecin(
                    rs.getInt("id"),
                    rs.getString("nom"),
                    rs.getString("prenom"),
                    rs.getString("specialite"),
                    rs.getString("telephone"),
                    rs.getString("email"),
                    rs.getString("hopital")
                );
                medecins.add(medecin);
            }
        }
        return medecins;
    }
    
    public void deleteMedecin(int id) throws SQLException {
        String sql = "DELETE FROM medecin WHERE id = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}