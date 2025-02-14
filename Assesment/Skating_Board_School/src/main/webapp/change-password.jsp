<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="u-header.jsp"%>
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
                     <h2>Change Password</h2>
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
                  <input type="hidden" name="id" value="<%=u.getId()%>">
                     <div class="row">
                        <div class="col-md-12">
                           <label for="email">Old Password*</label>
                           <input class="contactus" placeholder="Old Password" type="password" id="password" name="op" required>                          
                        </div>
                        <div class="col-md-12">
                           <label for="password">New Password*</label>
                           <input class="contactus" placeholder="New Password" type="password" id="password" name="np" required>                          
                        </div>
                        <div class="col-md-12">
                           <label for="password">Confirm New Password*</label>
                           <input class="contactus" placeholder="Confirm New Password" type="password" id="password" name="cnp" required>                          
                        </div>
                        <div class="col-md-12">
                           <button class="send_btn" type="submit" name="action" value="cp">Change Password</button>
                        </div>
                     </div>
                  </form>
               </div>
            </div>
         </div>
      </div>
</body>
</html>
