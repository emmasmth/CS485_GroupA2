package edu.loyola.cs485.controller;

import edu.loyola.cs485.model.dao.EquipmentDAO;
import edu.loyola.cs485.model.entity.Equipment;

import java.util.List;

public class EquipmentService {

    private Equipment tothis;

    public void createNewEquipment(String brand, String color, String description)
            throws Exception{
        Equipment c = new Equipment();
        c.setBrand( brand );
        c.setColor( color );
        c.setDescription(description);

        EquipmentDAO dao = new EquipmentDAO();
        dao.create( c );

    }

    public List<Equipment> getEquipment() throws Exception{
        EquipmentDAO dao = new EquipmentDAO();
        return dao.list();
    }

    public void update(Equipment c) throws Exception
    {
        if(c!=null)
        {
            EquipmentDAO dao = new EquipmentDAO();
            dao.setTothis(tothis);
            dao.update(c);
        }
    }

    public void delete(Equipment c) throws Exception {
        if(c!=null) {
            EquipmentDAO dao = new EquipmentDAO();
            dao.delete(c);
        }
    }

    public void setTothis(Equipment e)
    {
        this.tothis = e;
    }
}
