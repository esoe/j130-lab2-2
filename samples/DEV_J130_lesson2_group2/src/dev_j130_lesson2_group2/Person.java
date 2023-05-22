/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev_j130_lesson2_group2;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author denis
 */
class Person {
    private Integer id;
    private String jobtitle;
    private String firstnamelastname;
    private String phone;
    private String email;
    private Set<Domain> domains;

    public Person(Integer id, String jobtitle, String firstnamelastname, String phone, String email) {
        this.id = id;
        this.jobtitle = jobtitle;
        this.firstnamelastname = firstnamelastname;
        this.phone = phone;
        this.email = email;
        domains = new LinkedHashSet<>();
    }
    
    public Person(String jobtitle, String firstnamelastname, String phone, String email) {
        this.jobtitle = jobtitle;
        this.firstnamelastname = firstnamelastname;
        this.phone = phone;
        this.email = email;
        domains = new LinkedHashSet<>();
    }

    public Set<Domain> getDomains() {
        return domains;
    }

    public void setDomains(Set<Domain> domains) {
        this.domains = domains;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobtitle() {
        return jobtitle;
    }

    public void setJobtitle(String jobtitle) {
        this.jobtitle = jobtitle;
    }

    public String getFirstnamelastname() {
        return firstnamelastname;
    }

    public void setFirstnamelastname(String firstnamelastname) {
        this.firstnamelastname = firstnamelastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.jobtitle);
        hash = 59 * hash + Objects.hashCode(this.firstnamelastname);
        hash = 59 * hash + Objects.hashCode(this.phone);
        hash = 59 * hash + Objects.hashCode(this.email);
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
        final Person other = (Person) obj;
        if (!Objects.equals(this.jobtitle, other.jobtitle)) {
            return false;
        }
        if (!Objects.equals(this.firstnamelastname, other.firstnamelastname)) {
            return false;
        }
        if (!Objects.equals(this.phone, other.phone)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", jobtitle=" + jobtitle + ", firstnamelastname=" + firstnamelastname + ", phone=" + phone + ", email=" + email + '}';
    }
}
