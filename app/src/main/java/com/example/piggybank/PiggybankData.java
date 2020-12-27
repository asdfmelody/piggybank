package com.example.piggybank;

public class PiggybankData {

    private String caterory;
    private int money;
    private String date;

    public PiggybankData(String caterory,int money,String date){
        this.caterory=caterory;
        this.money=money;
        this.date=date;
    }

    public PiggybankData(String caterory,String date){
        this.caterory=caterory;
        this.money=0;
        this.date=date;
    }


    public String getCategory(){
        return caterory;
    }

    public void setCategory(String caterory){
        this.caterory=caterory;
    }

    public int getMoney(){
        return money;
    }
    public void setMoney(int money){
        this.money=money;
    }


    public String getDate(){
        return date;
    }
    public void setDate(String date){
        this.date=date;
    }
}
