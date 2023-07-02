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

import br.ufscar.dc.dsw.dao.HotelDAO;
import br.ufscar.dc.dsw.domain.Hotel;

/**
 * Servlet implementation class EditarHotel
 */
@WebServlet("/EditarHotel")
public class EditarHotel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarHotel() {
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
		
		String cnpj = request.getParameter("hotel");
		String senha = request.getParameter("senha");
		String nome = request.getParameter("nome");
		String cidade = request.getParameter("cidade");
		
		HotelDAO hdao = new HotelDAO();
		
		if(editar != null) 
		{
			if(senha.equals("") || cnpj.equals("") || nome.equals("") || cidade.equals(""))
			{
				mostrarErro("Campo vazio",request, response); 
				return;
			}
			
			
			
			
			Hotel aux = hdao.getByCNPJ(cnpj);
			Hotel hotel = new Hotel(aux.getEmail(),senha,cnpj,nome,cidade);
			hdao.update(hotel);
		}
		else if (apagar != null)
		{
			hdao.delete(cnpj);
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
		RequestDispatcher rd = request.getRequestDispatcher("editarHotel.jsp");
		rd.include(request, response);
		return;
	}

}
