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
 * Servlet implementation class EditarSite
 */
@WebServlet("/EditarSite")
public class EditarSite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarSite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String editar = request.getParameter("EDITAR");
		String apagar = request.getParameter("APAGAR");
		
		String endereco = request.getParameter("site");
		String senha = request.getParameter("senha");
		String nome = request.getParameter("nome");
		String telefone = request.getParameter("telefone");
		
		SiteDAO sdao = new SiteDAO();
		
		if(editar != null) 
		{
			if(senha.equals("") || endereco.equals("") || nome.equals("") || telefone.equals(""))
			{
				mostrarErro("Campo vazio",request, response); 
				return;
			}
			
			
			
			
			Site aux = sdao.getByURL(endereco);
			Site site = new Site(aux.getEmail(),senha,endereco,nome,telefone);
			sdao.update(site);
		}
		else if (apagar != null)
		{
			sdao.delete(endereco);
		}	
		
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
		else if(motivo.equals("CNPJ em uso")) {
			if(local.toString().equals("pt_BR")) 
				mensagem_erro=mensagem_erro+"Esse cnpj já está em uso";
			else if(local.toString().equals("en_US"))
				mensagem_erro=mensagem_erro+"This cnpj is already in use";
			else 
				mensagem_erro=mensagem_erro+"ERROR";
		}
		mensagem_erro=mensagem_erro+"</font>";
		pw.println(mensagem_erro);
		RequestDispatcher rd = request.getRequestDispatcher("editarSite.jsp");
		rd.include(request, response);
		return;
	}
}
