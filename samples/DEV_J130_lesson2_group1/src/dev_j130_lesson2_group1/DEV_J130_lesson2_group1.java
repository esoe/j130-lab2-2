/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev_j130_lesson2_group1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author denis
 */
public class DEV_J130_lesson2_group1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Repository repository = new Repository();
        List<Person>persons = new ArrayList<>();
        persons.add(new Person("Baker", "Alan Lan", "+79215847799", "alan@google.com"));
        persons.add(new Person("Clerk", "Andrey Dronov", "+79228561295", "andr.dron@google.com"));
        persons.add(new Person("Dentist", "Ivan Antonov", "+79214526633", "ivan.ant@google.com"));
        //repository.saveAll(persons);
        
        //Получение всех записей таблицы Person по полю jobtitle
        //repository.findPersonByJobtitle("Pharmacist").forEach(System.out::println);
        
        //Получение всех записей таблицы Person
        repository.findAllPerson().forEach(System.out::println);
    }
    
}
