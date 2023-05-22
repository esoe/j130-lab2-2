/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev_j130_lesson2_group2;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashSet;
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
    private String url ="jdbc:derby://localhost:1527/PersonsDB";
    private String user = "root";
    private String password = "root";
    
    public Set<Person> findAllPerson(){
        Map<Integer, Person> persons = new HashMap<>();
        try (Connection connection = DriverManager.getConnection(url, user, password);
                Statement stm = connection.createStatement()) {
            ResultSet rs = stm.executeQuery("SELECT * FROM PERSON LEFT JOIN DOMAINS ON PERSON.ID=DOMAINS.PERSONID");
            while(rs.next()){
                Integer id = rs.getInt(1);
                Person person;
                if(!persons.containsKey(id)){
                    String jobtitle = rs.getString(2);
                    String firstnamelastname = rs.getString(3);
                    String phone = rs.getString(4);
                    String email = rs.getString(5);
                    person = new Person(id, jobtitle, firstnamelastname, phone, email);
                    persons.put(id, person);
                }else person = persons.get(id);
                Integer domainId = rs.getInt(6);
                String webname = rs.getString(7);
                if(webname!=null){
                    String domainname = rs.getString(8);
                    String ip = rs.getString(9);
                    Date datereg = rs.getDate(10);
                    String countryreg = rs.getString(11);
                    Domain domain = new Domain(domainId, webname, domainname, ip, datereg, countryreg);
                    domain.setPerson(person);
                    person.getDomains().add(domain);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Repository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return persons.values().stream().collect(Collectors.toSet());
    }
    
    public Set<Domain> findAllDomain(){
        Set<Domain> domains = new LinkedHashSet<>();
        try (Connection connection = DriverManager.getConnection(url, user, password);
                Statement stm = connection.createStatement()) {
            ResultSet rs = stm.executeQuery("SELECT * FROM DOMAINS LEFT JOIN PERSON ON DOMAINS.PERSONID=PERSON.ID");
            while(rs.next()){
                Integer id = rs.getInt(1);
                String webname = rs.getString(2);
                String domainname = rs.getString(3);
                String ip = rs.getString(4);
                Date datereg = rs.getDate(5);
                String countryreg = rs.getString(6);
                Domain domain = new Domain(id, webname, domainname, ip, datereg, countryreg);
                //Получаем данные персоны
                Integer personId = rs.getInt(7);//Если поле personid таблицы Domains пустое, то вернется значение 0, которое приведет к неверным результатам.
                String firstnamelastname = rs.getString(9);
                if(firstnamelastname!=null){
                    String jobtitle = rs.getString(8);
                    String phone = rs.getString(10);
                    String email = rs.getString(11);
                    Person person = new Person(personId, jobtitle, firstnamelastname, phone, email);
                    domain.setPerson(person);
                }
                domains.add(domain);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Repository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return domains;
    }
    
    public Set<Person> findPersonByFirstname(String firstname){
        Set <Person> persons = new LinkedHashSet<>();
        try (Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement pstm = connection.prepareStatement("SELECT * FROM PERSON WHERE JOBTITLE=?")) {
            pstm.setString(1, firstname);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Integer id = rs.getInt(1);
                String jobtitle = rs.getString(2);
                String firstnamelastname = rs.getString(3);
                String phone = rs.getString(4);
                String email = rs.getString(5);
                Person person = new Person(id, jobtitle, firstnamelastname, phone, email);
                persons.add(person);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Repository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return persons;
    }
    
    public Person findPersonById(int id){
        try (Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement pstm = connection.prepareStatement("SELECT * FROM PERSON WHERE id=?")) {
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Integer personId = rs.getInt(1);
                String jobtitle = rs.getString(2);
                String firstnamelastname = rs.getString(3);
                String phone = rs.getString(4);
                String email = rs.getString(5);
                Person person = new Person(personId, jobtitle, firstnamelastname, phone, email);
                return person;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Repository.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void save(Person person){
        try(Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement pstm = connection.prepareStatement("INSERT INTO PERSON (JOBTITLE, FIRSTNAMELASTNAME, PHONE, EMAIL) VALUES (?, ?, ?, ?)")){
            pstm.setString(1, person.getJobtitle());
            pstm.setString(2, person.getFirstnamelastname());
            pstm.setString(4, person.getEmail());
            pstm.setString(3, person.getPhone());
            pstm.execute();
        }catch (SQLException ex) {
            Logger.getLogger(Repository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
