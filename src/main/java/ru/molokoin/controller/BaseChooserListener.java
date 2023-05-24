package ru.molokoin.controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import ru.molokoin.model.Repository;
import ru.molokoin.view.Mainframe;

public class BaseChooserListener implements ItemListener{
    private Mainframe mainframe;
    private Repository repository;

    public BaseChooserListener(Mainframe mainframe, Repository repository){
        super();
        this.mainframe = mainframe;
        this.repository = repository;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED){
            System.out.println("Осуществлен выбор базы >> " + e.getItem());
            /**
             * Можно запускать следующие этапы отработки интерфейса
             * - подключение списка таблиц  к TableChooserCombo
             */
            ArrayList<String> tables = repository.getTablesList((String)e.getItem());
            for (String s : tables) {
                System.out.println(s);
            }

            //очистили список таблиц в комбо
            mainframe.getReportPane().getTableChooserCombo().removeAllItems();
            //добавили список таблиц в комбо
            for (String s : tables) {
                mainframe.getReportPane().getTableChooserCombo().addItem(s);
            }
            /**
             * добавили прослушивание событий на элементы комбо
             * - при каждом переключении  базы добавляется новый слушатель!!! (надо добавлять в другом месте)
             */
            mainframe.getReportPane().getTableChooserCombo().addItemListener(new TableChooserListener(mainframe, repository));
            mainframe.pack();
        }
    }
}
