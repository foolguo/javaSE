package com.Factory.mothod;

public class Client {
    public void buyFoundation(Foundation foundation){
        foundation.typeFoundation();
    }
    public static void main(String[] args) {
        Client client=new Client();
        Foundation snowbow=new Snowbow();
        client.buyFoundation(snowbow);

    }
}
