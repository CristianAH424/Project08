package com.example.projecto08.models;

import android.widget.TableRow;

public class cardboard {
    private final String SERIAL;
    private int quantity,price,total;
    private String month, idUser;

    public cardboard(String SERIAL, int quantity, int price, String month, int total, String idUser) {
        this.SERIAL = SERIAL;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
        this.month = month;
        this.idUser = idUser;




    }



    public String getSERIAL() {
        return SERIAL;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }


}
