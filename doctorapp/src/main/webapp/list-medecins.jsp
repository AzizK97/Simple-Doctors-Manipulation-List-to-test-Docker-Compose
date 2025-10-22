<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Liste des Médecins</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        .container { max-width: 1000px; margin: 0 auto; }
        table { width: 100%; border-collapse: collapse; margin: 20px 0; }
        th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }
        th { background-color: #f8f9fa; }
        .delete-btn { 
            background: #dc3545; 
            color: white; 
            border: none; 
            padding: 5px 10px; 
            border-radius: 3px; 
            cursor: pointer; 
        }
        .delete-btn:hover { background: #c82333; }
        .back-link { display: block; margin-top: 20px; }
    </style>
</head>
<body>
    <div class="container">
        <h1>Liste des Médecins</h1>
        
        <c:if test="${empty medecins}">
            <p>Aucun médecin enregistré.</p>
        </c:if>
        
        <c:if test="${not empty medecins}">
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nom</th>
                        <th>Prénom</th>
                        <th>Spécialité</th>
                        <th>Téléphone</th>
                        <th>Email</th>
                        <th>Hôpital</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="medecin" items="${medecins}">
                        <tr>
                            <td>${medecin.id}</td>
                            <td>${medecin.nom}</td>
                            <td>${medecin.prenom}</td>
                            <td>${medecin.specialite}</td>
                            <td>${medecin.telephone}</td>
                            <td>${medecin.email}</td>
                            <td>${medecin.hopital}</td>
                            <td>
                                <form action="delete-medecin" method="get" style="display: inline;">
                                    <input type="hidden" name="id" value="${medecin.id}">
                                    <button type="submit" class="delete-btn" 
                                            onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce médecin?')">
                                        Supprimer
                                    </button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
        
        <a href="index.jsp" class="back-link">← Retour à l'accueil</a>
        <a href="add-medecin.jsp" class="back-link">➕ Ajouter un nouveau médecin</a>
    </div>
</body>
</html>