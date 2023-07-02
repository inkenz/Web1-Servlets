package br.ufscar.dc.dsw;

import java.io.IOException;
import java.util.List;

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

/**
 * Servlet implementation class SiteServlet
 */
@WebServlet("/SiteServlet")
public class SiteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SiteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String toLista = request.getParameter("BT1");
		if(toLista != null) {
			PromocaoDAO pdao = new PromocaoDAO();
			HttpSession hs=request.getSession();
			String site_email= (String) hs.getAttribute("site");
			SiteDAO sdao = new SiteDAO();
			Site site = sdao.getByEmail(site_email);
			
			List<Promocao> lista = pdao.getAllSite(site.getURL());
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
