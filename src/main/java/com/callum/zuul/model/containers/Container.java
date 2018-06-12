package com.callum.zuul.model.containers;

/**
 * Created by callummarriage on 12/06/2018.
 */
public class Container {

    private String description;

    private Integer number;

    private String name;


    public Container(String name, String description, Integer number){
        this.description = description;
        this.name = name;
        this.number = number;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

}
