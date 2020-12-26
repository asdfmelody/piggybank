package com.example.piggybank;

public class PiggybankData {

    private String caterory;
    private String money;

    public PiggybankData(String caterory,String money){
        this.caterory=caterory;
        this.money=money;
    }

    public String getCategory(){
        return caterory;
    }

    public void setCategory(String caterory){
        this.caterory=caterory;
    }

    public String getMoney(){
        return money;
    }
    public void setMoney(String money){
        this.money=money;
    }

}
