package br.ufscar.dc.dsw;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.SiteDAO;
import br.ufscar.dc.dsw.domain.Site;

/**
 * Servlet implementation class CadastroSiteServlet
 */
@WebServlet("/CadastroSite")
public class CadastroSiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroSiteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html");
		
		String email = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		String url =  request.getParameter("url");
		String nome = request.getParameter("nome");
		String telefone =  request.getParameter("telefone");
		
		if(email.equals("") || senha.equals("") || url.equals("") || nome.equals("") || telefone.equals(""))
		{
			mostrarErro("Campo vazio",request, response); 
			return;
		}
		
		
		SiteDAO sdao = new SiteDAO();
		Site site = sdao.getByEmail(email);
		
		if(site != null)
		{
			mostrarErro("Email em uso",request, response); 
			return;
		}
		site = sdao.getByURL(url);
		
		if(site != null)
		{
			mostrarErro("URL em uso",request, response); 
			return;
		}	
		// É possível inserir agora
		site = new Site(email,senha,url,nome,telefone);
		
		sdao.insert(site);

		RequestDispatcher rd = request.getRequestDispatcher("adminpage.jsp");
		rd.forward(request, response);
	}
	
	
	void mostrarErro(String motivo, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter pw = response.getWriter();
		Locale local = request.getLocale();
		String mensagem_erro = "<font color=red size=2>";
		if(motivo.equals("Campo vazio")) {
			if(local.toString().equals("pt_BR")) 
				mensagem_erro=mensagem_erro+"Preencha todos os campos";
			else if(local.toString().equals("en_US"))
				mensagem_erro=mensagem_erro+"Fill all fields";
			else 
				mensagem_erro=mensagem_erro+"ERROR";
		}
		else if(motivo.equals("Email em uso")) {
			if(local.toString().equals("pt_BR")) 
				mensagem_erro=mensagem_erro+"Esse email já está em uso";
			else if(local.toString().equals("en_US"))
				mensagem_erro=mensagem_erro+"This email is already in use";
			else 
				mensagem_erro=mensagem_erro+"ERROR";
		}
		else if(motivo.equals("URL em uso")) {
			if(local.toString().equals("pt_BR")) 
				mensagem_erro=mensagem_erro+"Essa URL já está em uso";
			else if(local.toString().equals("en_US"))
				mensagem_erro=mensagem_erro+"This URL is already in use";
			else 
				mensagem_erro=mensagem_erro+"ERROR";
		}
		mensagem_erro=mensagem_erro+"</font>";
		pw.println(mensagem_erro);
		RequestDispatcher rd = request.getRequestDispatcher("cadastroSite.jsp");
		rd.include(request, response);
		return;
	}

}
