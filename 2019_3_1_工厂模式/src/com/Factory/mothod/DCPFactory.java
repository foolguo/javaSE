package com.Factory.mothod;

public class DCPFactory implements Factory {
        @Override
        public Foundation makeFoundation () {
            return new DCP() ;
        }
    }
