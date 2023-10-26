<%--
  Created by IntelliJ IDEA.
  User: rabieouallaf
  Date: 24‏/10‏/2023
  Time: 09:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin login</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
    <div class="min-h-screen flex items-center justify-center">
        <div class="bg-white p-8 rounded shadow-md w-80">
            <h2 class="text-2xl mb-4">Login</h2>
            <form action="/admin" method="POST">
                <div class="mb-4">
                    <label for="username" class="block font-medium">Username:</label>
                    <input type="text" id="username" name="cin" required
                           class="w-full border rounded py-2 px-3 focus:outline-none focus:border-blue-500">
                </div>
                <div class="mb-4">
                    <label for="password" class="block font-medium">Password:</label>
                    <input type="password" id="password" name="password" required
                           class="w-full border rounded py-2 px-3 focus:outline-none focus:border-blue-500">
                </div>
                <button type="submit" class="w-full bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded">
                    Login
                </button>
            </form>
            <p class="mt-4 text-center">Don't have an account? <a class="text-blue-500">Register</a></p>
        </div>
    </div>
</body>
</html>
