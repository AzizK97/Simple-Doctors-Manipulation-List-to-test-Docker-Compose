package com.doctor.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MedecinTest {

    @Test
    void testMedecinProperties() {
        Medecin medecin = new Medecin(1, "Doe", "John", "Cardiology", "123456789", "john.doe@hospital.com", "General Hospital");
        assertEquals("John", medecin.getPrenom());
        assertEquals("Doe", medecin.getNom());
        assertEquals("Cardiology", medecin.getSpecialite());
        assertEquals(1, medecin.getId());
    }

    @Test
    void testMedecinMethods() {
        Medecin medecin = new Medecin();
        medecin.setNom("Smith");
        medecin.setPrenom("Jane");
        medecin.setSpecialite("Pediatrics");
        medecin.setId(2);
        
        assertEquals("Jane", medecin.getPrenom());
        assertEquals("Smith", medecin.getNom());
        assertEquals("Pediatrics", medecin.getSpecialite());
        assertEquals(2, medecin.getId());
    }
}