package ru.molokoin;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import javax.swing.BoxLayout;
import java.awt.BorderLayout;


public class ConnectionPane extends JPanel{
    //molokoin.ru
    private JLabel hostLabel;
    private JTextField hostField;
    //3306
    private JLabel portLabel;
    private JTextField portField;
    //jdbc:MySQL
    private JLabel driverLabel;
    private JTextField driverField;
    //esoe
    private JLabel loginLabel;
    private JTextField loginField;
    //password
    private JLabel passwordLabel;
    private JPasswordField passwordField;
    //CONNECT
    /**
     * TODO убрать кнопку,
     * сделать попытку подключения по каждому клику в поле
     */
    private JButton connectionButton;
    //BaseChooser
    // private JLabel baseChooserLabel;
    // private JComboBox<String> baseChooserCombo;
    //TableChooser
    // private JLabel tableChooserLabel;
    // private JComboBox<String> tableChooserCombo;


    
    public ConnectionPane(){
        setLayout(new BorderLayout());
        add(getCenterPane(), BorderLayout.CENTER);
        connectionButton = new JButton("CONNECT");
        add(connectionButton, BorderLayout.SOUTH);
    }

    public JPanel getCenterPane(){
        JPanel centerpane = new JPanel();
        centerpane.setLayout(new BoxLayout(centerpane, BoxLayout.Y_AXIS));
        
        hostLabel = new JLabel("Адрес сервера: ");
        hostField = new JTextField("molokoin.ru");
        centerpane.add(Mainframe.duopane(hostLabel, hostField));

        portLabel = new JLabel("Порт: ");
        portField = new JTextField("3306");
        centerpane.add(Mainframe.duopane(portLabel, portField));

        driverLabel = new JLabel("Драйвер: ");
        driverField = new JTextField("jdbc:MySQL");
        centerpane.add(Mainframe.duopane(driverLabel, driverField));

        loginLabel = new JLabel("Пользователь: ");
        loginField = new JTextField("esoe");
        centerpane.add(Mainframe.duopane(loginLabel, loginField));

        passwordLabel = new JLabel("Пароль: ");
        passwordField = new JPasswordField();
        centerpane.add(Mainframe.duopane(passwordLabel, passwordField));

        // baseChooserLabel = new JLabel("Наименование базы: ");
        // baseChooserCombo = new JComboBox();
        // centerpane.add(Mainframe.duopane(baseChooserLabel, baseChooserCombo));

        // tableChooserLabel = new JLabel("Наименование таблицы: ");
        // tableChooserCombo = new JComboBox();
        // centerpane.add(Mainframe.duopane(tableChooserLabel, tableChooserCombo));
        
        return centerpane;
    }
}
