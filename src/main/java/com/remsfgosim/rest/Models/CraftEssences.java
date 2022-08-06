package com.remsfgosim.rest.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CraftEssences {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;            //CE id

    @Column
    private String name;        //CE name
    
    @Column
    private int rarity;         //4 or 5 stars
    
    @Column
    private String type;        //Limited, story, unsummonable,

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
    
