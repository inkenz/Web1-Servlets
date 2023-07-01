package br.ufscar.dc.dsw.controller;

import br.ufscar.dc.dsw.dao.HotelDAO;
import br.ufscar.dc.dsw.domain.Hotel;
import br.ufscar.dc.dsw.domain.Usuario;
import br.ufscar.dc.dsw.util.Erro;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/Hotel/*")
public class HotelController extends HttpServlet {
/*
	private static final long serialVersionUID = 1L;

	private HotelDAO dao;

	@Override
	public void init() {
		dao = new HotelDAO();
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioLogado");
		Erro erros = new Erro();

		if (usuario == null) {
			response.sendRedirect(request.getContextPath());
			return;
		} else if (!usuario.getPapel().equals("ADMIN")) {
			erros.add("Acesso não autorizado!");
			erros.add("Apenas Papel [ADMIN] tem acesso a essa página");
			request.setAttribute("mensagens", erros);
			RequestDispatcher rd = request.getRequestDispatcher("/noAuth.jsp");
			rd.forward(request, response);
			return;
		}
		
		String action = request.getPathInfo();
		if (action == null) {
			action = "";
		}

		try {
			switch (action) {
			case "/cadastro":
				apresentaFormCadastro(request, response);
				break;
			case "/insercao":
				insere(request, response);
				break;
			case "/remocao":
				remove(request, response);
				break;
			case "/edicao":
				apresentaFormEdicao(request, response);
				break;
			case "/atualizacao":
				atualize(request, response);
				break;
			default:
				lista(request, response);
				break;
			}
		} catch (RuntimeException | IOException | ServletException e) {
			throw new ServletException(e);
		}
	}

	private void lista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Hotel> listaHoteis = dao.getAll();
		request.setAttribute("listaHoteis", listaHoteis);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/Hotel/lista.jsp");
		dispatcher.forward(request, response);
	}

	private void apresentaFormCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/Hotel/formulario.jsp");
		dispatcher.forward(request, response);
	}

	private void apresentaFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cnpj = Long.parseLong(request.getParameter("id"));
		Hotel hotel = dao.get(cnpj);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logado/Hotel/formulario.jsp");
		request.setAttribute("hotel", hotel);
		dispatcher.forward(request, response);
	}

	private void insere(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String CNPJ = request.getParameter("CNPJ");
		String nome = request.getParameter("nome");
		String cidade = request.getParameter("cidade");
		
		Hotel hotel = new Hotel(email, senha, CNPJ, nome, cidade);

		dao.insert(hotel);
		response.sendRedirect("lista");
	}

	private void atualize(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String CNPJ = request.getParameter("CNPJ");
		String nome = request.getParameter("nome");
		String cidade = request.getParameter("cidade");

		Hotel hotel = new Hotel(email, senha, CNPJ, nome, cidade);

		dao.update(hotel);
		response.sendRedirect("lista");
	}
//
	private void remove(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		request.setCharacterEncoding("UTF-8");
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		String CNPJ = request.getParameter("CNPJ");
		String nome = request.getParameter("nome");
		String cidade = request.getParameter("cidade");
		
		Hotel hotel = new Hotel(email, senha, CNPJ, nome, cidade);
		dao.delete(hotel);
		response.sendRedirect("lista");
	}
	*/
}
