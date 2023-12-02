package edu.loyola.cs485.model.dao;

import edu.loyola.cs485.model.entity.Client;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends AbstractDAO<Client>{

    @Override
    public void create(Client entity) throws SQLException{
        String sql="INSERT INTO client(name_client,email,dob) VALUES(?,?,?)";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setString(1, entity.getName() );
        pst.setString(2, entity.getEmail() );
        pst.setDate(3, entity.getDob() );
        pst.executeUpdate();
        ResultSet rs = pst.getGeneratedKeys();
        if(rs.next()){
            entity.setId(rs.getInt(1));
        }
        con.close();
    }

    public void create_v1(Client entity) throws SQLException{
        String sql="INSERT INTO client(name_client,email,dob) VALUES(?,?,?)";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, entity.getName() );
        pst.setString(2, entity.getEmail() );
        pst.setDate(3, entity.getDob() );
        pst.executeUpdate();
        con.close();
    }

    @Override
    public Client read(int id) throws SQLException {
        String sql = "SELECT * FROM client WHERE id_client = ?";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1,id);
        ResultSet rs = pst.executeQuery();
        Client c = null;
        if(rs.next()){
            c = new Client();
            c.setId( rs.getInt("id_client") );
            c.setName( rs.getString("name_client") );
            c.setEmail( rs.getString("email") );
            c.setDob( rs.getDate("dob") );
        }
        con.close();
        return c;
    }

    @Override
    public void update(Client entity) {

    }

    @Override
    public void delete(Client entity) throws SQLException {
        String sql = "DELETE FROM client WHERE id_client = ?";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, entity.getId() );
        pst.executeUpdate();
        con.close();
    }

    public List<Client>  list() throws SQLException {
        ArrayList<Client> lstClient = new ArrayList<>();
        Connection con = getConnection();
        String sql = "SELECT * FROM client ORDER BY name_client";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            Client c = new Client();
            c.setId( rs.getInt("id_client") );
            c.setName( rs.getString("name_client"));
            c.setEmail( rs.getString("email"));
            c.setDob( rs.getDate("dob"));
            lstClient.add(c);
        }
        con.close();
        return lstClient;
    }
}
