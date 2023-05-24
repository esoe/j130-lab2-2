package ru.molokoin.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;

import ru.molokoin.model.Repository;
import ru.molokoin.view.Mainframe;
import ru.molokoin.view.ReportPane;

public class ConnectionButtonListener implements ActionListener{
    private Mainframe mainframe;
    private Repository repository;

    public ConnectionButtonListener(Mainframe mainframe, Repository repository){
        super();
        this.mainframe = mainframe;
        this.repository = repository;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
            // 
            /**
             * далее ... можно открывать форму отчета (ReportPane) и листать базы и таблицы сервера
             * 
             */
            //очистили устаревший список баз в комбо
            mainframe.getReportPane().getBaseChooserCombo().removeAllItems();

            //добавили список баз в комбо
            for (String s : baseList) {
                mainframe.getReportPane().getBaseChooserCombo().addItem(s);
            }
            //добавили прослушивание событий на элементы комбо
            mainframe.getReportPane().getBaseChooserCombo().addItemListener(new BaseChooserListener(mainframe, repository));
            mainframe.pack();
    }
    
}
