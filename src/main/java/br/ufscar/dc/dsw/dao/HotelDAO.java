package br.ufscar.dc.dsw.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.ufscar.dc.dsw.domain.Hotel;

public class HotelDAO extends GenericDAO {

    public void insert(Hotel hotel) {

        String sql = "insert into Hotel (email, senha, cnpj, nome, cidade) values (?, ?, ?, ?, ?);";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement = conn.prepareStatement(sql);
            statement.setString(1, hotel.getEmail());
            statement.setString(2, hotel.getSenha());
            statement.setString(3, hotel.getCNPJ());
            statement.setString(4, hotel.getNome());
            statement.setString(5, hotel.getCidade());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Hotel> getAll() {

        List<Hotel> listaHoteis = new ArrayList<>();

        String sql = "SELECT * from Hotel";

        try {
            Connection conn = this.getConnection();
            Statement statement = conn.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
            	String email = resultSet.getString("email");
            	String senha = resultSet.getString("senha");
                String CNPJ = resultSet.getString("cnpj");
                String nome = resultSet.getString("nome");
                String cidade = resultSet.getString("cidade");
                Hotel hotel = new Hotel(email, senha, CNPJ, nome, cidade);
                //hotel.setQtdeLivros(new LivroDAO().countByEditora(id));
                listaHoteis.add(hotel);
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaHoteis;
    }

    public void delete(Hotel hotel) {
        String sql = "DELETE FROM Hotel where CNPJ = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, hotel.getCNPJ());
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Hotel hotel) {
        String sql = "UPDATE Hotel SET email = ?, senha = ?, nome = ?, cidade = ?";
        sql += " WHERE cnpj = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);

            statement.setString(1, hotel.getEmail());
            statement.setString(2, hotel.getSenha());
            statement.setString(3, hotel.getNome());
            statement.setString(4, hotel.getCidade());
            statement.setString(5, hotel.getCNPJ());
            
            statement.executeUpdate();

            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //(email, senha, cnpj, nome, cidade) values (?, ?, ?, ?, ?)
    public Hotel get(String CNPJ) {
        Hotel hotel = null;
        
        String sql = "SELECT * from Hotel where cnpj = ?";

        try {
            Connection conn = this.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            
            statement.setString(1, CNPJ);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                String nome = resultSet.getString("senha");
                String cidade = resultSet.getString("cidade");
                
                hotel = new Hotel(email, senha, CNPJ, nome, cidade);
                //hotel.setQtdeLivros(new LivroDAO().countByEditora(id));
            }

            resultSet.close();
            statement.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return hotel;
    }
}
