<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Sign Up</title>
</head>
<body>
<!-- contact -->
      <div class="contact">
         <div class="container">
            <div class="row ">
               <div class="col-md-12">
                  <div class="titlepage text_align_left">
                     <h2>LogIn</h2>
                    <%
		String error = (String) request.getAttribute("error");
		%>
		<%
		if (error != null) {
		%>
		<h4
			class="section-title position-relative text-uppercase mx-xl-5 mb-4">
			<span class="bg-secondary pr-3">
				<%
				out.print(error);
				%>
			</span>
		</h4>
		<%
		}
		%>
                  </div>
               </div>
               <div class="col-md-6" >
                  <form id="request" class="main_form" action="UserController" method="post">
                     <div class="row">
                        <div class="col-md-12">
                           <label for="email">Email*</label>
                           <input class="contactus" placeholder="Email*" type="email" id="email" name="email" required>                          
                        </div>
                        <div class="col-md-12">
                           <label for="password">Password*</label>
                           <input class="contactus" placeholder="Password*" type="password" id="password" name="password" required>                          
                        </div>
                        <div class="col-md-12">
                           <button class="send_btn" type="submit" name="action" value="login">Login</button>
                        </div>
                     </div>
                  </form>
                  <br>
						<div><a href="forgot-password.jsp">Forgot Password?</a></div>
               </div>
            </div>
         </div>
      </div>
</body>
</html>
