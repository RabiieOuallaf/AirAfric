<%@ page import="src.main.airportmangement.Entities.Airplanes.Airplane" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: rabieouallaf
  Date: 26‏/10‏/2023
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<div class="bg-gray-900 min-h-screen flex items-center justify-center">
    <div class="bg-gray-800 flex-1 flex flex-col space-y-5 lg:space-y-0 lg:flex-row lg:space-x-10 max-w-6xl sm:p-6 sm:my-2 sm:mx-4 sm:rounded-2xl">
        <!-- Navigation -->
        <div class="bg-gray-900 px-2 lg:px-4 py-2 lg:py-10 sm:rounded-xl flex lg:flex-col justify-between">
            <nav class="flex items-center flex-row space-x-2 lg:space-x-0 lg:flex-col lg:space-y-2">
                <a class="text-white p-4 inline-flex justify-center rounded-md hover:bg-gray-800 hover:text-white smooth-hover"
                   href="#">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5 sm:h-6 sm:w-6" viewBox="0 0 20 20" fill="currentColor">
                        <path d="M10.707 2.293a1 1 0 00-1.414 0l-7 7a1 1 0 001.414 1.414L4 10.414V17a1 1 0 001 1h2a1 1 0 001-1v-2a1 1 0 011-1h2a1 1 0 011 1v2a1 1 0 001 1h2a1 1 0 001-1v-6.586l.293.293a1 1 0 001.414-1.414l-7-7z" />
                    </svg>
                </a>
            </nav>
            <div class="flex items-center flex-row space-x-2 lg:space-x-0 lg:flex-col lg:space-y-2">
                <a class="text-white p-4 inline-flex justify-center rounded-md hover:bg-gray-800 hover:text-white smooth-hover" href="#">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5 sm:h-6 sm:w-6" viewBox="0 0 20 20" fill="currentColor">
                        <path fill-rule="evenodd" d="M11.49 3.17c-.38-1.56-2.6-1.56-2.98 0a1.532 1.532 0 01-2.286.948c-1.372-.836-2.942.734-2.106 2.106.54.886.061 2.042-.947 2.287-1.561.379-1.561 2.6 0 2.978a1.532 1.532 0 01.947 2.287c-.836 1.372.734 2.942 2.106 2.106a1.532 1.532 0 012.287.947c.379 1.561 2.6 1.561 2.978 0a1.533 1.533 0 012.287-.947c1.372.836 2.942-.734 2.106-2.106a1.533 1.533 0 01.947-2.287c1.561-.379 1.561-2.6 0-2.978a1.532 1.532 0 01-.947-2.287c.836-1.372-.734-2.942-2.106-2.106a1.532 1.532 0 01-2.287-.947zM10 13a3 3 0 100-6 3 3 0 000 6z" clip-rule="evenodd" />
                    </svg>
                </a>
                <a class="text-white p-4 inline-flex justify-center rounded-md hover:bg-gray-800 hover:text-white smooth-hover" href="#">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5 sm:h-6 sm:w-6" viewBox="0 0 20 20" fill="currentColor">
                        <path fill-rule="evenodd" d="M3 3a1 1 0 011 1v12a1 1 0 11-2 0V4a1 1 0 011-1zm7.707 3.293a1 1 0 010 1.414L9.414 9H17a1 1 0 110 2H9.414l1.293 1.293a1 1 0 01-1.414 1.414l-3-3a1 1 0 010-1.414l3-3a1 1 0 011.414 0z" clip-rule="evenodd" />
                    </svg>
                </a>
            </div>
        </div>
        <!-- Content -->
        <div class="flex-1 px-2 sm:px-0">
            <div class="flex justify-between items-center">
                <h3 class="text-3xl font-extralight text-white">Airplanes</h3>
                <div class="inline-flex items-center space-x-2">
                    <a class="bg-gray-900 text-white p-2 rounded-md hover:text-white smooth-hover" href="#">
                        <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6a2 2 0 012-2h2a2 2 0 012 2v2a2 2 0 01-2 2H6a2 2 0 01-2-2V6zM14 6a2 2 0 012-2h2a2 2 0 012 2v2a2 2 0 01-2 2h-2a2 2 0 01-2-2V6zM4 16a2 2 0 012-2h2a2 2 0 012 2v2a2 2 0 01-2 2H6a2 2 0 01-2-2v-2zM14 16a2 2 0 012-2h2a2 2 0 012 2v2a2 2 0 01-2 2h-2a2 2 0 01-2-2v-2z" />
                        </svg>
                    </a>
                    <a class="bg-gray-900 text-white p-2 rounded-md hover:text-white smooth-hover" href="#">
                        <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 10h16M4 14h16M4 18h16" />
                        </svg>
                    </a>
                </div>
            </div>
            <div class="mb-10 sm:mb-0 mt-10 grid gap-4 grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4">
                <div class="group bg-gray-900/30 py-20 px-4 flex flex-col space-y-2 items-center cursor-pointer rounded-md hover:bg-gray-900/40 hover:smooth-hover">
                    <a class="bg-gray-900/70 text-white group-hover:text-white group-hover:smooth-hover flex w-20 h-20 rounded-full items-center justify-center" href="#">
                        <svg xmlns="http://www.w3.org/2000/svg" class="h-10 w-10" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                            <path stroke-linecap="round" stroke-linejoin="round" stroke-width="1" d="M12 6v6m0 0v6m0-6h6m-6 0H6" />
                        </svg>
                    </a>
                    <a class="text-white group-hover:text-white group-hover:smooth-hover text-center" href="/airplane/create" target="_blank">Create airplane</a>
                </div>
                <%
                    List<Airplane> airplaneList = (List<Airplane>) request.getAttribute("airplanes");

                    if (airplaneList != null) {
                        for (Airplane airplane : airplaneList) {
                %>
                <div class="relative group bg-gray-900 py-10 sm:py-20 px-4 flex flex-col space-y-2 items-center cursor-pointer rounded-md hover:bg-gray-900/80 hover:smooth-hover"
                     onmouseover="showButtons(this)"
                     onmouseout="hideButtons(this)">
                    <img class="w-20 h-20 object-cover object-center rounded-full" src="https://www.flightdeckfriend.com/wp-content/uploads/2021/01/Is-turbulence-dangerous-for-a-passenger-jet.jpeg" alt="cuisine" />
                    <h4 class="text-white text-2xl font-bold capitalize text-center"><%= airplane.getModel() %></h4>
                    <p class="text-white"><%= airplane.getCapacity() %> seats</p>

                    <!-- Hidden buttons -->
                    <div class="buttons hidden absolute top-0 right-0 mt-4 mr-4">
                        <button class="bg-red-500 hover:bg-red-600 text-white font-bold py-2 px-4 rounded" onclick="deleteAirplane('<%= airplane.getMatricule() %>')">Delete</button>
                        <button class="bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded" onclick="updateAirplane('<%= airplane.getMatricule() %>')">Update</button>
                    </div>
                </div>
                <%

                    }
                } else {
                %>
                <p>No airplanes found.</p>
                <%
                    }
                %>

            </div>
        </div>
    </div>
</div>
</html>
<script>
    const showButtons = (element) => {
        element.querySelector('.buttons').classList.remove('hidden');
    }

    const hideButtons = (element) => {
        element.querySelector('.buttons').classList.add('hidden');
    }

    const updateAirplane = (matricule) => {
        console.log(matricule);
        window.location.href = '/airplane/update/'+matricule;
    }

    const deleteAirplane = (matricule) => {
        var xhr = new XMLHttpRequest();
        xhr.open('DELETE', '/airplane/delete/' + matricule, true);
        xhr.onreadystatechange = function() {
            if (xhr.readyState == 4 && xhr.status == 200) {
                // Handle the response from the server
                console.log(xhr.responseText);
            }
        };
        xhr.send();
    }
</script>
