package br.ufscar.dc.dsw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ufscar.dc.dsw.dao.HotelDAO;
import br.ufscar.dc.dsw.dao.PromocaoDAO;
import br.ufscar.dc.dsw.dao.SiteDAO;
import br.ufscar.dc.dsw.domain.Hotel;
import br.ufscar.dc.dsw.domain.Promocao;
import br.ufscar.dc.dsw.domain.Site;
import java.util.List;
import java.util.Locale;
/**
 * Servlet implementation class HotelServlet
 */
@WebServlet("/HotelServlet")
public class HotelServlet extends HttpServlet {   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HotelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String toCadastro= request.getParameter("BT1");
		String toLista = request.getParameter("BT2");
		if(toCadastro != null) {
			SiteDAO sdao = new SiteDAO();
			List<Site> lista = sdao.getAll();
			request.setAttribute("sites", lista);
			HttpSession hs=request.getSession();
			String hotel_email= (String) hs.getAttribute("hotel");
			hs.setAttribute("hotel", hotel_email);
			RequestDispatcher rs = request.getRequestDispatcher("cadastroPromocaoHotel.jsp");
			rs.forward(request, response);
		}if(toLista != null) {
			PromocaoDAO pdao = new PromocaoDAO();
			HttpSession hs=request.getSession();
			String hotel_email= (String) hs.getAttribute("hotel");
			HotelDAO hdao = new HotelDAO();
			Hotel hotel = hdao.getByEmail(hotel_email);
			
			List<Promocao> lista = pdao.getAllHotel(hotel.getCNPJ());
			if(lista == null) {
				PrintWriter pw = response.getWriter();
				Locale local = request.getLocale();
				String mensagem_erro = "<font color=red size=2>";
				
				if(local.toString().equals("pt_BR")) 
					mensagem_erro=mensagem_erro+"Não há promoções cadastradas";
				else if(local.toString().equals("en_US"))
					mensagem_erro=mensagem_erro+"This hotel doesn't have discounts";
				else 
					mensagem_erro=mensagem_erro+"ERROR";
			
				mensagem_erro=mensagem_erro+"</font>";
				pw.println(mensagem_erro);
				RequestDispatcher rd = request.getRequestDispatcher("cadastroPromocaoHotel.jsp");
				rd.include(request, response);
				return;
			}
			
			request.setAttribute("promocoes", lista);
			RequestDispatcher rs = request.getRequestDispatcher("listaPromocoes.jsp");
			rs.forward(request, response);
		}
		else {
			RequestDispatcher rs = request.getRequestDispatcher("hoteladminpage.jsp");
			rs.forward(request, response);
		}
	}

}
