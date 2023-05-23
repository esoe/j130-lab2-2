package ru.molokoin;

import java.sql.ResultSet;
import java.sql.SQLException;

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
        mainframe.getConnectionPane().getConnectionButton().addActionListener(e -> {
            /**
             * Вывод учетных данных в консоль
             */
            String driver = mainframe.getConnectionPane().getDriverField().getText();
            String host = mainframe.getConnectionPane().getHostField().getText();
            String port = mainframe.getConnectionPane().getPortField().getText();
            String login = mainframe.getConnectionPane().getLoginField().getText();
            String password = String.valueOf(mainframe.getConnectionPane().getPasswordField().getPassword());

            System.out.println("Попытка подключения к базе данных >>");
            System.out.println("driver: " + driver);
            System.out.println("host: " + host);
            System.out.println("port: " + port);
            System.out.println("login: " + login);
            System.out.println("password: " + password);

            repository = new Repository(driver, host, port, login, password);
            repository.connect();
            //список баз в консоль
            ResultSet rs =  repository.querry("SHOW DATABASES");
            try {
                while (rs.next()){
                    System.out.println(rs.getString(1));
                }
            } catch (SQLException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            // далее ... можно открывать форму отчета (ReportPane) и листать базы и таблицы сервера
        });
    }

    public static void main( String[] args ){
        System.out.println("Приложение j130-2, для просмотра содержимого баз данных запущено ...");
        new App();
    }
    
    
}