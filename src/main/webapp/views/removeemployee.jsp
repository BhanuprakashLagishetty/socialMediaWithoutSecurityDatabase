
<%@page language="java" %>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    </body>
        <h2>Alien Details</h2>
             <a href="javascript:history.go(-1)" style="postion:absolute; top:10px; left:30px">Go Back</a>

         <form action="removeemployee">
            <label for="eid">Enter Employee ID to remove :</label>
                <input type="text" id="eid" name="eid"><br>



                <input type="submit" value="Submit">
                <h1 style:"color:red;">${result}<h1>

            </form>

    </body>
</html>