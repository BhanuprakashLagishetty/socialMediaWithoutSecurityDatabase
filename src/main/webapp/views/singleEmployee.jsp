<%@page language="java" %>

<html>
    <head>
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    </body>

             <a href="javascript:history.go(-1)" style="postion:absolute; top:10px; left:30px">Go Back</a>



       <!--  using jstl tags -->
       <h1>Wellcome</h1>
       <p>Id of the User     : ${user.getUserId()}</p>
       <p>UserName           : ${user.getUserName()}</p>
       <p>Users FullName     : ${user.getUserProfile().getFullName()}</p>
       <p>Users Email ID     : ${ user.getUserProfile().getEmailId()}</p>



    </body>
</html>