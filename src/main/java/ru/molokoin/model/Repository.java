package ru.molokoin.model;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

public class Repository {
    private Connection connection = null;
    private Access access = new Access();

    public Repository(){
        getAccess().setDriver("driver");
        getAccess().setHost("host");
        getAccess().setPort("port");
        getAccess().setLogin("login");
        getAccess().setPassword("password");
        getAccess().setLink();
    }

    public Repository(String driver, String host, String port, String login, String password){
        getAccess().setDriver(driver);
        getAccess().setHost(host);
        getAccess().setPort(port);
        getAccess().setLogin(login);
        getAccess().setPassword(password);
        getAccess().setLink();
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

    /**
     * Получение перечня баз данных с подключенного сервера
     * @return
     */
    public ArrayList<String> getBaseList(){
        ResultSet rs =  querry("SHOW DATABASES");
        ArrayList<String> baseList = new ArrayList<>();
        try {
            while (rs.next()){
                String s = rs.getString(1);
                baseList.add(s);
                System.out.println(s);
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return baseList;
    }

    public ArrayList<String> getTablesList(String base){
        System.out.println("Перечень таблиц в базе: " + base);
        ResultSet rs =  querry("SHOW TABLES FROM " + base);
        ArrayList<String> tablesList = new ArrayList<>();
        try {
            while (rs.next()){
                String s = rs.getString(1);
                tablesList.add(s);
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        return tablesList;
    }

    /**
     * Модель данных, для отображения в таблице ReportPane
     * @return
     */
    public CurrentModel getCurrentModel(String base, String table){
        CurrentModel cm = new CurrentModel();
        /**
         * Формируем строку заголовков
         */
        ArrayList<String> headers = new ArrayList<>();
        ResultSet rs =  querry("SHOW COLUMNS FROM " + base + "." + table);
        try {
            while (rs.next()){
                String header = rs.getString(1);
                headers.add(header);
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        cm.setHeaders(headers.toArray(new String[0]));
        System.out.println(Arrays.toString(cm.getHeaders()));

        /**
         * Формируем структуру данных
         */

        rs = querry("SELECT * FROM " + base + "." + table);
        ArrayList<ArrayList<Object>> rows = new ArrayList<>();
        try {
            //проходим по строкам
            while (rs.next()){
                //проходим по ячейкам строки
                ArrayList<Object> cells = new ArrayList<>();
                for(int i = 0; i < headers.size(); i++){
                    cells.add(rs.getString(i+1));
                }
                //добавляем строку к таблице
                rows.add(cells);
            }
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        Object[][] data = new Object[rows.size()][headers.size()];
        /**
         * Заполнение массива данными
         */
        for(int i = 0; i < rows.size(); i++){
            data[i] = (Object[])rows.get(i).toArray();
            System.out.println(Arrays.toString(data[i]));
        }
        cm.setData(data);
        return cm;
    }

}
