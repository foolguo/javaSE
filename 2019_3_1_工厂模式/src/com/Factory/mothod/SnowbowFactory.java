package com.Factory.mothod;

public class SnowbowFactory implements Factory {
    @Override
    public Foundation makeFoundation () {
        return new Snowbow() ;
    }
}
