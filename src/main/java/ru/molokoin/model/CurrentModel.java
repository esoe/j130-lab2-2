package ru.molokoin.model;

import java.util.Arrays;

public class CurrentModel {
    //Массив содержащий заголоки таблицы
    private Object[] headers = { "Name", "Surname", "Telephone" };

    //Массив содержащий информацию для таблицы
    private Object[][] data = {
        { "John", "Smith", "1112221" },
        { "Ivan", "Black", "2221111" },
        { "George", "White", "3334444" },
        { "Bolvan", "Black", "2235111" },
        { "Serg", "Black", "2221511" },
        { "Pussy", "Black", "2221111" },
        { "Tonya", "Red", "2121111" },
        { "Elise", "Green", "2321111" },
    };

    public Object[] getHeaders() {
        return headers;
    }

    public void setHeaders(Object[] headers) {
        this.headers = headers;
    }

    public Object[][] getData() {
        return data;
    }

    public void setData(Object[][] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CurrentModel [headers=" + Arrays.toString(headers) + ", data=" + Arrays.toString(data) + "]";
    }
    
    
    
}
