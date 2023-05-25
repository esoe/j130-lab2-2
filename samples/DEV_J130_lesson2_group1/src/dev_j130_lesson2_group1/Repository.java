/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev_j130_lesson2_group1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author denis
 */
public class Repository {
    private String url;
    private String login;
    private String password;

    public Repository() {
        url = "jdbc:derby://localhost:1527/PersonsDB";
        login = "root";
        password = "root";
    }
    
    
    
    public Set<Person> findAllPerson(){
        Map<Integer, Person> personMap = new LinkedHashMap<>();
        try (Connection connection = DriverManager.getConnection(url, login, password);
                Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery("SELECT * FROM PERSON LEFT JOIN DOMAINS ON PERSON.ID=DOMAINS.PERSONID");
            while(rs.next()){
                Person person;
                Integer personId = rs.getInt(1);
                if(!personMap.containsKey(personId)){
                    String jobtitle = rs.getString(2);
                    String firstnamelastname = rs.getString(3);
                    String phone = rs.getString(4);
                    String emai = rs.getString(5);
                    person = new Person(personId, jobtitle, firstnamelastname, phone, emai);
                    personMap.put(personId, person);
                }else person = personMap.get(personId);
                int domainId = rs.getInt(6);
                String domainname = rs.getString(8);
                if(domainname!=null){
                    String webname = rs.getString(7);
                    String ip = rs.getString(9);
                    Date datereg = rs.getDate(10);
                    String countryreg = rs.getString(11);
                    Domain domain = new Domain(domainId, webname, domainname, ip, datereg, countryreg, person);
                    person.addDomains(domain);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Repository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return personMap.values().stream().collect(Collectors.toSet());
    }
    
    public Set<Person> findPersonByJobtitle(String jobtitle){
        Set<Person> persons = new LinkedHashSet<>();
        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement ps = connection.prepareStatement("SELECT ID, JOBTITLE, FIRSTNAMELASTNAME, PHONE, EMAIL FROM PERSON WHERE JOBTITLE=?")){
            ps.setString(1, jobtitle);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt(1);
                String job = rs.getString(2);
                String firstnamelastname = rs.getString(3);
                String phone = rs.getString(4);
                String emai = rs.getString(5);
                Person person = new Person(id, job, firstnamelastname, phone, emai);
                persons.add(person);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Repository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return persons;
    }
    
    public void saveAll(List<Person> persons){
        try (Connection connection = DriverManager.getConnection(url, login, password);
                PreparedStatement ps = connection.prepareStatement("INSERT INTO PERSON (JOBTITLE, FIRSTNAMELASTNAME, PHONE, EMAIL) VALUES (?, ?, ?, ?)")){
            for (Person person : persons){
                ps.setString(1, person.getJobtitle());
                ps.setString(2, person.getFirstnamelastname());
                ps.setString(3, person.getPhone());
                ps.setString(4, person.getEmail());
                ps.addBatch();
            }
            ps.executeBatch();
        } catch (SQLException ex) {
            Logger.getLogger(Repository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
