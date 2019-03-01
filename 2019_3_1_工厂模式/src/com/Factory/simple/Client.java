package com.Factory.simple;

import java.util.Scanner;

public class Client {
    public void buyLipStick(LipStick lip){
        lip.lipStick();
    }
    public static void main(String[] args) {
        Client client=new Client();
        Scanner s=new Scanner(System.in);
        System.out.println("请输入您要选择的口红");
        String type=s.nextLine();
       client.buyLipStick( Factory.getInfoce(type));
    }
}
