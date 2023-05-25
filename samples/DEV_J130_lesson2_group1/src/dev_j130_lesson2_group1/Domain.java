/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev_j130_lesson2_group1;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author denis
 */
public class Domain {
    int id;
    String webname;
    String domainname;
    String ip;
    Date datereg;
    String countryreg;
    Person person;

    public Domain(int id, String webname, String domainname, String ip, Date datereg, String countryreg, Person person) {
        this.id = id;
        this.webname = webname;
        this.domainname = domainname;
        this.ip = ip;
        this.datereg = datereg;
        this.countryreg = countryreg;
        this.person = person;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.webname);
        hash = 79 * hash + Objects.hashCode(this.domainname);
        hash = 79 * hash + Objects.hashCode(this.ip);
        hash = 79 * hash + Objects.hashCode(this.datereg);
        hash = 79 * hash + Objects.hashCode(this.countryreg);
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
        final Domain other = (Domain) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.webname, other.webname)) {
            return false;
        }
        if (!Objects.equals(this.domainname, other.domainname)) {
            return false;
        }
        if (!Objects.equals(this.ip, other.ip)) {
            return false;
        }
        if (!Objects.equals(this.countryreg, other.countryreg)) {
            return false;
        }
        if (!Objects.equals(this.datereg, other.datereg)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Domain{" + "id=" + id + ", webname=" + webname + ", domainname=" + domainname + ", ip=" + ip + ", datereg=" + datereg + ", countryreg=" + countryreg + '}';
    }

    
    
    
}
