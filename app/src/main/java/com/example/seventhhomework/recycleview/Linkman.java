package com.example.seventhhomework.recycleview;
public class Linkman{
    public String name;
    public String time;
    public Linkman(){}
    public Linkman(String name,String time){
        this.name=name;
        this.time=time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String toString(){
        return "name"+name+"time"+time;
    }
}
