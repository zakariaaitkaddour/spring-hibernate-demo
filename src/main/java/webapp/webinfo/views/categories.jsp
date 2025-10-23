<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des catégories</title>
</head>
<body>
<h2>Liste des catégories</h2>

<ul>
    <c:forEach var="cat" items="${categories}">
        <li>${cat.name}</li>
    </c:forEach>
</ul>

<h3>Ajouter une catégorie</h3>
<form action="categories/add" method="post">
    <input type="text" name="name" placeholder="Nom de la catégorie" required>
    <button type="submit">Ajouter</button>
</form>
</body>
</html>
