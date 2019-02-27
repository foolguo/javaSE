import java.util.Scanner;

/*public class Test {
    private final int a;
    public Test(){
        a=10;
    }
    public static void main(String[] args) {
        Test t=new Test();

    }
}*/
//工厂设计模式
//1.简单工厂模式
    //1.买这个动作一定是在客户端中进行的，
    //2.工厂类负责生产具体产品
    //4.产品类负责成列产品
/*
interface LipStick{
    void LipStick();
}
class Dior implements LipStick{
    public void LipStick(){
        System.out.println("Dior口红");
    }
}
class FactoryLipStick{
    public static LipStick getInstance(String type){
        if("Dior".equals(type)){
            return new Dior();
        }
        return null;
    }
}
public class Test{
    public void buyLipSticuk(LipStick lip){
        lip.LipStick();
    }
    public static void main(String[] args) {
        Test t=new Test();
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入想要的电脑型号");
        String type=scanner.nextLine();
        //Dior diorlip=;
        LipStick lipStick=FactoryLipStick.getInstance(type);
        t.buyLipSticuk(lipStick);
    }
}*/

//工厂方法模式
//1.一个抽象产品类，多个具体产品类
//2.一个抽象工厂类

/*
interface LipStick{
    void LipStick();
}
class Dior implements LipStick{
    public void LipStick(){
        System.out.println("Dior 999 口红");
    }
}
class YSL implements LipStick{
    public void LipStick(){
        System.out.println("YSL 08口红");
    }
}
interface  FactoryLipStick {
    LipStick creatLipstick();
}
class DiorFactory implements FactoryLipStick{
    public LipStick creatLipstick(){
        return new Dior();
    }
}
class YSLFactory implements FactoryLipStick{
    public LipStick creatLipstick(){
        return new YSL();
    }
}
public class Test{
    public void buyLipStick(LipStick lip){
        lip.LipStick();
    }
    public static void main(String[] args) {
        Test t=new Test();
        FactoryLipStick yslFactory=new YSLFactory();
        t.buyLipStick(yslFactory.creatLipstick());
    }
}*/

//抽象工厂模式




