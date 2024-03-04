
<%@page language="java" %>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    </body>
         <a href="javascript:history.go(-1)" style="postion:absolute; top:10px; left:30px">Go Back</a>

        <h2>Alien Details</h2>

         <form action="SuccesfullProjectUpdate">

                <label for="projectId">Enter ProjectID :</label>
                <input type="text" id="projectId" name="projectId" readonly="true" value=${singleEmployee.getProjectId()} ><br>




                                <label for="projectName" }>Enter ProjectName :</label>
                                <input type="text" id="projectName" name="projectName" value=${singleEmployee.getProjectName()}><br>
                                 <label for="submitionDate" >Enter Project Submission :</label>
                                 <input type="text" id="submitionDate" name="submitionDate" value=${singleEmployee.getSubmitionDate()}><br>



                <input type="submit" value="Submit">

            </form>

    </body>
</html>