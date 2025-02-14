package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;
import service.EmailService;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equalsIgnoreCase("register")) {
			User u = new User();
			u.setFirst_name(request.getParameter("first_name"));
			u.setLast_name(request.getParameter("last_name"));
			u.setEmail(request.getParameter("email"));
			u.setMobile(request.getParameter("mobile"));
			u.setAddress(request.getParameter("address"));
			u.setGender(request.getParameter("gender"));
			u.setPassword(request.getParameter("password"));
			System.out.println(u);
			String ConfirmPassword = request.getParameter("confirm_password");

			// Validate fields (basic check)
			if (u.getFirst_name().isBlank() || u.getLast_name().isEmpty() || u.getEmail().isEmpty()
					|| u.getMobile().isEmpty() || u.getAddress().isEmpty() || u.getGender().isEmpty()
					|| u.getPassword().isEmpty()) {

				request.setAttribute("error", "All fields are required");
				request.getRequestDispatcher("signup.jsp").forward(request, response);
				return;
			}

		    // Check if passwords match
			if(!u.getPassword().equals(ConfirmPassword)) {
				request.setAttribute("error", "Password do not match");
				request.getRequestDispatcher("signup.jsp").forward(request, response);
				return;
			}
			
			//Insert user into database
			String email = request.getParameter("email");
			boolean flag = UserDao.checkEmail(email);
			if(flag==false) {
				UserDao.insertUser(u);
				response.sendRedirect("login.jsp");
			}else {
				request.setAttribute("error", "Account Already exist with this acccount");
				request.getRequestDispatcher("signup.jsp").forward(request, response);
			}
			
		}
		else if (action.equalsIgnoreCase("login")) {
			User u = new User();
			u.setEmail(request.getParameter("email"));
			u.setPassword(request.getParameter("password"));
			boolean flag = UserDao.checkEmail(request.getParameter("email"));
			if(flag==true) {
				User u1 = UserDao.userLogin(u);
				if(u1!=null) {
					HttpSession session = request.getSession();
					session.setAttribute("data", u1);
					request.getRequestDispatcher("u-home.jsp").forward(request, response);
				}else {
					request.setAttribute("error", "Password is incorrect");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}else {
				request.setAttribute("error", "OOPS! Account not exist.");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		else if (action.equalsIgnoreCase("cp")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String op = request.getParameter("op");
			String np= request.getParameter("np");
			String cnp = request.getParameter("cnp");
			boolean flag = UserDao.checkOldPassword(id, op);
			if(flag==true) {
				if(np.equals(cnp)) {
					UserDao.setNewPassword(id, np);
					request.setAttribute("error", "Password updated Successfully");
					request.getRequestDispatcher("change-password.jsp").forward(request, response);
				}else {
					request.setAttribute("error", "New password and confirm new password not matched");
					request.getRequestDispatcher("change-password.jsp").forward(request, response);
				}
			}else {
				request.setAttribute("error", "Old password is incorrect");
				request.getRequestDispatcher("change-password.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("getotp")) {
			String email = request.getParameter("email");
			boolean flag = UserDao.checkEmail(email);
			if(flag==true) {
				Random r = new Random();
				int num = r.nextInt(999999);
				EmailService s = new EmailService();
				s.sendMail(email, num);
				request.setAttribute("email", email);
				request.setAttribute("otp", num);
				request.getRequestDispatcher("verify-otp.jsp").forward(request, response);
			}else {
				request.setAttribute("error", "Account does not exist");
				request.getRequestDispatcher("forgot-password.jsp").forward(request, response);
			}
		}
		else if (action.equalsIgnoreCase("verify")) {
			String email = request.getParameter("email");
			int otp1 = Integer.parseInt(request.getParameter("otp1"));
			int otp2 = Integer.parseInt(request.getParameter("otp2"));
			if(otp1 == otp2) {
				request.setAttribute("email", email);
				request.getRequestDispatcher("new-password.jsp").forward(request, response);
			}
			else {
				request.setAttribute("email", email);
				request.setAttribute("otp", otp1);
				request.setAttribute("msg", "OTP not matched");
				request.getRequestDispatcher("verify-otp.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("np")) {
			String email = request.getParameter("email");
			String np = request.getParameter("np");
			String cnp = request.getParameter("cnp");
			if(np.equals(cnp)) {
				UserDao.setForgotNewPassword(email, np);
				response.sendRedirect("login.jsp");
			}
			else {
				request.setAttribute("email", email);
				request.setAttribute("error", "Password not matched");
				request.getRequestDispatcher("new-password.jsp").forward(request, response);
			}
		}
	}

}
