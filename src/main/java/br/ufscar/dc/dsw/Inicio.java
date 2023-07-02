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
 * Servlet implementation class index
 */
@WebServlet("/Inicio")
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inicio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String toLogin = request.getParameter("BT1");
		String toLista = request.getParameter("BT2");
		String toListaPorCidade = request.getParameter("BT3");
		
		if(toLogin != null) 
		{
			RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
			rs.forward(request, response);
		}
		else if(toLista != null)
		{
			HotelDAO hdao = new HotelDAO();
			List<Hotel> lista = hdao.getAll();
			request.setAttribute("hoteis", lista);
			RequestDispatcher rs = request.getRequestDispatcher("listaHoteis.jsp");
			rs.forward(request, response);
		}
		else if(toListaPorCidade != null) 
		{
			HotelDAO hdao = new HotelDAO();
			List<Hotel> lista = hdao.getAllOrderByCidade();
			request.setAttribute("hoteis", lista);
			RequestDispatcher rs = request.getRequestDispatcher("listaHoteis.jsp");
			rs.forward(request, response);
		}else 
		{
			RequestDispatcher rs = request.getRequestDispatcher("inicio.jsp");
			rs.forward(request, response);
		}
	}

}
