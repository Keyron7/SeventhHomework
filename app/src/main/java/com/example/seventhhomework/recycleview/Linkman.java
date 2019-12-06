package com.example.seventhhomework.recycleview;


public class Linkman{
    private String name;
    private String time;
    private String number;
    private int img;
    public Linkman(String name,String time,String number,int img){
        this.name=name;
        this.time=time;
        this.number=number;
        this.img=img;
    }

    int getImg() {
        return img;
    }

    String getName() {
        return name;
    }

    String getNumber() {
        return number;
    }

    String getTime() {
        return time;
    }


    public String toString(){
        return "name"+name+"time"+time;
    }
}
