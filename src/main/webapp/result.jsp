<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="collection" type="java.util.LinkedList"--%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="style/result.css">
    <title>Document</title>
</head>
<body>
<main>
    <div class="table-wrapper" >
        <table id="request-history-table">
            <tr>
                <th>X</th>
                <th>Y</th>
                <th>R</th>
                <th>Current Time</th>
                <th>Execution Time</th>
                <th>Hit Area</th>
            </tr>
            <tr class="results">
                <td>${collection.getLast().getCoordinates().getX()}</td>
                <td>${collection.getLast().getCoordinates().getY()}</td>
                <td>${collection.getLast().getCoordinates().getR()}</td>
                <td>${collection.getLast().getCurrentTime()}</td>
                <td>${collection.getLast().getExecutionTime()}</td>
                    <c:choose>
                    <c:when test="${collection.getLast().getHitType() == 'Not valid data received'}">
                        <td style="color: red">${collection.getLast().getHitType()}</td>
                </c:when>
                <c:otherwise>
                    <td>${collection.getLast().getHitType()}</td>
                </c:otherwise>
                </c:choose>

            </tr>
        </table>
    </div>
    <a href="${pageContext.request.contextPath}/" id="return-link">Return to the main page</a>
</main>
</body>
</html>