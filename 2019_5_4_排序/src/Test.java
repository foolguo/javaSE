import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * @Author: yd
 * @Date: 2019/5/4 13:59
 * @Version 1.0
 */

/*
* 模板方法模式：
* 1.首先适用于核心流程确定，单个步骤有所不同的情况
* 2.一个模板方法：
* 3.java中的模板模式 Lock 体系下的ReentrantLock  模板方法acquire
* 现实生活中的模板方法模式，星巴克咖啡：
*
*/
/*abstract class CoffinDrink{
    public final void drink(){
        brow();
        poil();
        pour();
        if(gouzi()) {
            add();
        }
    }
    public void brow(){
        System.out.println("烧开水");
    }
    public abstract  void poil();
    public void pour(){
        System.out.println("将饮料倒入杯子中");
    }
    public abstract void add();
    public abstract  boolean gouzi();
}
class Tea extends CoffinDrink{

    @Override
    public void poil() {
        System.out.println("浸泡茶叶");
    }

    @Override
    public void add() {
        System.out.println("加柠檬");
    }

    @Override
    public boolean gouzi() {
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入是否要加料y/n");
        String str=scanner.nextLine();

        if(str.equals("y")){
            return true;
        }
        return false;
    }
}
public class Test {
    public static void main(String[] args) {
        Tea tea = new Tea();
        tea.drink();
    }
}*/

/*
* 工厂模式：
* 将解耦放到第三方类中：
* 可以避免，不断增加产品导致客户端一直修改：
* 1.如果将解耦放到主类中，那么如果增加一个商品，呢么就会导致一直修改主客户端
*
* */

/*
interface Computer{
     void buy();
     public default void mai(){

     }
     public static void like(){}
}
class Mac implements Computer{

    @Override
    public void buy() {
        System.out.println("买一个mac");
    }
}
class Surface implements Computer{

    @Override
    public void buy() {
        System.out.println("买一个Surface电脑");
    }
}
class Factory{
    public static Computer getInstance(String str) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
       Computer computer=null;
        Class cls=Class.forName(str);
        computer= (Computer) cls.newInstance();
        return computer;
    }
}
public class Test{
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Computer computer=Factory.getInstance("Surface");
        computer.buy();
    }
}
*/

/*
* 单例模式：
* 1.将构造方法 私有化，通过 static关键字取出实例化对象
*       饿汉单例模式：
* */

/*
class Single{
    private static Single single=new Single();
    private Single(){
    }
    public static Single getSingle(){
        return single;
    }
    public void print(){
        System.out.println("买东西");
    }
}
public class Test{
    public static void main(String[] args) {
        Single single=Single.getSingle();
        single.print();
    }
}
*/
/*

class Emp{
    private String name;
    private  String age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
class EmpAction {
*/
/*    public Object newInstance(String str) throws ClassNotFoundException {
        Object obj=null;
        Class cls=Class.forName(str);
        try {
            obj=cls.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return obj;
    }*//*

    private Emp emp=new Emp();
    public void BeanUtil(String str) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        BeanUtil.BeanUtil(this,str);
    }

    public Emp getEmp() {
        return emp;
    }
}
class BeanUtil{
    public static void BeanUtil(Object obj,String str) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        //emp.name:haha|emp.age:11
        String[] value=str.split("\\|");
        for (int i=0;i<value.length;i++){
            //haha
            String realValue=value[i].split(":")[1];
            //emp
            String realObject=value[i].split(":")[0].split("\\.")[0];
            //name
            String realFiled=value[i].split(":")[0].split("\\.")[1];
         */
/*   System.out.println(realValue);
            System.out.println(realObject);
            System.out.println(realFiled);*//*

            Object realObj=getRealObj(obj,realObject);
            //System.out.println(realObj);
            setValue(realObj,realFiled,realValue);
        }
    }
    */
/*
    * 取得真实操作类：Emp
    * *//*

    public static Object getRealObj(Object obj,String str) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class cls=obj.getClass();
        String name="get"+spellName(str);
        Method method = cls.getMethod(name);
        return method.invoke(obj);

    }
    public static void setValue(Object obj,String realFiled,String realValue) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Class cls=obj.getClass();
        Field field=cls.getDeclaredField(realFiled);
        //System.out.println(field);
        String str="set"+spellName(realFiled);
        Method method=cls.getMethod(str,field.getType());
        //System.out.println(field.getType());
        method.invoke(obj,realValue);
    }
    public static String spellName(String str){
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }
}
public class Test{
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        EmpAction empAction=new EmpAction();
        empAction.BeanUtil("emp.name:haha|emp.age:11");
        System.out.println(empAction.getEmp().toString());
    }
}*/

/*
* 排序算法:
* 交换思想的排序：冒泡，快速排序
* 选择思想的排序：选择排序，堆排序
* 插入思想的排序：直接插入，折半插入，希尔排序
*归并思想：归并排序
*
* */

public class  Test{
    public static void main(String[] args) {
        int[] data=new int[]{
                5,2,4,1,9,7,8
        };
        //bubble(data);
        //insert(data);
        //binaryInsert(data);
        //shell(data);
        //choice(data);
        //mergesort(data);
        quickSort(data);
        for (int i:data){
            System.out.println(i+"、");
        }
    }
    /*
    * 冒泡排序：
    * 基于交换的排序，每一轮排序至少可以保证一个元素到达最终的地方，时间复杂度O（n^2）,空间复杂度O（1），原地排序
    * 稳定排序
    *
    * */
    public static void bubble(int[] data){
        int len=data.length;
        if(len<0){
            return;
        }else{
            for(int i=0;i<len;i++){
                boolean flag= false;
                for (int j=0;j<len-i-1;j++){
                    if (data[j]>data[j+1]){
                        swap(data,j,j+1);
                        flag=true;
                    }
                }
                if(flag==false){
                    break;
                }
            }
        }
    }
    public static void swap(int[] data,int x,int y){
        int temp=data[x];
        data[x]=data[y];
        data[y]=temp;
    }
    /*
    * 插入排序：
    * 1.直接插入排序：
    * 来源：将一个数据插入一个有序序列中，
    *
    * 将序列 分成两块，第一块是有序序列，第二块 无序序列
    * */
    public static void insert(int[] data){
        int len=data.length;
        if(len<0){
            return;
        }else {
            //待排序
            for(int i=1;i<len;i++){
                int j=i-1;
                int value=data[i];
                //已排序
                for(;j>=0;j--){
                    if(value<data[j]){
                        data[j+1]=data[j];
                    }else{
                        break;
                    }
                }
                data[j+1]=value;
        }
    }
    }
    public static void binaryInsert(int[] data){
        int len=data.length;
        if(len<0){
            return;
        }else{
            for (int i=1;i<len;i++){
                int left=0,rigth=i-1;
                int value=data[i];
                while(left<=rigth){
                    int mid=left+(rigth-left)/2;
                    if(value<data[mid]){
                        rigth=mid-1;
                    }
                    if(value>data[mid]){
                        left=mid+1;
                    }
                }
                int j=i-1;
                //1,2,4,5,3,6,7,8,
                //left=0,right=3  mid=1 value =3
                //left=2  mid=2
                //right=1;
                //right+1是要插入的位置，
                for(;j>=rigth+1;j--){
                    data[j+1]=data[j];
                }
                data[j+1]=value;
            }
        }
    }
    public static void shell(int[] data){
        int len=data.length;
        if(len<0){
            return;
        }else{
            for(int step=len/2;step>=1;step=step/2){
                for(int i=step;i<len;i++){
                    int value=data[i];
                    int j=i-step;
                    for (;j>=0;j-=step){
                        if(value<data[j]){
                            data[j+step]=data[j];
                        }else {
                            break;
                        }
                    }
                    data[j+step]=value;
                }
            }

        }
    }
   public static void choice(int[] data){
       int len=data.length;
       if(len==1){
           return;
       }else{
           for(int i=0;i<len-1;i++){
               int min=i;
               for (int j=i+1;j<len;j++){
                   if(data[min]>data[j]){
                       min=j;
                   }
               }
               if(min!=i){
                   swap(data,min,i);
               }
           }

       }
   }
   public static void mergesort(int[] data){
       int len=data.length;
       if(len==1){
           return;
       }else{
           mergeInternal(data,0,len-1);
       }
   }
   public static void mergeInternal(int[] data,int left,int right){
        if(left>=right){
            return;
        }
        int mid=left+(right-left)/2;
        mergeInternal(data,left,mid);
        mergeInternal(data,mid+1,right);
        merge(data,left,right,mid);

    }
    public static void merge(int[] data,int left,int right,int mid){
        int[] temp=new int[right-left+1];
        int i=left;
        int j=mid+1;
        int k=0;
        while(i<=mid&&j<=right){
            if(data[i]<=data[j]) {
                temp[k++]=data[i++];
            }else{
                temp[k++]=data[j++];
            }
        }
        int start=i,end=mid;
        if(j<=right){
            start=i;
            end=right;
        }
        while(start<=end){
            temp[k++]=data[start++];
        }
        for (start=0;start<temp.length;start++){
            data[start+left]=temp[start];
        }
    }
    public static void quickSort(int[] data){
        int len=data.length;
        if(len<0){
            return;
        }else{
            quickSortInternal(data,0,len);
        }
    }
    public static void quickSortInternal(int[] data,int left,int right){
        if(left>=right){
            return;
        }
        int q=partition1(data,left,right);
        quickSortInternal(data,left,q);
        quickSortInternal(data,q+1,right);
    }
    public static int partition1(int[] data,int left,int right){
        int value=data[left];
        int j=left;
        for(int i=left+1;i<=right;i++){
               if(data[i]<value){
                   swap(data,j+1,i);
                   j++;
               }
        }
        swap(data,left,j);
        return j;
    }
    public static int partition2(int[] data,int left,int right){
        int i=left+1,j=right;
        int value=data[left];
        while(true){
            while (value>data[i]&&i<=right)  i++;
            while (value<data[j]&&j>=left+1) j--;
            if(i>j){
                break;
            }
            swap(data,i,j);
            i++;
            j--;
        }
        swap(data,left,j);
        return j;
    }
    public static int partition3(int[] data,int left,int right){
        int i=left+1,gt=right+1,lt=left;
        int value=data[left];
        while(i<gt){
            if(data[i]<value){
                swap(data,i,lt+1);
                i++;
                lt++;
            }else if(data[i]>value){
                swap(data,i,gt-1);
                gt--;
            }else{
                i++;
            }
        }
        swap(data,left,lt);
        return lt;
    }

}