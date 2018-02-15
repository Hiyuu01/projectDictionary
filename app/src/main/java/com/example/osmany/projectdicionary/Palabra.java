package com.example.osmany.projectdicionary;

import java.io.Serializable;

/**
 * Created by Osmany on 15/02/2018.
 */

public class Palabra implements Serializable{
   private String name;
    private String sinon1;
    private String sinon02;

    public Palabra(String name){
        this.name=name;
        sinon1="";
        sinon02="";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinon1() {
        return sinon1;
    }

    public void setSinon1(String sinon1) {
        this.sinon1 = sinon1;
    }

    public String getSinon02() {
        return sinon02;
    }

    public void setSinon02(String sinon02) {
        this.sinon02 = sinon02;
    }

}
