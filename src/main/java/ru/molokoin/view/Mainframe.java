package ru.molokoin.view;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import ru.molokoin.model.Repository;

/**
 * основная форма приложения просмотра содержимого таблиц баз данных
 */
public class Mainframe extends JFrame{
    private Repository repository;
    private Container contentPane; 
    private ConnectionPane connectionPane;
    private ReportPane reportPane;

    public Mainframe(Repository repository){
        this.repository = repository;
        setTitle("MAINFRAME : table-viewer");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        contentPane = getContentPane();
        connectionPane = new ConnectionPane();
        contentPane.add(connectionPane, BorderLayout.NORTH);
        reportPane = new ReportPane(repository);
        contentPane.add(reportPane, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }

    public static Container duopane (Container first, Container second){
        first.setPreferredSize(new Dimension(200, 20));
        second.setPreferredSize(new Dimension(400, 20));
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
    public void setReportPane(ReportPane reportPane) {
        this.reportPane = reportPane;
    }
    

    



    
}
