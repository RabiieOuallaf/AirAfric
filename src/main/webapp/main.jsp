<%@ page import="src.main.airportmangement.Entities.Reservations.City" %>
<%@ page import="java.util.List" %>
<%@ page import="src.main.airportmangement.Services.Reservations.CityService" %>
<%@ page import="src.main.airportmangement.Entities.Airplanes.Airplane" %>
<%@ page import="src.main.airportmangement.Services.Airplanes.AirplaneService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book a flight</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">

</head>
<body>
    <div class="flex h-screen w-[350px] bg-gray-100">
        <div class="m-auto">
            <div>
                <button type="button" class="relative w-full flex justify-center items-center px-5 py-2.5 font-medium tracking-wide text-white capitalize   bg-black rounded-md hover:bg-gray-900  focus:outline-none   transition duration-300 transform active:scale-95 ease-in-out">
                    <svg xmlns="http://www.w3.org/2000/svg" enable-background="new 0 0 24 24" height="24px" viewBox="0 0 24 24" width="24px" fill="#FFFFFF">
                        <g>
                            <rect fill="none" height="24" width="24"></rect>
                        </g>
                        <g>
                            <g>
                                <path d=    "M19,13h-6v6h-2v-6H5v-2h6V5h2v6h6V13z"></path>
                            </g>
                        </g>
                    </svg>
                    <span class="pl-2 mx-1">Book a flight below</span>
                </button>
                <div class="mt-5 bg-white rounded-lg shadow">
                    <form action="/main" method="POST">
                        <div class="flex">
                            <div class="flex-1 py-5 pl-5 overflow-hidden">
                                <svg class="inline align-text-top" height="24px" viewBox="0 0 24 24" width="24px" xmlns="http://www.w3.org/2000/svg" fill="#000000">
                                    <g>
                                        <path d="m4.88889,2.07407l14.22222,0l0,20l-14.22222,0l0,-20z" fill="none" id="svg_1" stroke="null"></path>
                                        <path d="m7.07935,0.05664c-3.87,0 -7,3.13 -7,7c0,5.25 7,13 7,13s7,-7.75 7,-13c0,-3.87 -3.13,-7 -7,-7zm-5,7c0,-2.76 2.24,-5 5,-5s5,2.24 5,5c0,2.88 -2.88,7.19 -5,9.88c-2.08,-2.67 -5,-7.03 -5,-9.88z" id="svg_2"></path>
                                        <circle cx="7.04807" cy="6.97256" r="2.5" id="svg_3"></circle>
                                    </g>
                                </svg>
                                <h1 class="inline text-2xl font-semibold leading-none">Depature city</h1>
                            </div>
                        </div>
                        <div class="px-5 pb-5">
                            <select class=" text-black placeholder-gray-600 w-full px-4 py-2.5 mt-2 text-base   transition duration-500 ease-in-out transform border-transparent rounded-lg bg-gray-200  focus:border-blueGray-500 focus:bg-white dark:focus:bg-gray-800 focus:outline-none focus:shadow-outline focus:ring-2 ring-offset-current ring-offset-2 ring-gray-400" name="depature">
                                <%
                                    CityService cityService = new CityService();
                                    List<City> cities = cityService.readAll();

                                    if (cities != null) {
                                        List<City> first10Cities = cities.subList(0, Math.min(10, cities.size()));
                                        for (City city : first10Cities) {
                                %>
                                <option value='<%= city.getName()%>'><%= city.getName() %> - <%= city.getCountry() %></option>
                                <%
                                        }
                                    }
                                %>
                            </select>

                            <select class=" text-black placeholder-gray-600 w-full px-4 py-2.5 mt-2 text-base   transition duration-500 ease-in-out transform border-transparent rounded-lg bg-gray-200  focus:border-blueGray-500 focus:bg-white dark:focus:bg-gray-800 focus:outline-none focus:shadow-outline focus:ring-2 ring-offset-current ring-offset-2 ring-gray-400" name="airplane">
                                <%
                                    AirplaneService airplaneService = new AirplaneService();
                                    List<Airplane> airplanes = airplaneService.readAll();

                                    if (airplanes != null) {
                                        for (Airplane airplane: airplanes) {
                                %>
                                <option value='<%= airplane.getModel()%>'><%= airplane.getModel() %></option>
                                <%
                                        }
                                    }
                                %>
                            </select>
                            <div class="w-64 mt-4">
                                <label class="block text-sm font-medium text-gray-700">Select a Date</label>
                                <div class="mt-1">
                                    <input name="departureDate" type="date"
                                           class="appearance-none block w-full px-3 py-2 border rounded-md shadow-sm
                                          focus:outline-none focus:ring-indigo-500 focus:border-indigo-500
                                          sm:text-sm text-gray-700">
                                </div>
                            </div>

                            <div class="flex">
                                <div class="flex-grow w-1/4 pr-2">
                                    <input  placeholder="CIN"
                                            class=" text-black placeholder-gray-600 w-full px-4 py-2.5 mt-2 text-base   transition duration-500 ease-in-out transform border-transparent rounded-lg bg-gray-200  focus:border-blueGray-500 focus:bg-white dark:focus:bg-gray-800 focus:outline-none focus:shadow-outline focus:ring-2 ring-offset-current ring-offset-2 ring-gray-400"
                                            type="text"
                                            name="cin"
                                    >
                                </div>
                                <div class="flex-grow">
                                    <input placeholder="Weights"
                                           type="number"
                                           class=" text-black placeholder-gray-600 w-full px-4 py-2.5 mt-2 text-base   transition duration-500 ease-in-out transform border-transparent rounded-lg bg-gray-200  focus:border-blueGray-500 focus:bg-white dark:focus:bg-gray-800 focus:outline-none focus:shadow-outline focus:ring-2 ring-offset-current ring-offset-2 ring-gray-400"
                                           name="Weight"
                                    >
                                </div>
                            </div>
                            <div class="flex items-center pt-3"><input type="checkbox" class="w-4 h-4 text-black bg-gray-300 border-none rounded-md focus:ring-transparent"><label class="block ml-2 text-sm text-gray-900">Aller/Retour</label></div>
                        </div>
                        <div class="flex">
                            <div class="flex-1 py-5 pl-5 overflow-hidden">
                                <svg class="inline align-text-top" width="21" height="20.5" xmlns="http://www.w3.org/2000/svg" fill="#000000">
                                    <g>
                                        <path d="m4.88889,2.07407l14.22222,0l0,20l-14.22222,0l0,-20z" fill="none" id="svg_1" stroke="null"></path>
                                        <path d="m7.07935,0.05664c-3.87,0 -7,3.13 -7,7c0,5.25 7,13 7,13s7,-7.75 7,-13c0,-3.87 -3.13,-7 -7,-7zm-5,7c0,-2.76 2.24,-5 5,-5s5,2.24 5,5c0,2.88 -2.88,7.19 -5,9.88c-2.08,-2.67 -5,-7.03 -5,-9.88z" id="svg_2"></path>
                                        <circle cx="7.04807" cy="6.97256" r="2.5" id="svg_3"></circle>
                                    </g>
                                </svg>
                                <h1 class="inline text-2xl font-semibold leading-none">Arrival city</h1>
                            </div>
                            <div class="flex-none pt-2.5 pr-2.5 pl-1"></div>
                        </div>
                        <div class="px-5 pb-5">

                            <select class=" text-black placeholder-gray-600 w-full px-4 py-2.5 mt-2 text-base   transition duration-500 ease-in-out transform border-transparent rounded-lg bg-gray-200  focus:border-blueGray-500 focus:bg-white dark:focus:bg-gray-800 focus:outline-none focus:shadow-outline focus:ring-2 ring-offset-current ring-offset-2 ring-gray-400" name="arrival">
                                <%

                                    if (cities != null) {
                                        List<City> last10Cities = cities.subList(cities.size() - 10, cities.size());
                                        for (City city : last10Cities) {
                                %>
                                <option value='<%= city.getName()%>'><%= city.getName() %> - <%= city.getCountry() %></option>
                                <%
                                        }
                                    }
                                %>
                            </select>



                            <div class="w-64 mt-4">
                                <label class="block text-sm font-medium text-gray-700">Select a Date</label>
                                <div class="mt-1">
                                    <input name="ArrivalDate" type="date"
                                           class="appearance-none block w-full px-3 py-2 border rounded-md shadow-sm
                                          focus:outline-none focus:ring-indigo-500 focus:border-indigo-500
                                          sm:text-sm text-gray-700">
                                </div>
                            </div>

                        </div>
                        <hr class="mt-4">
                        <div class="flex flex-row-reverse p-3">
                            <div class="flex-initial pl-3">
                                <button type="button" class="flex items-center px-5 py-2.5 font-medium tracking-wide text-white capitalize   bg-black rounded-md hover:bg-gray-800  focus:outline-none focus:bg-gray-900  transition duration-300 transform active:scale-95 ease-in-out">
                                    <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 0 24 24" width="24px" fill="#FFFFFF">
                                        <path d="M0 0h24v24H0V0z" fill="none"></path>
                                        <path d="M5 5v14h14V7.83L16.17 5H5zm7 13c-1.66 0-3-1.34-3-3s1.34-3 3-3 3 1.34 3 3-1.34 3-3 3zm3-8H6V6h9v4z" opacity=".3"></path>
                                        <path d="M17 3H5c-1.11 0-2 .9-2 2v14c0 1.1.89 2 2 2h14c1.1 0 2-.9 2-2V7l-4-4zm2 16H5V5h11.17L19 7.83V19zm-7-7c-1.66 0-3 1.34-3 3s1.34 3 3 3 3-1.34 3-3-1.34-3-3-3zM6 6h9v4H6z"></path>
                                    </svg>
                                    <input value="Reserve" type="submit" class="pl-2 mx-1"/>
                                </button>
                            </div>
                            <div class="flex-initial">
                                <button type="button" class="flex items-center px-5 py-2.5 font-medium tracking-wide text-black capitalize rounded-md  hover:bg-red-200 hover:fill-current hover:text-red-600  focus:outline-none  transition duration-300 transform active:scale-95 ease-in-out">
                                    <svg xmlns="http://www.w3.org/2000/svg" height="24px" viewBox="0 0 24 24" width="24px">
                                        <path d="M0 0h24v24H0V0z" fill="none"></path>
                                        <path d="M8 9h8v10H8z" opacity=".3"></path>
                                        <path d="M15.5 4l-1-1h-5l-1 1H5v2h14V4zM6 19c0 1.1.9 2 2 2h8c1.1 0 2-.9 2-2V7H6v12zM8 9h8v10H8V9z"></path>
                                    </svg>
                                    <span class="pl-2 mx-1">Delete</span>
                                </button>
                            </div>
                        </div>
                    </form>
                </div>

            </div>
        </div>
    </div>
</body>

</html>
