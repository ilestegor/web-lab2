<%@ page import="com.ilestegor.lab2.model.HitDataCollectionManager" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="collection" type="java.util.LinkedList"--%>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="style/style.css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <title>Web Lab1</title>
</head>
<body>
<main>
    <div class="error-popup">
        <p></p>
        <div class="close-btn-wrapper">
            <button class="close-btn" type="button"></button>
        </div>
    </div>
    <header>
        <p>Glotov E. D. Group: P3232</p>
        <p>Var: 1304</p>
    </header>
    <section>
        <div class="table-wrapper" >
            <p>HISTORY TABLE</p>
            <table id="request-history-table">
                <tr>
                    <th>X</th>
                    <th>Y</th>
                    <th>R</th>
                    <th>Current Time</th>
                    <th>Execution Time</th>
                    <th>Hit Area</th>
                </tr>
                <c:forEach var="col" items="${collection}">
                    <tr class="results">
                        <td>${col.getCoordinates().getX()}</td>
                        <td>${col.getCoordinates().getY()}</td>
                        <td>${col.getCoordinates().getR()}</td>
                        <td>${col.getCurrentTime()}</td>
                        <td>${col.getExecutionTime()}</td>
                        <c:choose>
                            <c:when test="${col.getHitType() == 'Not valid data received'}">
                                <td style="color: red;">${col.getHitType()}</td>
                            </c:when>
                            <c:otherwise>
                                <td>${col.getHitType()}</td>
                            </c:otherwise>
                        </c:choose>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="image-wrapper">
            <div id="calculator"></div>
        </div>
        <div class="input-wrapper">
            <p>INPUT VALUE</p>
            <form id="input-form" method="post" action="${pageContext.request.contextPath}/controller">
                <div class="input-container">
                    <p>X value: </p>
                    <div class="x-input-container">
                        <div class="x-error-container">
                            <label>
                                <span>-5</span>
                                <input type="radio" value="-5" class="x-button" name="x-radio">
                                <span class="custom-x-button"></span>
                            </label>
                            <label>
                                <span>-4</span>
                                <input type="radio" value="-4" class="x-button" name="x-radio">
                                <span class="custom-x-button"></span>
                            </label>
                            <label>
                                <span>-3</span>
                                <input type="radio" value="-3" class="x-button" name="x-radio">
                                <span class="custom-x-button"></span>
                            </label>
                            <label>
                                <span>-2</span>
                                <input type="radio" value="-2" class="x-button" name="x-radio">
                                <span class="custom-x-button"></span>
                            </label>
                            <label>
                                <span>-1</span>
                                <input type="radio" value="-1" class="x-button" name="x-radio">
                                <span class="custom-x-button"></span>
                            </label>

                            <label>
                                <span>0</span>
                                <input type="radio" value="0" class="x-button" name="x-radio">
                                <span class="custom-x-button"></span>
                            </label>
                            <label>
                                <span>1</span>
                                <input type="radio" value="1" class="x-button" name="x-radio">
                                <span class="custom-x-button"></span>
                            </label>
                            <label>
                                <span>2</span>
                                <input type="radio" value="2" class="x-button" name="x-radio">
                                <span class="custom-x-button"></span>
                            </label>
                            <label>
                                <span>3</span>
                                <input type="radio" value="3" class="x-button" name="x-radio">
                                <span class="custom-x-button"></span>
                            </label>
                        </div>
                        <p class="error" id="x-error-field"></p>
                    </div>

                </div>
                <div class="input-container">
                    <label for="y-input">Y value: </label>
                    <div class="error-container">
                        <input type="text" placeholder="Enter values -5...5" id="y-input" name="y" class="text-input input-value">
                        <p class="error" id="y-error-field"></p>
                    </div>
                </div>
                <div class="input-container">
                    <label for="r-input">R value: </label>
                    <div class="error-container">
                        <input type="text" placeholder="Enter values 2...5" id="r-input" class="text-input input-value">
                        <p class="error" id="r-error-field"></p>
                    </div>
                </div>
                <div class="input-container buttons-container">
                    <button class="btn submit-btn" type="submit">
                        Submit
                    </button>
                    <button class="btn reset-btn" type="reset">
                        Reset
                    </button>
                </div>
            </form>
        </div>
    </section>
</main>
<script src="https://www.desmos.com/api/v1.8/calculator.js?apiKey=dcb31709b452b1cf9dc26972add0fda6"></script>
<script src="js/validation.js"></script>
<script src="js/senders.js"></script>
<script src="js/graphs.js"></script>
<script src="js/addToTable.js"></script>
<script src="js/popUp.js"></script>
<script>
    <c:forEach var="col" items="${collection}">
        drawXY(${col.getCoordinates().getX()}, ${col.getCoordinates().getY()});
    </c:forEach>
</script>
</body>
</html>