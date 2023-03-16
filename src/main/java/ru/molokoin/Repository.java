package ru.molokoin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Repository {
    private Connection connection = null;
    private Access access = new Access();

    public Repository(){
        getAccess().setLink("link");
        getAccess().setLogin("login");
        getAccess().setPassword("password");
    }

    public Repository(String link, String login, String password){
        getAccess().setLink(link);
        getAccess().setLogin(login);
        getAccess().setPassword(password);
    }
    /**
     * @param access the access to set
     */
    public void setAccess(Access access) {
        this.access = access;
    }
    /**
     * @return the access
     */
    public Access getAccess() {
        return access;
    }
    /**
     * @param connection the connection to set
     */
    public void setConnection(Connection connection) {
        this.connection = connection;
    }
    /**
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }

    /**
     * подключение к базе
     */
    public void connect(){
        System.out.println("Подключение к серверу баз данных ...");
        Connection conn = null;
        try{
            conn = DriverManager.getConnection (getAccess().getLink(), getAccess().getLogin(), getAccess().getPassword());
            System.out.println ("Подключение к серверу баз данных установлено ... ");
        }
        catch (Exception ex){
            System.err.println ("Подключение к серверу баз данных не установлено ... ");
            ex.printStackTrace();
            System.out.println (ex);
        }
        setConnection(conn);
    }
    //отключение от базы
    public void disconnect(){
        if (getConnection() != null){
            try{
                System.out.println("Попытка отключения от базы данных ... ");
                getConnection().close ();
                System.out.println ("Подключение к базе данных завершено. ");
            }
            catch (Exception ex){
                System.out.println ("Подключение к серверу баз данных уже отсутствует.");
                System.out.println (ex);
            }
        }
    }
    public ResultSet querry(String querry){
        ResultSet rs = null;
        try{
            Statement stmt = getConnection().createStatement();
            rs = stmt.executeQuery(querry);
        }
        catch (Exception ex){
            System.err.println ("Подключение к серверу баз данных не установлено ... ");
            ex.printStackTrace();
            System.out.println (ex);
        }
        return rs;
    }

}
