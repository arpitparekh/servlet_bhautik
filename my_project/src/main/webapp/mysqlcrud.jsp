<!DOCTYPE html>
<%@page import="my_project.Majoor"%>
<%@page import="java.util.ArrayList"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>CRUD Operation</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
        }

        #main {
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            width: 100%;
            max-width: 1000px;
            display: flex;
            overflow: hidden;
        }

        #form-container {
            width: 40%;
            padding: 30px;
            background-color: #f9f9f9;
            border-right: 1px solid #e0e0e0;
        }

        #list-container {
            width: 60%;
            padding: 30px;
            overflow-y: auto;
            max-height: 500px;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            margin-top: 10px;
            color: #333;
            font-weight: bold;
        }

        input {
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ddd;
            border-radius: 4px;
            font-size: 16px;
        }

        button {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 12px 20px;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            transition: background-color 0.3s ease;
            margin-top: 10px;
        }

        button:hover {
            background-color: #45a049;
        }

        ul {
            list-style-type: none;
            padding: 0;
        }

        li {
            background-color: white;
            border: 1px solid #e0e0e0;
            margin-bottom: 15px;
            padding: 15px;
            border-radius: 4px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            box-shadow: 0 2px 4px rgba(0,0,0,0.05);
        }

        .item-details {
            flex-grow: 1;
        }

        .item-actions {
            display: flex;
            gap: 10px;
        }

        .item-actions form {
            margin: 0;
        }

        li button {
            background-color: #2196F3;
            margin: 0;
            padding: 8px 15px;
            font-size: 14px;
            width: auto;
        }

        li button:last-child {
            background-color: #f44336;
        }

        li button:hover:last-child {
            background-color: #d32f2f;
        }

        @media (max-width: 768px) {
            #main {
                flex-direction: column;
            }

            #form-container, #list-container {
                width: 100%;
                border-right: none;
            }
        }
    </style>
</head>
<body>
    <div id="main">
        <div id="form-container">
            <form action="mysql-crud" method="post">
                <% 
                Majoor m = (Majoor)request.getAttribute("obj");
                if(m==null){ 
                %>
                    <h2>Add New Record</h2>
                    <label for="name">Name</label>
                    <input id="name" name="name" placeholder="Enter name" required>
                    
                    <label for="salary">Salary</label>
                    <input id="salary" name="salary" type="number" placeholder="Enter salary" required>
                    
                    <button type="submit">Save Data</button>
                <% } else { %>
                    <h2>Update Record</h2>
                    <input id="id" name="id" value="<%= m.getId() %>" hidden>
                    
                    <label for="name">Name</label>
                    <input id="name" name="name" value="<%= m.getName() %>" required>
                    
                    <label for="salary">Salary</label>
                    <input id="salary" name="salary" type="number" value="<%= m.getSalary() %>" required>
                    
                    <button type="submit">Update Data</button>
                <% } %>
            </form>
        </div>

        <div id="list-container">
            <h2>Existing Records</h2>
            <ul>
                <% 
                ArrayList<Majoor> list = (ArrayList<Majoor>)request.getAttribute("list");
                for(Majoor m1 : list){ 
                %>
                    <li>
                        <div class="item-details">
                            <strong>ID:</strong> <%= m1.getId() %><br>
                            <strong>Name:</strong> <%= m1.getName() %><br>
                            <strong>Salary:</strong> <%= m1.getSalary() %>
                        </div>
                        <div class="item-actions">
                            <form method="post" action="mysql-crud">
                                <input id="updateId" name="updateId" value="<%= m1.getId() %>" hidden>
                                <button type="submit">Update</button>
                            </form>
                            <form method="post" action="mysql-crud">
                                <input id="deleteId" name="deleteId" value="<%= m1.getId() %>" hidden>
                                <button type="submit">Delete</button>
                            </form>
                        </div>
                    </li>
                <% } %>
            </ul>
        </div>
    </div>
</body>
</html>