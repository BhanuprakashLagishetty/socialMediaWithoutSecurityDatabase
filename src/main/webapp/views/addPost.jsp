
<%@page language="java" %>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    </body>
     <a href="javascript:history.go(-1)" style="postion:absolute; top:10px; left:30px">Go Back</a>
        <h2>Alien Details</h2>

         <form action="SavePost" >


                <label for="Tittle">Enter Title of the post:</label>
                                    <input type="text" id="Tittle" name="Tittle" required><br>
                                     <label for="content">Enter the Desctiption </label>
                                     <TextArea type="text" id="content" name="content" required></TextArea><br>
                <input type="submit" value="Submit">


            </form>

    </body>
</html>