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
        // mainframe.getConnectionPane().getConnectionButton().addActionListener(e -> {
        //     /**
        //      * Вывод учетных данных в консоль
        //      */
        //     String driver = mainframe.getConnectionPane().getDriverField().getText();
        //     String host = mainframe.getConnectionPane().getHostField().getText();
        //     String port = mainframe.getConnectionPane().getPortField().getText();
        //     String login = mainframe.getConnectionPane().getLoginField().getText();
        //     String password = String.valueOf(mainframe.getConnectionPane().getPasswordField().getPassword());

        //     System.out.println("Попытка подключения к базе данных >>");
        //     System.out.println("driver: " + driver);
        //     System.out.println("host: " + host);
        //     System.out.println("port: " + port);
        //     System.out.println("login: " + login);
        //     System.out.println("password: " + password);
        //     //repository = new Repository(null, null, null, null, null);

        // });
    }

    public static void main( String[] args ){
        System.out.println("Приложение j130-2, для просмотра содержимого баз данных запущено ...");
        new App();
    }
    
    
}