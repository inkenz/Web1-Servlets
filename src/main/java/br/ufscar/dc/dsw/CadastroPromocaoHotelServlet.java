package br.ufscar.dc.dsw;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ufscar.dc.dsw.dao.HotelDAO;
import br.ufscar.dc.dsw.dao.PromocaoDAO;
import br.ufscar.dc.dsw.domain.Hotel;
import br.ufscar.dc.dsw.domain.Promocao;

/**
 * Servlet implementation class CadastroPromocaoHotel
 */
@WebServlet("/CadastroPromocaoHotel")
public class CadastroPromocaoHotelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastroPromocaoHotelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		String site = request.getParameter("site");
		String dataIniStr = request.getParameter("dataIni");
		String dataFimStr = request.getParameter("dataFim");
		String precoStr = request.getParameter("preco");
		
		if(site == null || precoStr == "")
		{
			mostrarErro("Campo vazio",request, response); 
			return;
		}
		
		try {
			Date dataIni = Date.valueOf(dataIniStr);
			Date dataFim = Date.valueOf(dataFimStr);
			
			
			try {
				float preco = new Float(precoStr);

				HttpSession hs=request.getSession();
				String hotel_email= (String) hs.getAttribute("hotel");
				
				HotelDAO hdao = new HotelDAO();
				Hotel hotel = hdao.getByEmail(hotel_email);
				
				String cnpj = hotel.getCNPJ();
				
				PromocaoDAO pdao = new PromocaoDAO();
				
				
				List<Promocao> lista = pdao.getAll();
				long id = lista.size()+1;
				Promocao aux =pdao.getByDate(dataIni);
				if(pdao.getByDate(dataIni) != null) {
					if(aux.getCNPJ().equals(cnpj)) {
						mostrarErro("Mesma data cnpj",request, response); 
						return;
					}
					if(aux.getEndereco().equals(site)) {
						mostrarErro("Mesma data site",request, response); 
						
						return;
					}
				}
				
				Promocao promocao = new Promocao(id, site, cnpj, preco, dataIni, dataFim);
						
				pdao.insert(promocao);
				RequestDispatcher rd = request.getRequestDispatcher("hoteladminpage.jsp");
				rd.forward(request, response);
			
			
			
			}
			catch(Exception e){
				mostrarErro("Campo vazio",request, response); 
				return;
			}
			
		}
		catch(Exception e){
			mostrarErro("Campo vazio",request, response); 
			return;
		}
		
	}
	
	void mostrarErro(String motivo, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter pw = response.getWriter();
		Locale local = request.getLocale();
		String mensagem_erro = "<font color=red size=2>";
		if(motivo.equals("Campo vazio")) {
			if(local.toString().equals("pt_BR")) 
				mensagem_erro=mensagem_erro+"Preencha todos os campos corretamente";
			else if(local.toString().equals("en_US"))
				mensagem_erro=mensagem_erro+"Fill all fields correctly";
			else 
				mensagem_erro=mensagem_erro+"ERROR";
		}
		else if(motivo.equals("Mesma data cnpj")) {
			if(local.toString().equals("pt_BR")) 
				mensagem_erro=mensagem_erro+"O hotel já foi escolheu essa data";
			else if(local.toString().equals("en_US"))
				mensagem_erro=mensagem_erro+"Hotel have already chose this date";
			else 
				mensagem_erro=mensagem_erro+"ERROR";
		}
		else if(motivo.equals("Mesma data site")) {
			if(local.toString().equals("pt_BR")) 
				mensagem_erro=mensagem_erro+"O site já foi escolheu essa data de inicio";
			else if(local.toString().equals("en_US"))
				mensagem_erro=mensagem_erro+"Site have already chose this initial date";
			else 
				mensagem_erro=mensagem_erro+"ERROR";
		}
		mensagem_erro=mensagem_erro+"</font>";
		pw.println(mensagem_erro);
		RequestDispatcher rd = request.getRequestDispatcher("cadastroPromocaoHotel.jsp");
		rd.include(request, response);
		return;
	}

}
