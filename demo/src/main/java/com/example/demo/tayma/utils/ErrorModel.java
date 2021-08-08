package com.example.demo.tayma.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorModel {
    private String message ;
    public ErrorModel(String message){
        this.message=message ;
    }

}
