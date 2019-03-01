package com.Factory.simple;

public class Factory {

    public static  LipStick getInfoce(String type){

        if("Dior".equalsIgnoreCase(type)){
            return new Dior();
        }else if("YSL".equalsIgnoreCase(type)){
            return new YSL();
        }
        throw new choiceException("没有要选择的口红");
    }
}
