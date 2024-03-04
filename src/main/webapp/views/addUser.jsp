<%@page language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<a href="javascript:history.go(-1)" style="position:absolute; top:10px; left:30px">Go Back</a>
<h2>Alien Details</h2>

<form:form action="SaveUser" modelAttribute="userModel">

    <label for="userName">Enter Username:</label>
    <input type="text" id="userName" name="userName">
    <p style="color:red;font-size:14px;">
    <form:errors path="userName" cssClass="error"/><br>
    </p>
        <label for="Password">Enter Password:</label>
        <input type="text" id="Password" name="password"><br>
        <p style="color:red;font-size:14px;">
        <form:errors path="password" cssClass="error"/><br>
        </p>

        <label for="fullName">Enter Full Name:</label>
          <input type="text" id="fullName" name="userProfileModel.fullName" ><br>
          <p style="color:red;font-size:14px;">
          <form:errors path="userProfileModel.fullName" cssClass="error"/><br>
          </p>
        <label for="EmailId">Enter EmailId:</label>
        <input type="text" id="EmailId" name="userProfileModel.EmailId" ><br>
        <p style="color:red;font-size:14px;">
         <form:errors path="userProfileModel.EmailId" cssClass="error"/><br>
         </p>

    <input type="submit" value="Submit">
</form:form>

</body>
</html>
