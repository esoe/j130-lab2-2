package ru.molokoin;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * основная форма приложения просмотра содержимого таблиц баз данных
 */
public class Mainframe extends JFrame{
    private Container contentPane; 
    private ConnectionPane connectionPane;
    private ReportPane reportPane;

    public Mainframe(){
        setTitle("MAINFRAME : table-viewer");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        contentPane = getContentPane();
        connectionPane = new ConnectionPane();
        contentPane.add(connectionPane, BorderLayout.WEST);
        reportPane = new ReportPane();
        contentPane.add(reportPane, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }

    public static Container duopane (Container first, Container second){
        first.setPreferredSize(new Dimension(150, 20));
        second.setPreferredSize(new Dimension(300, 20));
        Container pane = new JPanel();
        pane.setLayout(new BoxLayout(pane, BoxLayout.X_AXIS));
        pane.add(first);
        pane.add(second);
        return pane;
    }

    // public Container getContentPane() {
    //     return contentPane;
    // }

    public ConnectionPane getConnectionPane() {
        return connectionPane;
    }

    public ReportPane getReportPane() {
        return reportPane;
    }
    

    



    
}
