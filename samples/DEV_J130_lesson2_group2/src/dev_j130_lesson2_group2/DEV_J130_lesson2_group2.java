/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev_j130_lesson2_group2;

import java.util.Set;

/**
 *
 * @author denis
 */
public class DEV_J130_lesson2_group2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Repository repository = new Repository();
        //Выборка всех персон из БД
        repository.findAllPerson().forEach(e -> {
            System.out.println(e);
            e.getDomains().forEach(System.out::println);
        });
        
        //Выборка всех персон из БД по их специальности
        //repository.findPersonByFirstname("Biologist").forEach(System.out::println);
        
        //Создаем новую персону и сохраняем её в БД
        //Person person = new Person("Biologist", "Andry Gobonov", "+79215847877", "gab@ya.ru");
        //repository.save(person);
        
        //Выборка всех доменов
//        Set<Domain> domains = repository.findAllDomain();
//        domains.forEach(e -> {
//            System.out.println(e);
//            System.out.println("    " + e.getPerson());
//        });
    }
    
}
