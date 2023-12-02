package edu.loyola.cs485;

import edu.loyola.cs485.model.dao.EquipmentDAO;
import edu.loyola.cs485.model.entity.Equipment;
import edu.loyola.cs485.view.MainFrame;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MainFrame f = new MainFrame();
        f.setVisible(true);
    }

    public static void listExample(){
        System.out.println("Hello world!");
        try {
            List<Equipment> lst;
            EquipmentDAO dao = new EquipmentDAO();
            lst = dao.list();
            for(Equipment c : lst) {
                System.out.println(c.getId());
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public static void preparedStatementExample(){
        String ConUrl = "jdbc:mysql://localhost";
        String Port = "3306";
        String Database = "loyola_athletics";
        String Username = "root";
        String Password = "password";  // CHANGE THIS

        try{
            String url = ConUrl+":"+Port+"/"+Database+"?user="+Username
                    +"&password="+Password;
            Connection con = DriverManager.getConnection(url);
            String sql = "INSERT INTO equipment(brand, color, description) VALUES(?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,"Adidas");
            pst.setString(2,"(ever)green");
            pst.setString(3, "shoes basketball shoes i dont know");
            int rows = pst.executeUpdate();

            con.close();
        } catch(Exception ex){
            System.out.println(ex);
        }
    }

    public static void queryExample(){
        System.out.println("Hello world!");
        String ConUrl = "jdbc:mysql://localhost";
        String Port = "3306";
        String Database = "loyola_athletics";
        String Username = "root";
        String Password = "password"; // CHANGE THIS

        try{
            String url = ConUrl+":"+Port+"/"+Database+"?user="+Username
                    +"&password="+Password;
            Connection con = DriverManager.getConnection(url);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM equipment ORDER BY idequipment");
            while(rs.next()){
                int cid = rs.getInt("idequipment");
                String brand = rs.getString("brand");
                String color = rs.getString("color");
                String description = rs.getString("description");
                System.out.printf("%d %s %s %s\n",cid, brand, color, description);
            }
            con.close();
        } catch(Exception ex){
            System.out.println(ex);
        }
    }

    public static void insertExample(){
        String ConUrl = "jdbc:mysql://localhost";
        String Port = "3306";
        String Database = "loyola_athletics";
        String Username = "root";
        String Password = "password"; // CHANGE THIS

        try{
            String url = ConUrl+":"+Port+"/"+Database+"?user="+Username
                    +"&password="+Password;
            Connection con = DriverManager.getConnection(url);
            Statement st = con.createStatement();
            int rows = st.executeUpdate("INSERT INTO equipment(brand, color, description) VALUES ('test1', 'test1_color', 'test1_desc')");

            con.close();
        } catch(Exception ex){
            System.out.println(ex);
        }

    }
}