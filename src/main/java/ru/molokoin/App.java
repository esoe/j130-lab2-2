package ru.molokoin;

/**
 * Основной класс сборки приложения,
 * для просмотра содержимого таблиц базы данных
 * 
 */
public class App {
    private Repository repository;
    private Mainframe mainframe;
    public App(){
        init();
    }
    /**
     * 
     */
    private void init() {
        mainframe = new Mainframe();
    }

    public static void main( String[] args ){
        System.out.println("Просмотр содержимого баз данных ...");
        new App();
    }
    
    
}