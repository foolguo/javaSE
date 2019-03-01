package com.Sigle;

public class Single {
    private static Single single;
    private Single(){
    }
    public static Single getInforce(){
        return single;
    }
}
