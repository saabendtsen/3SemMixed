/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Person;
import java.util.Objects;

/**
 *
 * @author mikke
 */
public class PersonDTO {
    private Integer id;
    private String fName;
    private String lName;
    private String phone;
    public PersonDTO(Person p) {
        this.fName = p.getFirstName();
        this.lName = p.getLastName();
        this.phone = p.getPhone();
        this.id = p.getId();
    }
    public PersonDTO(String fn,String ln, String phone) {
        this.fName = fn;
        this.lName = ln;
        this.phone = phone;        
    }
    public PersonDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 79 * hash + Objects.hashCode(this.fName);
        hash = 79 * hash + Objects.hashCode(this.lName);
        hash = 79 * hash + Objects.hashCode(this.phone);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final PersonDTO other = (PersonDTO) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.fName, other.fName)) {
            return false;
        }
        if (!Objects.equals(this.lName, other.lName)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        return true;
    }


}


    

