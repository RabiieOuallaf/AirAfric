<%--
  Created by IntelliJ IDEA.
  User: rabieouallaf
  Date: 29‏/10‏/2023
  Time: 17:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">

</head>
<body>


<div class="mx-auto max-w-screen-xl px-4 py-16 sm:px-6 lg:px-8">
    <div class="mx-auto max-w-lg">
        <h1 class="text-center text-2xl font-bold text-indigo-600 sm:text-3xl">
            Reserve a flight now without effort
        </h1>

        <p class="mx-auto mt-4 max-w-md text-center text-gray-500">
            Lorem ipsum dolor sit amet, consectetur adipisicing elit. Obcaecati sunt
            dolores deleniti inventore quaerat mollitia?
        </p>

        <form
                action="/client/login"
                method="post"
                class="mb-0 mt-6 space-y-4 rounded-lg p-4 shadow-lg sm:p-6 lg:p-8"
        >
            <p class="text-center text-lg font-medium">Sign in to your account</p>

            <div>
                <label class="sr-only">Cin</label>

                <div class="relative">
                    <input
                            name="cin"
                            type="text"
                            class="w-full rounded-lg border-gray-200 p-4 pe-12 text-sm shadow-sm"
                            placeholder="Enter CIN"
                    />

                    <span class="absolute inset-y-0 end-0 grid place-content-center px-4">


              </span>
                </div>
            </div>

            <div>
                <label class="sr-only">Password</label>

                <div class="relative">
                    <input
                            name="password"
                            type="password"
                            class="w-full rounded-lg border-gray-200 p-4 pe-12 text-sm shadow-sm"
                            placeholder="Enter password"
                    />

                    <span class="absolute inset-y-0 end-0 grid place-content-center px-4">

              </span>
                </div>
            </div>

            <button
                    type="submit"
                    class="block w-full rounded-lg bg-indigo-600 px-5 py-3 text-sm font-medium text-white"
            >
                Sign in
            </button>

            <p class="text-center text-sm text-gray-500">
                No account?
                <a class="underline" href="/Authentification/ClientRegister.jsp">Sign up</a>
            </p>
        </form>
    </div>
</div>

</body>
</html>
