<%@ page import="java.util.List" %>
<%@ page import="com.example.SocailMedia.Entity.Post" %>

<!DOCTYPE html>
<html>
<head>
    <title>Employee List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        h1 {
            color: #333;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
            color: #333;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #f2f2f2;
        }
        .btn-edit, .btn-delete {
            padding: 6px 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }
        .btn-delete {
            background-color: #dc3545;
        }
        .btn-edit:hover, .btn-delete:hover {
            background-color: #0056b3;
        }
        .add-btn{
         height: 60px;
          width: 200px; /* Adjust width as needed */
          background-color: #4CAF50; /* Green background color */
          border: none;
          color: white; /* White text color */
          text-align: center;
          text-decoration: none;
          display: inline-block;
          font-size: 16px;
          cursor: pointer;
          border-radius: 5px;
           display:flex;
          text-align:center;
          align-items:center;
          justify-content:center;

        }
        .add-btn:hover{
        }background-color: #45a049;
    </style>
</head>
<body>
<h1>${res}</h1>
<h1>Employee List</h1>
<table>
    <thead>
        <tr>
            <th>Post Id</th>
            <th>Post Title</th>
            <th>View Authoer</th>
            <th>Operations</th>
        </tr>
    </thead>
    <tbody>
    <div style="display:flex;">


                     <a href="/" class="add-btn" style="margin-left:10px">GO to index</a>
                         </div>
        <%
            List<Post>postList  = (List<Post>) request.getAttribute("post");
            if (postList != null) {
                for (Post p : postList) {
        %>
        <tr>
            <td><%= p.getPostId() %></td>
            <td><%= p.getTittle() %></td>
            <td><%= p.getContent() %></td>

            <td>
             <div style="display:flex;">
                <form action="updateProject" style="margin-right:5px;">
                    <input type="hidden" name="projectId" value= <%= p.getPostId() %>>
                    <input type="submit" value="Edit" class="btn-edit">
                </form>
                <form action="removeProject">

                    <input type="hidden" name="projectId" value= <%= p.getPostId() %>>
                    <input type="submit" value="Delete" class="btn-delete">

                </form>
                 </div>
            </td>
        </tr>
        <%
                }
            } else {
        %>
        <tr>
            <td colspan="5">No employees found</td>
        </tr>
        <%
            }
        %>
    </tbody>
</table>
</body>
</html>
