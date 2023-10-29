<%--
  Created by IntelliJ IDEA.
  User: rabieouallaf
  Date: 28‏/10‏/2023
  Time: 15:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update airplane</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
<div className="exercice-container bg-gray-900 min-h-screen p-10">
    <section class="max-w-4xl p-6 mx-auto bg-indigo-600 rounded-md shadow-md dark:bg-gray-800 p-10">
        <h1 class="text-xl font-bold text-white capitalize dark:text-white">Account settings</h1>
        <form action="/airplane/update" method="post">
            <div class="grid grid-cols-1 gap-6 mt-4 sm:grid-cols-2">
                <%
                    // Retrieve the values and set them directly as request attributes
                    String airplaneModel = (String) request.getAttribute("model");
                    String airplaneMatricule = (String) request.getAttribute("matricule");

                    request.setAttribute("airplaneModel", airplaneModel);
                    request.setAttribute("airplaneMatricule", airplaneMatricule);
                %>


                <div>
                    <label class="text-white dark:text-gray-200">Airplane model</label>
                    <input
                            name="model"
                            type="text"
                            class="block w-full px-4 py-2 mt-2 text-gray-700 bg-white border border-gray-300 rounded-md dark:bg-gray-800 dark:text-gray-300 dark:border-gray-600 focus:border-blue-500 dark:focus:border-blue-500 focus:outline-none focus:ring"
                            value='<%= request.getAttribute("model")%>'
                    />
                </div>

                <div>
                    <label class="text-white dark:text-gray-200">Airplane matricule</label>
                    <input
                            name="reference"
                            type="hidden"
                            class="block w-full px-4 py-2 mt-2 text-gray-700 bg-white border border-gray-300 rounded-md dark:bg-gray-800 dark:text-gray-300 dark:border-gray-600 focus:border-blue-500 dark:focus:border-blue-500 focus"
                            value='<%= request.getAttribute("matricule")%>'
                            />
                    <input
                            name="matricule"
                            type="text"
                            class="block w-full px-4 py-2 mt-2 text-gray-700 bg-white border border-gray-300 rounded-md dark:bg-gray-800 dark:text-gray-300 dark:border-gray-600 focus:border-blue-500 dark:focus:border-blue-500 focus:outline-none focus:ring"
                            value='<%= request.getAttribute("matricule")%>'


                    />
                </div>

            </div>

            <div class="flex justify-end mt-6">
                <button class="px-6 py-2 leading-5 text-white transition-colors duration-200 transform bg-blue-500 rounded-md hover:bg-blue-700 focus:outline-none focus:bg-gray-600">Save</button>
            </div>
        </form>
    </section>
</div>
</body>
</html>
