

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		String pswd = request.getParameter("pswd");
		PrintWriter pw = response.getWriter();
		RequestDispatcher rd= request.getRequestDispatcher("index.html");
		rd.include(request, response);
		response.setContentType("text/html");
		if(user.isBlank()) {
			pw.print("Cannot have blank spaces...Please try again");	
		}else {
			if(user.equals(pswd)) {
				HttpSession hs= request.getSession();
				hs.setAttribute("userid", user);
				
				pw.print("<html><body><h3>login successfully</h3>"+ "<br>"+"<i>Welcome "+ user +"</i></body></html>");
			}else {
				pw.print("login failed");
			}
			
		}
	}

}
