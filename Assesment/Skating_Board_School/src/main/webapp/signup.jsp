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
                     <h2>Sign Up</h2>
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
                        <div class="col-md-6">
                           <label for="first_name">First Name*</label>
                           <input class="contactus" placeholder="First Name*" type="text" id="first_name" name="first_name" required> 
                        </div>
                        <div class="col-md-6">
                           <label for="last_name">Last Name*</label>
                           <input class="contactus" placeholder="Last Name*" type="text" id="last_name" name="last_name" required>                          
                        </div>
                        <div class="col-md-12">
                           <label for="email">Email*</label>
                           <input class="contactus" placeholder="Email*" type="email" id="email" name="email" required>                          
                        </div>
                        <div class="col-md-12">
                           <label for="mobile">Mobile*</label>
                           <input class="contactus" placeholder="Mobile*" type="text" id="mobile" name="mobile" required>                          
                        </div>
                        <div class="col-md-12">
                           <label for="address">Address*</label>
                           <textarea class="contactus" placeholder="Address*" name="address" id="address" rows="4" required></textarea>                         
                        </div>
                        <div class="col-md-12">
                           <label>Gender*</label><br>
                           <input type="radio" name="gender" value="male" required> Male
                           <input type="radio" name="gender" value="female" required> Female
                           <input type="radio" name="gender" value="other" required> Other                          
                        </div>
                        <div class="col-md-12">
                           <label for="password">Password*</label>
                           <input class="contactus" placeholder="Password*" type="password" id="password" name="password" required>                          
                        </div>
                        <div class="col-md-12">
                           <label for="confirm_password">Confirm Password*</label>
                           <input class="contactus" placeholder="Confirm Password*" type="password" id="confirm_password" name="confirm_password" required>                          
                        </div>
                        <div class="col-md-12">
                           <button class="send_btn" type="submit" name="action" value="register">Sign Up</button>
                        </div>
                     </div>
                  </form>
               </div>
            </div>
         </div>
      </div>
</body>
</html>
