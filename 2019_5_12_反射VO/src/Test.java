import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: yd
 * @Date: 2019/5/12 20:54
 * @Version 1.0
 */
/*
* 反射VO操作
* */
/*class Emp{
    private String name;
    private String dept;

    public void setName(String name) {
        this.name = name;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                '}';
    }
}
class EmpAction{
    private Emp emp=new Emp();
    public void setValue(String value) throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException, IllegalAccessException, InvocationTargetException {
        BeanUtil.setValue(this,value);
    }

    public Emp getEmp() {
        return emp;
    }
}
class BeanUtil{
    public static void setValue(Object obj,String str) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        //emp.name:果果|emp.dept:学生
        String[] value=str.split("\\|");
        for (int i=0;i<value.length;i++){
            //取得emp对象；
            //设置值
            String realValue=value[i].split(":")[1];
            String field=value[i].split(":")[0].split("\\.")[1];
            String objName=value[i].split("\\.")[0];
            Object realObj=getObj(obj,objName);
                realSetValue(realObj,field,realValue);
        }
    }
    public static Object getObj(Object obj,String name) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class cls=obj.getClass();
        String methodName="get"+init(name);
        Method method=cls.getMethod(methodName);
        return method.invoke(obj);
    }
    public static void realSetValue(Object obj,String filed,String realValue) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class cls=obj.getClass();
        String methodName="set"+init(filed);
        Field field=cls.getDeclaredField(filed);
        Method method=cls.getMethod(methodName,field.getType());
        method.invoke(obj,realValue);

    }
    private static String init(String objName){
        return objName.substring(0,1).toUpperCase()+objName.substring(1);
    }
}
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        EmpAction empAction=new EmpAction();
        empAction.setValue("emp.name:果果|emp.dept:学生");
        System.out.println(empAction.getEmp().toString());
    }
}*/

