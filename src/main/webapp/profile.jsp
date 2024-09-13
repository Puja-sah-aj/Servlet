<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Profile Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .navbar {
            background-color: #333;
            overflow: hidden;
        }
        .navbar a {
            float: right;
            display: block;
            color: white;
            text-align: center;
            padding: 14px 20px;
            text-decoration: none;
        }
        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }
        .navbar .welcome {
            float: left;
            color: white;
            padding: 14px 20px;
        }
        .content {
            margin-top: 20px;
            padding: 20px;
            text-align: center;
        }
    </style>
</head>
<body>

    <!-- Navbar -->
    <div class="navbar">
        <div class="welcome">Welcome User</div>
        <a href="logout">Logout</a>
        <a href="/about-us">About Us</a>
        <a href="/home">Home</a>
    </div>

    <!-- Content Section -->
    <div class="content">
        <h1>
            Hello 
            <%= request.getAttribute("name") != null ? request.getAttribute("name") : "Guest" %>
        </h1>
    </div>

</body>
</html>
