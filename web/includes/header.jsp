<%-- 
    Document   : header
    Created on : Feb 17, 2023, 11:16:17 AM
    Author     : ACER NITRO
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<!DOCTYPE html>
<html>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="https://cdn.tailwindcss.com?plugins=forms,typography,aspect-ratio,line-clamp"></script>
    <script src="https://cdn.tailwindcss.com?plugins=forms,typography,aspect-ratio,line-clamp"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0-10/css/all.min.css" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<!--    <script src="https://messenger.svc.chative.io/static/v1.0/channels/s4ccff02f-2ef2-4cd9-bfe9-3441597ea474/messenger.js?mode=livechat" defer="defer"></script>-->
    <script>
        tailwind.config = {
            theme: {
                extend: {
                    colors: {
                        clifford: '#da373d',
                    }
                }
            }
        }
    </script>
    <style type="text/tailwindcss">
        @layer utilities {
            .content-auto {
                content-visibility: auto;
            }
        }
    </style>
    <body>
        <div class="container">
            <div class="content-wrapper font-karla max-w-screen-2xl text-base mx-auto px-8 bg-white text-black">
                <header class="my-6 px-10">
                    <nav class="flex flex-row justify-between items-center">
                        <div class="logo basis-2/6 text-center text-xl font-semibold cursor-pointer ">
                            FASTBITEs.
                        </div>
                        <ul
                            class="basis-3/6 hidden lg:flex items-center justify-end gap-8 uppercase text-sm text-gray-500 font-medium">
                            <li
                                class="cursor-pointer py-1 hover:text-gray-800 relative after:absolute after:bottom-0 after:left-0 after:bg-slate-900
                                after:h-0.5 after:w-0 hover:after:w-full after:transition-all after:ease-out after:duration-300">
                                <a href="index.jsp" class="">Home</a>
                            </li>
                            <li
                                class="cursor-pointer py-1 hover:text-gray-800 relative after:absolute after:bottom-0 after:left-0 after:bg-slate-900
                                after:h-0.5 after:w-0 hover:after:w-full after:transition-all after:ease-out after:duration-300">
                                <a href="products?nameSearch&choose=0" class="">OurProduct</a>
                            </li>
                            <li
                                class="cursor-pointer py-1 hover:text-gray-800 relative after:absolute after:bottom-0 after:left-0 after:bg-slate-900
                                after:h-0.5 after:w-0 hover:after:w-full after:transition-all after:ease-out after:duration-300">
                                <a href="https://mcdonalds.vn/tin-tuc.html" class="">Blog</a>
                            </li>
                            <li
                                class="cursor-pointer py-1 hover:text-gray-800 relative after:absolute after:bottom-0 after:left-0 after:bg-slate-900
                                after:h-0.5 after:w-0 hover:after:w-full after:transition-all after:ease-out after:duration-300">
                                <a href="https://vi.wikipedia.org/wiki/Louis_Vuitton" class="">About</a>
                            </li>
                            <li
                                class="cursor-pointer py-1 hover:text-gray-800 relative after:absolute after:bottom-0 after:left-0 after:bg-slate-900
                                after:h-0.5 after:w-0 hover:after:w-full after:transition-all after:ease-out after:duration-300">
                                <a href="Login.jsp" class="">Login</a>
                            </li>
                            <li
                                class="cursor-pointer py-1 hover:text-gray-800 relative after:absolute after:bottom-0 after:left-0 after:bg-slate-900
                                after:h-0.5 after:w-0 hover:after:w-full after:transition-all after:ease-out after:duration-300">
                                <a href="https://mcdonalds.vn/" class="">FASTBITEs</a>
                            </li>
                            <c:set var="acc" value="${sessionScope.acc}" />
                            <li class="cursor-pointer py-1 hover:text-gray-800 relative after:absolute after:bottom-0 after:left-0 after:bg-slate-900
                                after:h-0.5 after:w-0 hover:after:w-full after:transition-all after:ease-out after:duration-300 group">
                                <c:if test="acc==null"><a href="Login.jsp">Login</a></c:if> 
                                <c:if test="acc!=null">${sessionScope.acc.username}</c:if>
                                ${sessionScope.acc.username}
                                <div  class="absolute hidden group-hover:block group-hover:visible top-full min-w-full w-max bg-white shadow-md rounded">
                                    <ul class="text-left border rounded">
                                        <li class="px-4 py-1 hover:bg-gray-500 border-b "> <a href="EditProfile.jsp">VIEW PROFILE</a> </li>
                                        <c:if test="${sessionScope.user.idRole==1}"><li class="px-4 py-1 hover:bg-gray-500 border-b "> <a href="ManageBillServlet">Sale Manage</a>  </li> </c:if>
                                        <c:if test="${sessionScope.user.idRole==2}"><li class="px-4 py-1 hover:bg-gray-500 border-b "><a href="BuyHistory?id=${sessionScope.acc.username}">BUY HISTORY</a> </li> </c:if> 
                                          <c:if test="${sessionScope.user.idRole==1}"><li class="px-4 py-1 hover:bg-gray-500 border-b "> <a href="NewProduct.jsp">Add new Product</a>  </li> </c:if>
                                        <li class="px-4 py-1 hover:bg-gray-500 border-b "> <a href="logout?id=${sessionScope.acc.idAccount}">LOG OUT</a></li>
                                    </ul>
                                </div>
                            </li>
                        </ul>
                        <ul
                            class="basis-1/6 flex justify-start items-center ml-16 uppercase text-sm text-gray-500 font-medium">
                            <li class="">
                                <a href="cart" class=" flex items-center ">

                                    <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
                                         strokeWidth={1.5} stroke="currentColor" class="w-6 h-6 inline-block">
                                    <path strokeLinecap="round" strokeLinejoin="round"
                                          d="M15.75 10.5V6a3.75 3.75 0 10-7.5 0v4.5m11.356-1.993l1.263 12c.07.665-.45 1.243-1.119 1.243H4.25a1.125 1.125 0 01-1.12-1.243l1.264-12A1.125 1.125 0 015.513 7.5h12.974c.576 0 1.059.435 1.119 1.007zM8.625 10.5a.375.375 0 11-.75 0 .375.375 0 01.75 0zm7.5 0a.375.375 0 11-.75 0 .375.375 0 01.75 0z" />
                                    </svg>
                                    <span class="mx-2">Cart</span>
                                   <span class="text-sx text-center rounded-full px-1.5 bg-orange-500 text-white">${sessionScope.size}</span>
                                </a>
                            </li>
                        </ul>
                    </nav>
                </header>
