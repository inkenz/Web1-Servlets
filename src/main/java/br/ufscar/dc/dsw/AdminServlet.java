package br.ufscar.dc.dsw;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufscar.dc.dsw.dao.HotelDAO;
import br.ufscar.dc.dsw.domain.Hotel;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String toHotel = request.getParameter("BT1");
		String toSite = request.getParameter("BT2");
		String toEditHotel = request.getParameter("BT3");
		String toEditSite = request.getParameter("BT4");
		
		if(toHotel != null){
			RequestDispatcher rs = request.getRequestDispatcher("cadastroHotel.jsp");
			rs.forward(request, response);
		}
		else if(toSite != null) {
			RequestDispatcher rs = request.getRequestDispatcher("cadastroSite.jsp");
			rs.forward(request, response);
		} if(toEditHotel != null) {
			HotelDAO hdao = new HotelDAO();
			List<Hotel> lista = hdao.getAll();
			request.setAttribute("hoteis", lista);
			RequestDispatcher rs = request.getRequestDispatcher("editarHotel.jsp");
			rs.forward(request, response);
		} if(toEditSite != null) {
			RequestDispatcher rs = request.getRequestDispatcher("editarSite.jsp");
			rs.forward(request, response);
		}
		else {
		RequestDispatcher rs = request.getRequestDispatcher("adminpage.jsp");
		rs.forward(request, response);
		}
	}

}
