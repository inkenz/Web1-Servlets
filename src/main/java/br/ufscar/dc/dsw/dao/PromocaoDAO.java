package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Promocao;

public class PromocaoDAO extends GenericDAO{
	
    public void insert(Promocao promocao) {

        String sql = "insert into Promocao (id, endereco, cnpj_hotel, preco, data_ini, data_fim) values (?, ?, ?, ?, ?, ?);";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement;

            statement = conn.prepareStatement(sql);
            statement.setLong(1, promocao.getId());
            statement.setString(2, promocao.getEndereco());
            statement.setString(3, promocao.getCNPJ());
            statement.setFloat(4, promocao.getPreco());
            statement.setDate(5, promocao.getInicio());
            statement.setDate(6, promocao.getFim());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Promocao> getAll() {

        List<Promocao> listaPromocoes = new ArrayList<>();

        String sql = "SELECT * from Promocao";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
            	//(endereco, cnpj_hotel, preco, data_ini, data_fim)
            	long id = resultSet.getLong("id");
            	String endereco = resultSet.getString("endereco");
                String CNPJ = resultSet.getString("cnpj_hotel");
                float preco = resultSet.getFloat("preco");
                Date inicio = resultSet.getDate("data_ini");
                Date fim = resultSet.getDate("data_fim");
                Promocao promocao = new Promocao(id, endereco, CNPJ, preco, inicio, fim);
                
                listaPromocoes.add(promocao);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPromocoes;
    }
    
    public List<Promocao> getAllHotel(String cnpj) {

        List<Promocao> listaPromocoes = new ArrayList<>();

        String sql = "SELECT * FROM Promocao WHERE cnpj_hotel = ?";

        try {
        	Connection conn = this.getConnection();
            PreparedStatement statement;

            statement = conn.prepareStatement(sql);
            statement.setString(1, cnpj);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
            	System.out.print("\n\n\n oioioioioio");
            	//(endereco, cnpj_hotel, preco, data_ini, data_fim)
            	long id = resultSet.getLong("id");
            	String endereco = resultSet.getString("endereco");
                float preco = resultSet.getFloat("preco");
                Date inicio = resultSet.getDate("data_ini");
                Date fim = resultSet.getDate("data_fim");
                
                Promocao promocao = new Promocao(id, endereco, cnpj, preco, inicio, fim);
                
                listaPromocoes.add(promocao);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPromocoes;
    }
    
    
    public void delete(Promocao promocao) {
        String sql = "DELETE FROM Promocao where id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setLong(1, promocao.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Promocao promocao) {
        String sql = "UPDATE Promocao SET endereco = ?, cnpj_hotel = ?, preco = ?, data_ini = ?, data_fim = ?";
        sql += " WHERE id = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, promocao.getEndereco());
            statement.setString(2, promocao.getCNPJ());
            statement.setFloat(3, promocao.getPreco());
            statement.setDate(4, promocao.getInicio());
            statement.setDate(5, promocao.getFim());
            statement.setLong(6, promocao.getId());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //(email, senha, cnpj, nome, cidade) values (?, ?, ?, ?, ?)
    public Promocao getByCNPJ(String cnpj) {
        Promocao promocao = null;
        
        String sql = "SELECT * from Promocao where cnpj_hotel = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, cnpj);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	long id = resultSet.getLong("id");
            	String endereco = resultSet.getString("endereco");
                float preco = resultSet.getFloat("preco");
                Date inicio = resultSet.getDate("data_ini");
                Date fim = resultSet.getDate("data_fim");
                
                promocao = new Promocao(id, endereco, cnpj, preco, inicio, fim);
                //hotel.setQtdeLivros(new LivroDAO().countByEditora(id));
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return promocao;
    }
    
    public Promocao getByEndereco(String url) {
        Promocao promocao = null;
        
        String sql = "SELECT * from Promocao where endereco = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, url);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	long id = resultSet.getLong("id");
            	String cnpj = resultSet.getString("cnpj_hotel");
            	String endereco = resultSet.getString("endereco");
                float preco = resultSet.getFloat("preco");
                Date inicio = resultSet.getDate("data_ini");
                Date fim = resultSet.getDate("data_fim");
                
                promocao = new Promocao(id, endereco, cnpj, preco, inicio, fim);
                //hotel.setQtdeLivros(new LivroDAO().countByEditora(id));
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return promocao;
    }
    public Promocao getByDate(Date data) {
        Promocao promocao = null;
        
        String sql = "SELECT * from Promocao where data_ini = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setDate(1, data);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
            	long id = resultSet.getLong("id");
            	String cnpj = resultSet.getString("cnpj_hotel");
            	String endereco = resultSet.getString("endereco");
                float preco = resultSet.getFloat("preco");
                Date inicio = resultSet.getDate("data_ini");
                Date fim = resultSet.getDate("data_fim");
                
                promocao = new Promocao(id, endereco, cnpj, preco, inicio, fim);
                //hotel.setQtdeLivros(new LivroDAO().countByEditora(id));
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return promocao;
    }
}