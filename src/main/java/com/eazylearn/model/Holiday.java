package com.eazylearn.model;

import lombok.Data;

@Data
public class Holiday {
    private String day;
    private String reason;
    private Type type;
    
    public enum Type {
    	FESTIVAL,FEDERAL
    }
}
