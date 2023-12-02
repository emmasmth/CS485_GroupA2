package edu.loyola.cs485.model.dao;

import edu.loyola.cs485.model.entity.Equipment;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipmentDAO extends AbstractDAO<Equipment>{

    private Equipment tothis;

    @Override
    public void create(Equipment entity) throws SQLException{
        String sql="INSERT INTO equipment(brand, color, description) VALUES(?,?,?)";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
        pst.setString(1, entity.getBrand() );
        pst.setString(2, entity.getColor() );
        pst.setString(3, entity.getDescription() );
        pst.executeUpdate();
        ResultSet rs = pst.getGeneratedKeys();
        if(rs.next()){
            entity.setId(rs.getInt(1));
        }
        con.close();
    }

    @Override
    public Equipment read(int id) throws SQLException {
        String sql = "SELECT * FROM equipment WHERE idequipment = ?";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1,id);
        ResultSet rs = pst.executeQuery();
        Equipment c = null;
        if(rs.next()){
            c = new Equipment();
            c.setId( rs.getInt("idequipment") );
            c.setBrand( rs.getString("brand") );
            c.setColor( rs.getString("color") );
            c.setDescription( rs.getString("description") );
        }
        con.close();
        return c;
    }

    @Override
    public void update(Equipment entity) throws SQLException{

        System.out.println("AGAIN: " + tothis.toString());

        // entity is the old entity that we are changing
        // we'll use tothis for new info
        String sql = "UPDATE equipment SET brand = ?, color = ?, description = ? WHERE idequipment = ?";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, tothis.getBrand());
        pst.setString(2, tothis.getColor());
        pst.setString(3, tothis.getDescription());
        pst.setInt(4, entity.getId());
        pst.executeUpdate();
        con.close();
    }

    @Override
    public void delete(Equipment entity) throws SQLException {
        String sql = "DELETE FROM equipment WHERE idequipment = ?";
        Connection con = getConnection();
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, entity.getId() );
        pst.executeUpdate();
        con.close();
    }

    public List<Equipment>  list() throws SQLException {
        ArrayList<Equipment> lstEquipment = new ArrayList<>();
        Connection con = getConnection();
        String sql = "SELECT * FROM equipment ORDER BY idequipment";
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()){
            Equipment c = new Equipment();
            c.setId( rs.getInt("idequipment") );
            c.setBrand( rs.getString("brand"));
            c.setColor( rs.getString("color"));
            c.setDescription( rs.getString("description"));
            lstEquipment.add(c);
        }
        con.close();
        return lstEquipment;
    }

    public void setTothis(Equipment e)
    {
        this.tothis = e;
    }
}
