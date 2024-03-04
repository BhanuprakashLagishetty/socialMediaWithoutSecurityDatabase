<%@ page import="java.util.Set" %>
<%@ page import="com.example.SocailMedia.Models.UserModel" %>

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
        .add-btn {
            height: 60px;
            width: 200px;
            background-color: #4CAF50;
            border: none;
            color: white;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            cursor: pointer;
            border-radius: 5px;
            display: flex;
            text-align: center;
            align-items: center;
            justify-content: center;
        }
        .add-btn:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<h1>${res}</h1>
<h1>Employee List</h1>
<table>
    <thead>
        <tr>
            <th>ID</th>
            <th>UserName</th>
            <th>Profile</th>
            <th>View Posts</th>

            <th>Operations</th>
        </tr>
    </thead>
    <tbody>
    <div style="display:flex;">
        <a href="addMember" class="add-btn">Add User</a>
        <a href="/" class="add-btn" style="margin-left:10px">GO to index</a>
    </div>
    <%
       Set<UserModel> UserList = (Set<UserModel>) request.getAttribute("members");
       if (UserList != null) {
           for (UserModel user : UserList) {
    %>
        <tr>
            <td><%= user.getUserId() %></td>
            <td><%= user.getUserName() %></td>
            <td>
                <form action="SearchEmployee" style="margin-right:5px;">
                    <input type="hidden" name="eid" value="<%= user.getUserId() %>">
                    <input type="submit" value="viewFullProfile" class="btn-edit">
                </form>
            </td>
            <td>
                <a href="ViewPosts?userId=<%= user.getUserId() %>" class="btn-edit">View Posts</a>
            </td>

            <td>
                <div style="display:flex;">
                    <form action="updateEmployee" style="margin-right:5px;">
                        <input type="hidden" name="eid" value="<%= user.getUserId() %>">
                        <input type="submit" value="Edit" class="btn-edit">
                    </form>
                    <form action="removeMember">
                        <input type="hidden" name="eid" value="<%= user.getUserId() %>">
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
            <td colspan="6">No employees found</td>
        </tr>
    <% } %>
    </tbody>
</table>
</body>
</html>
