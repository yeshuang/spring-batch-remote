package com.zyl.jpa;

import org.springframework.beans.propertyeditors.PropertiesEditor;

public class Mydomain extends PropertiesEditor {  
    @Override  
    public void setAsText(String text) throws IllegalArgumentException {  

    	MydomainDto m = new MydomainDto();
    	m.setA(text.substring(0,1));
    	m.setB(text.substring(1,2));
        setValue(m);  
    }  
  
    @Override  
    public String getAsText() {  
        return getValue().toString();  
    }  
} 

