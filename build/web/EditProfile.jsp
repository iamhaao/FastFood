<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.*" %>
<%@include file="/includes/header.jsp" %>
<main>
<link rel="stylesheet" href="./css/styleEditProfile.css"/>
<div class="container-xl px-4 mt-20">  
    <c:set value="${sessionScope.acc}" var="acc" />
    <hr class="mt-0 mb-4">
    <div class="row">
        <div class="col-xl-4  text-center justify-content-center ">
            <!-- Profile picture card-->
            <div class="card mb-4 mb-xl-0">
                <div class="card-header">Profile Picture</div>
                <div class="card-body text-center mx-auto">
                    <!-- Profile picture image-->
                    <img class="img-account-profile rounded-circle mb-2" src="${acc.avatar}" alt="">
                    <!-- Profile picture help block-->
                    <div class="small font-italic text-muted mb-4">JPG or PNG no larger than 5 MB</div>
                    <!-- Profile picture upload button-->
                    <button class="btn btn-primary" type="button">Upload new image</button>
                </div>
            </div>
        </div>
        <div class="col-xl-8">
            <!-- Account details card-->
            <div class="card mb-4">
                <div class="card-header">Account Details</div>
                <div class="card-body">
                    <form action="updateProfile">
                        <!-- Form Group (username)-->
                        <div class="mb-3">
                            <label class="small mb-1" for="inputUsername">Username</label>
                            <input class="form-control" id="inputUsername" type="text" name="user" readonly placeholder="Enter your username" value="${acc.username}">
                        </div>
                        <!-- Form Row-->
                        <div class="row gx-3 mb-3">
                            <!-- Form Group (first name)-->
                            <div class="col-md">
                                <label class="small mb-1" for="inputFirstName">First name</label>
                                <input class="form-control" id="inputFirstName" type="text" placeholder="name" name="name" value="${acc.name}">
                            </div>
                            <!-- Form Group (last name)-->
                         
                        </div>
                        <!-- Form Row        -->
                        <div class="row gx-3 mb-3">
                            <!-- Form Group (organization name)-->
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputOrgName">Password</label>
                                <input class="form-control" id="inputOrgName" name="password" type="password"  placeholder="Enter your organization name" value="${acc.password}">
                            </div>
                            <!-- Form Group (location)-->
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputLocation">Address</label>
                                <input class="form-control" id="inputLocation" name="address" type="text" placeholder="Enter your location" value="${acc.address}">
                            </div>
                        </div>
                        <!-- Form Group (email address)-->
                        <div class="mb-3">
                            <label class="small mb-1" for="inputEmailAddress">Email address</label>
                            <input class="form-control" id="inputEmailAddress" name="email" type="email" placeholder="Enter your email address" value="${acc.email}">
                        </div>
                        <!-- Form Row-->
                        <div class="row gx-3 mb-3">
                            <!-- Form Group (phone number)-->
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputPhone">Phone number</label>
                                <input class="form-control" id="inputPhone" name="phone" type="tel" placeholder="Enter your phone number" value="${acc.phone}">
                            </div>
                            <!-- Form Group (birthday)-->
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputBirthday">Birthday</label>
                                <input class="form-control" id="inputBirthday" type="text" name="birthday" placeholder="Enter your birthday" value="06/10/1988">
                            </div>
                        </div>
                        <!-- Save changes button-->
                        <button class="btn btn-primary" type="submit">Save changes</button>
                         <div class="text-danger mt-4">${requestScope.alert}</div>
                    </form>
                </div>
            </div>
                               
        </div>
    </div>
</div>
</main>
<%@include file="/includes/footer.jsp" %>