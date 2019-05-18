/**
 * @Author: yd
 * @Date: 2019/5/18 10:04
 * @Version 1.0
 */

/*class A implements Cloneable{
    boolean print(int a, int b){}

    @Override
    protected A clone() throws CloneNotSupportedException {
        return (A) super.clone();
    }
}
class B extends A{
    public boolean print(int c, int d){
        return false;
    }

}

abstract class C{
    public C(){

    }
    abstract public void print();
}*/
/*
public class Test {
    public static void main(String[] args) {
        Integer i=128;
        Integer l=128;
        Integer j=new Integer(10);
        System.out.println(i);
        System.out.println(j.intValue());
        System.out.println(i==j);
        System.out.println(i==l);
        String str=String.valueOf(i);
        String string="1233";
        Integer integer=Integer.parseInt(string);
        //如果string有不是数字的字符，会产生NumberFormatException;

    }
}
*/
/*
public class Test{
    public static void main(String[] args) {
        int a=10;
        int b=10;
        int num=a*b;
        System.out.println(num);
        int i='A'+a;
        char c=(char) i;
        char c1=(char)('C'+a);
    }
}*/

/*
public class Test{
    public static void main(String[] args) {
        Hanio(3,'A','B','C');
    }
    public static void Hanio(int count ,char A,char B,char C){
        if(count==1){
            System.out.println("将"+A+"移动到"+C);
        }else{
            Hanio(count-1,A,C,B);
            System.out.println("将"+A+"移动到"+C);
            Hanio(count-1,B,C,A);
        }

    }
}
*/

/*
* 三角数问题
* */
/*
public class Test{
    public static void main(String[] args) {
        System.out.println( tangle(6));
    }
    //1 3 6 10 15 21
    public static int tangle(int count){
        if(count==1){
            return 1;
        }else{
          return   tangle(count-1)+count;
        }
    }
}*/
// 0 1 1 2 3 5 8 13
/*
public class Test{
    public static void main(String[] args) {
        System.out.println( fabcino(5));
    }
    public static int fabcino(int count){
        if(count<=2){
            return 1;
        }else{
            return fabcino(count-1)+fabcino(count-2);
        }

    }
}*/
//阶乘
public class Test{
    public static void main(String[] args) {
        System.out.println(mul(5));
    }
    public static int mul(int count){
        if(count==1){
            return 1;
        }else{
            return count*mul(count-1);
        }

    }
}