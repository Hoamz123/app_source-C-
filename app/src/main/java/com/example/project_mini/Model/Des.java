package com.example.project_mini.Model;

public class Des {
    private  String name;
    private String complexity;
    private int img;

    public Des(String name,String complexity,int img){
        this.complexity = complexity;
        this.name = name;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }

    public String getComplexity() {
        return complexity;
    }
}
