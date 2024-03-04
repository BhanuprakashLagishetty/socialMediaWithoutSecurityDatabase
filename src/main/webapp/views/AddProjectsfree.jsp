
<%@page language="java" %>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    </body>
     <a href="javascript:history.go(-1)" style="postion:absolute; top:10px; left:30px">Go Back</a>
        <h2>Alien Details</h2>

         <form action="SaveProjectsfree" >


                <label for="projectname">Enter Employee Project Name :</label>
                                    <input type="text" id="projectname" name="ProjectName" required><br>
                                     <label for="submitionDate">Enter the Submition Date:</label>
                                     <input type="text" id="submitionDate" name="submitionDate" required><br>
                <input type="submit" value="Submit">


            </form>

    </body>
</html>