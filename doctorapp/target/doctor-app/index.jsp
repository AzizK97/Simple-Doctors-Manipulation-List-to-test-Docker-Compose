<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gestion des Médecins</title>
    <style>
        body { font-family: Arial, sans-serif; margin: 40px; }
        .container { max-width: 800px; margin: 0 auto; }
        .menu { margin: 20px 0; }
        .menu a { 
            display: inline-block; 
            margin: 10px; 
            padding: 10px 20px; 
            background: #007bff; 
            color: white; 
            text-decoration: none; 
            border-radius: 5px; 
        }
        .menu a:hover { background: #0056b3; }
    </style>
</head>
<body>
    <div class="container">
        <h1>Application de Gestion des Médecins</h1>
        <div class="menu">
            <a href="add-medecin.jsp">Ajouter un Médecin</a>
            <a href="list-medecins">Liste des Médecins</a>
        </div>
    </div>
</body>
</html>