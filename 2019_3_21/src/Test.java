///**
// * @Author: yd
// * @Date: 2019/3/21 14:23
// * @Version 1.0
// */
///*interface PrintHelper<T>{
//    void print();
//}
//enum Season {
//    Spring("春天"),Summer("夏天"),Fall("秋"),Winter("冬");
//    private String title;
//    private Season(String title){
//        this.title=title;
//    }
//    public static void print(){
//        System.out.println("haha");
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        Season[] season=Season.values();
//        for(Season i:season){
//            System.out.println(i.ordinal()+ ":"+i.name());
//        }
//        Season.print();
//    }
//}*/
//
///*
//class Season{
//    private static Season Spring=new Season("春");
//    private static Season Summer=new Season("夏");
//    private static Season Fall=new Season("秋");
//    private static Season Winner=new Season("冬");
//    private String title;
//    public Season(String title){
//        this.title=title;
//    }
//    public String toString(){
//        return this.title;
//    }
//    public static Season getInterence(String ch){
//        switch (ch){
//            case "春":return Spring;
//            case "夏":return Summer;
//            case "秋":return Fall;
//            case "冬":return Winner;
//        }
//        return null;
//    }
//}
//
//public class Test{
//    public static void main(String[] args) {
//        Season Spring=Season.getInterence("春");
//        System.out.println(Spring);
//    }
//}
//*/
//
//interface PrintHelper{
//    void print();
//}
//enum Season implements PrintHelper{
//    Spring("春天"),Summer("夏天"),Fall("秋"),Winter("冬");
//    private String title;
//    private Season(String title){
//        this.title=title;
//    }
//    public String toString(){
//        return this.title;
//    }
//
//    @Override
//    public void print() {
//        System.out.println(this.name());
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        Season[] season=Season.values();
//        season[0].print();
//        System.out.println(season[1].toString());
//    }
//}

class Message{
    public static void print(){
        System.out.println("超类的类方法");
    }
    public void print1(){
        System.out.println("子类不覆写");
    }
    public void print2(){
        System.out.println("子类覆写");
    }
}
public class Test extends Message{
    public void print2(){
        print1();
        super.print2();
        System.out.println("子类覆写后");
    }
    public static void main(String[] args) {
        Test t=new Test();
        t.print2();
        Class
    }
}