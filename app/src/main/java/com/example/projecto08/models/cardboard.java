package com.example.projecto08.models;

public class cardboard {
    private final String SERIAL;
    private int quantity,price,total;
    private String month, idUser,material;

    public cardboard(String SERIAL, int quantity, int price, int total, String month, String idUser,String material) {
        this.SERIAL = SERIAL;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
        this.month = month;
        this.idUser = idUser;
        this.material= material;



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


    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getIdUser() {
        return idUser;
    }

    public String getMaterial(){return material;}

}
