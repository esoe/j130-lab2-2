/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev_j130_lesson2_group2;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author denis
 */
class Domain {
    private Integer id;
    private String webname;
    private String domainname;
    private String ip;
    private Date datereg;
    private String countryreg;
    private Person person;

    public Domain(Integer id, String webname, String domainname, String ip, Date datereg, String countryreg) {
        this.id = id;
        this.webname = webname;
        this.domainname = domainname;
        this.ip = ip;
        this.datereg = datereg;
        this.countryreg = countryreg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWebname() {
        return webname;
    }

    public void setWebname(String webname) {
        this.webname = webname;
    }

    public String getDomainname() {
        return domainname;
    }

    public void setDomainname(String domainname) {
        this.domainname = domainname;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getDatereg() {
        return datereg;
    }

    public void setDatereg(Date datereg) {
        this.datereg = datereg;
    }

    public String getCountryreg() {
        return countryreg;
    }

    public void setCountryreg(String countryreg) {
        this.countryreg = countryreg;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.webname);
        hash = 53 * hash + Objects.hashCode(this.domainname);
        hash = 53 * hash + Objects.hashCode(this.ip);
        hash = 53 * hash + Objects.hashCode(this.datereg);
        hash = 53 * hash + Objects.hashCode(this.countryreg);
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
        if (!Objects.equals(this.id, other.id)) {
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
