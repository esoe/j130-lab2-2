package ru.molokoin;

import ru.molokoin.controller.BaseChooserListener;
import ru.molokoin.controller.ConnectionButtonListener;
import ru.molokoin.model.Repository;
import ru.molokoin.view.Mainframe;

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
        /**
         * Формируем представление
         * - передаем модель (data-model, для представления таблиц в report-pane)
         */
        mainframe = new Mainframe(repository);
        /**
         * Добавляем контроллеры
         * - передаем представление и модель (repository, для доступа к данным)
         */
        mainframe.getConnectionPane().getConnectionButton().addActionListener(new ConnectionButtonListener(mainframe, repository));
        
    }

    public static void main( String[] args ){
        System.out.println("Приложение j130-2, для просмотра содержимого баз данных запущено ...");
        new App();
    }
    
    
}