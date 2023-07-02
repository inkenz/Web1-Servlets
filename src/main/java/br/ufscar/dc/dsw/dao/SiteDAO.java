package br.ufscar.dc.dsw.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Site;
import br.ufscar.dc.dsw.domain.Usuario;


public class SiteDAO extends GenericDAO {
	
	public void insert(Site site){
		String sql = "insert into Site (email, senha, endereco, nome, telefone) values (?, ?, ?, ?, ?);";
		Usuario u = new Usuario(site.getEmail(),site.getSenha(),"site");
        UsuarioDAO udao = new UsuarioDAO();
        udao.insert(u);
		try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement = conn.prepareStatement(sql);
            statement.setString(1, site.getEmail());
            statement.setString(2, site.getSenha());
            statement.setString(3, site.getURL());
            statement.setString(4, site.getNome());
            statement.setString(5, site.getTelefone());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
	
	public List<Site> getAll() {

        List<Site> listaSites = new ArrayList<>();

        String sql = "SELECT * from Site";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
            	String email = resultSet.getString("email");
            	String senha = resultSet.getString("senha");
                String endereco = resultSet.getString("endereco");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                Site site = new Site(email, senha, endereco, nome, telefone);
                
                listaSites.add(site);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaSites;
    }
	
	public void delete(String site) {
        String sql = "DELETE FROM Site where endereco = ?";
        String email = this.getByURL(site).getEmail();
        UsuarioDAO udao = new UsuarioDAO();
        udao.delete(email);
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, site);
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public void update(Site site) {
        String sql = "UPDATE Site SET email = ?, senha = ?, nome = ?, telefone = ?";
        sql += " WHERE endereco = ?";
        Usuario u = new Usuario(site.getEmail(),site.getSenha(),"site");
        UsuarioDAO udao = new UsuarioDAO();
        udao.update(u);
        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, site.getEmail());
            statement.setString(2, site.getSenha());
            statement.setString(3, site.getNome());
            statement.setString(4, site.getTelefone());
            statement.setString(5, site.getURL());
            
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
	public Site getByURL(String endereco) {
        Site site = null;
        
        String sql = "SELECT * from Site where endereco = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, endereco);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                
                site = new Site(email, senha, endereco, nome, telefone);
                //hotel.setQtdeLivros(new LivroDAO().countByEditora(id));
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return site;
    }
	
	public Site getByEmail(String email) {
        Site site = null;
        
        String sql = "SELECT * from Site where email = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String endereco = resultSet.getString("endereco");
                String senha = resultSet.getString("senha");
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");
                
                site = new Site(email, senha, endereco, nome, telefone);
                //hotel.setQtdeLivros(new LivroDAO().countByEditora(id));
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return site;
    }
}