package edu.loyola.cs485.model.entity;

public class Client extends AbstractEntity {
    private Integer Id;
    private String Name;
    private String Email;
    private java.sql.Date Dob;

    public Client(){
    }


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public java.sql.Date getDob() {
        return Dob;
    }

    public void setDob(java.sql.Date dob) {
        Dob = dob;
    }

    @Override public String toString(){
        return Integer.toString(Id)+" | "+Name+" <"+Email+">";
    }
}
