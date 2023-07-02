package br.ufscar.dc.dsw;

import java.util.Locale;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ufscar.dc.dsw.dao.UsuarioDAO;
import br.ufscar.dc.dsw.domain.Usuario;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(urlPatterns = {"/Login","/ListHotel"})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Locale local = request.getLocale();	
		request.setCharacterEncoding("UTF-8");	
		PrintWriter pw = response.getWriter(); 
		response.setContentType("text/html");
		
		String email = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		UsuarioDAO udao = new UsuarioDAO();
		Usuario admin = udao.get(email);
		
		if(admin == null || !admin.getSenha().equals(senha)) {
			String mensagem_erro = "<font color=red size=2>";
			if(local != null){
				if(local.toString().equals("pt_BR")){
					mensagem_erro=mensagem_erro+"Usuário ou senha incorretos";
				}
				else if(local.toString().equals("en_US")){
					mensagem_erro=mensagem_erro+"Incorrect user or password";
				}
				else {
					mensagem_erro=mensagem_erro+"ERROR";
				}
			}
			mensagem_erro=mensagem_erro+"</font>";
			pw.println(mensagem_erro);

			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
			return;
		}
		
		
		HttpSession hs=request.getSession();
		
		
		if(admin.getPapel().equals("admin")){
			hs.setAttribute("admin", email);
			hs.setAttribute("hotel", null);
			hs.setAttribute("site", null);
			RequestDispatcher rd = request.getRequestDispatcher("adminpage.jsp");
			rd.forward(request, response);
		}
		else if(admin.getPapel().equals("hotel")){
			hs.setAttribute("admin", null);
			hs.setAttribute("hotel", email);
			hs.setAttribute("site", null);
			
			RequestDispatcher rd = request.getRequestDispatcher("hoteladminpage.jsp");
			rd.forward(request, response);
		}
		else if(admin.getPapel().equals("site")){
			hs.setAttribute("admin", null);
			hs.setAttribute("hotel", null);
			hs.setAttribute("site", email);
			RequestDispatcher rd = request.getRequestDispatcher("siteadminpage.jsp");
			rd.forward(request, response);
		}
	}

}
