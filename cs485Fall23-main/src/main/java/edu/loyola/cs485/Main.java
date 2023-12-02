package edu.loyola.cs485;

import edu.loyola.cs485.model.dao.ClientDAO;
import edu.loyola.cs485.model.entity.Client;
import edu.loyola.cs485.view.MainFrame;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MainFrame f = new MainFrame();
        f.setVisible(true);
    }

    public static void listExample(){
        System.out.println("Hello world!");
        try {
            List<Client> lst;
            ClientDAO dao = new ClientDAO();
            lst = dao.list();
            for(Client c : lst) {
                System.out.println(c.getName());
            }
        }catch(Exception ex){
            System.out.println(ex);
        }
    }

    public static void preparedStatementExample(){
        String ConUrl = "jdbc:mysql://localhost";
        String Port = "3306";
        String Database = "music_db";
        String Username = "root";
        String Password = "csforever";

        try{
            String url = ConUrl+":"+Port+"/"+Database+"?user="+Username
                    +"&password="+Password;
            Connection con = DriverManager.getConnection(url);
            String sql = "INSERT INTO client(name_client,email) VALUES(?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1,"Prof. H. Rocha");
            pst.setString(2,"hsrocha@loyola.edu");
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
        String Database = "music_db";
        String Username = "root";
        String Password = "csforever";

        try{
            String url = ConUrl+":"+Port+"/"+Database+"?user="+Username
                    +"&password="+Password;
            Connection con = DriverManager.getConnection(url);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Client ORDER BY name_client");
            while(rs.next()){
                String cname = rs.getString("name_client");
                int cid = rs.getInt("id_client");
                Date dob = rs.getDate("dob");
                System.out.printf("%d %s %s \n",cid,cname, dob);
            }
            con.close();
        } catch(Exception ex){
            System.out.println(ex);
        }
    }

    public static void insertExample(){
        String ConUrl = "jdbc:mysql://localhost";
        String Port = "3306";
        String Database = "music_db";
        String Username = "root";
        String Password = "csforever";

        try{
            String url = ConUrl+":"+Port+"/"+Database+"?user="+Username
                    +"&password="+Password;
            Connection con = DriverManager.getConnection(url);
            Statement st = con.createStatement();
            int rows = st.executeUpdate("INSERT INTO artist(name_artist) VALUES ('Test')");

            con.close();
        } catch(Exception ex){
            System.out.println(ex);
        }

    }
}