package ru.molokoin.controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JPanel;

import ru.molokoin.model.Repository;
import ru.molokoin.view.Mainframe;
/**
 * Обработка события:
 * - осуществлен выбор таблицы
 */
public class TableChooserListener implements ItemListener{
    private Mainframe mainframe;
    private Repository repository;
    private String current;

    public TableChooserListener(Mainframe mainframe, Repository repository){
        super();
        this.mainframe = mainframe;
        this.repository = repository;
        current = "";

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED){
            System.out.println("Осуществлен выбор таблицы >> " + e.getItem());
            if ((String)e.getItem() != current){
                /**
                 * Можно запускать следующие этапы отработки интерфейса
                 * - отрисовку выбранной таблицы в jTable
                 * - проще запустить новое окно с моделью таблицы
                 */
                int index = mainframe.getReportPane().getComponentCount() -1;
                if (index > 0){
                    JPanel panel = (JPanel)mainframe.getReportPane().getComponent(index);
                    mainframe.getReportPane().remove(panel);
                    mainframe.getReportPane().add(
                        mainframe.getReportPane().getCenterPane(
                            repository.getCurrentModel(
                                (String)mainframe.getReportPane().getBaseChooserCombo().getSelectedItem(),
                                (String)mainframe.getReportPane().getTableChooserCombo().getSelectedItem()
                    )));

                    mainframe.pack();
                }
                else{
                    mainframe.getReportPane().add(
                        mainframe.getReportPane().getCenterPane(
                            repository.getCurrentModel(
                                (String)mainframe.getReportPane().getBaseChooserCombo().getSelectedItem(),
                                (String)mainframe.getReportPane().getTableChooserCombo().getSelectedItem()
                    )));

                    mainframe.pack();
                }
                
                current = (String)e.getItem();
            }
        }
    }
}
