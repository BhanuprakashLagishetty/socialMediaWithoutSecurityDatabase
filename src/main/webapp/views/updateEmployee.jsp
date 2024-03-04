
<%@page language="java" %>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    </body>
         <a href="javascript:history.go(-1)" style="postion:absolute; top:10px; left:30px">Go Back</a>

        <h2>Alien Details</h2>

         <form action="SuccesfullUpdate">

                <label for="eid">Enter Employee ID :</label>
                <input type="text" id="eid" name="eid" readonly="true" value=${singleEmployee.getEid()} ><br>
                <label for="ename" }>Enter EmployeeName :</label>
                                <input type="text" id="ename" name="ename" value=${singleEmployee.getEname()}><br>
                                 <label for="edesignation" >Enter Employee Designation :</label>
                                 <input type="text" id="edesignation" name="edesignation" value=${singleEmployee.getEdesignation()}><br>
                                <label for="esalary">Enter Employee Salary :</label>
                                <input type="text" id="esalary" name="esalary" value=${singleEmployee.getEsalary()}><br>

                //



                <input type="submit" value="Submit">

            </form>

    </body>
</html>