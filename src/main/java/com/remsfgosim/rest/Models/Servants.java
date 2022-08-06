package com.remsfgosim.rest.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Servants {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;        //Servant ingame id

    @Column
    private String name;    //Servent Name
    
    @Column
    private int rarity;     //Stars
    
    @Column
    private String type;    //Limited, Story, Unsummonable, FP

    @Column
    private String imgLink;

    public long getId(){
        return id;
    }

    public void setId(long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getRarity(){
        return rarity;
    }

    public void setRarity(int rarity){
        this.rarity = rarity;
    }

    public String getType(){
        return type;
    }

    public void setType(String type){
        this.type = type;
    }

    public String getImgLink(){
        return imgLink;
    }

    public void setImgLink(String imgLink){
        this.imgLink = imgLink;
    }
}


