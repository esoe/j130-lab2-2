/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev_j130_lesson2_group1;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author denis
 */
public class Person {
    private int id;
    private String jobtitle;
    private String firstnamelastname;
    private String phone;
    private String email;
    private Set<Domain> domains = new LinkedHashSet<>();

    public Person(int id, String jobtitle, String firstnamelastname, String phone, String email) {
        this.id = id;
        this.jobtitle = jobtitle;
        this.firstnamelastname = firstnamelastname;
        this.phone = phone;
        this.email = email;
    }
    
    public Person(String jobtitle, String firstnamelastname, String phone, String email) {
        this.jobtitle = jobtitle;
        this.firstnamelastname = firstnamelastname;
        this.phone = phone;
        this.email = email;
    }

    public void addDomains(Domain domain) {
        domains.add(domain);
    }
    
    public int getId() {
        return id;
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
        hash = 83 * hash + this.id;
        hash = 83 * hash + Objects.hashCode(this.jobtitle);
        hash = 83 * hash + Objects.hashCode(this.firstnamelastname);
        hash = 83 * hash + Objects.hashCode(this.phone);
        hash = 83 * hash + Objects.hashCode(this.email);
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
        if (this.id != other.id) {
            return false;
        }
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
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person{").append("id=").append(id).append(", jobtitle=").append(jobtitle);
        sb.append(", firstnamelastname=").append(firstnamelastname).append(", phone=").append(phone);
        sb.append(", email=").append(email).append("}\n");
        if(domains.size()>0){
            domains.forEach(domain -> {
                sb.append(domain).append("\n");
            });
        }
        return sb.toString();
    }
    
    
}
