
<%@page language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    </body>
     <a href="javascript:history.go(-1)" style="postion:absolute; top:10px; left:30px">Go Back</a>
        <h2>Alien Details</h2>

         <form:form  action="SaveGroup" modelAttribute="friendModel">


                <label for="fname">Enter Title of the Group:</label>
                <input type="text" id="fname" name="fname"><br>
                <form:errors path="fname" cssClass="error"/><br>
                <input type="submit" value="Submit">

            </form:form>

    </body>
</html>