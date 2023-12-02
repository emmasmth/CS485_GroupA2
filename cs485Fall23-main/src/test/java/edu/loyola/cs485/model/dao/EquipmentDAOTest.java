package edu.loyola.cs485.model.dao;


import edu.loyola.cs485.model.entity.Equipment;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class EquipmentDAOTest {

    @Test public void testFake(){
        assertAll(
                ()-> assertEquals(1,1),
                ()-> assertNull(null)
        );
    }

    @Test
    public void testCreateClient() throws SQLException {
        EquipmentDAO dao = new EquipmentDAO();
        dao.setTestDatabase();
        Equipment c = new Equipment();
        c.setName("Test Client");
        c.setEmail("email@example.com");
        dao.create(c); //method under test
        Equipment found = dao.read(c.getId());
        assertAll( //assertions
                ()-> assertNotNull( c.getId() ),
                ()-> assertEquals(found.getEmail(), c.getEmail() )
        );
        dao.delete(c); //clean up
    }

    @Test public void testList() throws SQLException{
        EquipmentDAO dao = new EquipmentDAO();
        dao.setTestDatabase();
        for(int i=0; i<3; i++) {
            Equipment c = new Equipment();
            c.setName("Number "+Integer.toString(i));
            c.setEmail("Number "+Integer.toString(i));
            dao.create(c);
        }
        List<Equipment> lst = dao.list();
        assertAll(
                ()-> assertEquals(3, lst.size())
        );

        for(Equipment c : lst){ //Clean Up
            dao.delete(c);
        }
    }

}
