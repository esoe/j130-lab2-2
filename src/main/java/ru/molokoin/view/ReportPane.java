package ru.molokoin.view;

import javax.swing.BoxLayout;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import ru.molokoin.model.CurrentModel;
import ru.molokoin.model.Repository;

public class ReportPane extends JPanel{
    private Repository repository;

    //BaseChooser
    private JLabel baseChooserLabel;
    private JComboBox<String> baseChooserCombo;
    //TableChooser
    private JLabel tableChooserLabel;
    private JComboBox<String> tableChooserCombo;
    private JButton showButton;
    
    public ReportPane(Repository repository){
        this.repository = repository;
        setLayout(new BorderLayout());
        add(getNorthPane(), BorderLayout.NORTH);
        //add(getCenterPane(new DataModel()));
    }
    public JPanel getNorthPane(){
        JPanel northPane = new JPanel();
        northPane.setLayout(new BoxLayout(northPane, BoxLayout.Y_AXIS));

        baseChooserLabel = new JLabel("Выбор базы данных: ");
        //String[] baseList = repository.getBaseList().toArray(new String[0]);
        baseChooserCombo = new JComboBox<>();
        northPane.add(Mainframe.duopane(baseChooserLabel, baseChooserCombo));

        tableChooserLabel = new JLabel("Выбор таблицы: ");
        tableChooserCombo = new JComboBox<>();
        northPane.add(Mainframe.duopane(tableChooserLabel, tableChooserCombo));
        return northPane;
    }
    public JPanel getCenterPane(CurrentModel model){
        JPanel centerPane = new JPanel();
        JTable table = new JTable(model.getData(), model.getHeaders());
        //Создаем панель прокрутки и включаем в ее состав нашу таблицу
        JScrollPane scroll = new JScrollPane(table);
        table.setFillsViewportHeight(true);
        //Устаналиваем размеры прокручиваемой области
        //table.setPreferredScrollableViewportSize(new Dimension(250, 100));
        //Добавляем в контейнер нашу панель прокрути и таблицу вместе с ней
        centerPane.add(scroll);

        return centerPane;

    }
    public JComboBox<String> getBaseChooserCombo() {
        return baseChooserCombo;
    }
    public JComboBox<String> getTableChooserCombo() {
        return tableChooserCombo;
    }
}