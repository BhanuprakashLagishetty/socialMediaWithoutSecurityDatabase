
<%@page language="java" %>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    </body>
     <a href="javascript:history.go(-1)" style="postion:absolute; top:10px; left:30px">Go Back</a>
        <h2>Alien Details</h2>

         <form action="GenerateProjectEmplyee" >


                <label for="ename">Enter EmployeeName :</label>
                <input type="text" id="ename" name="ename" required><br>
                 <label for="edesignation">Enter Employee Designation :</label>
                 <input type="text" id="edesignation" name="edesignation" required><br>
                <label for="esalary">Enter Employee Salary :</label>
                <input type="text" id="esalary" name="esalary" required><br>
                <input type="submit" value="Submit">


            </form>

    </body>
</html>