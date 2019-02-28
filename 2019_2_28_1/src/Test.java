        /*　①、如何插入一条新的数据项

        　　②、如何寻找某一特定的数据项

        　　③、如何删除某一特定的数据项

        　　④、如何迭代的访问各个数据项，以便进行显示或其他操作
*//*
class MyArray{
            private int[] array;
            private Integer elems;//实际长度
            private Integer length;//最大长度
             public MyArray(){
                 length=10;
                array=new int[length];
                elems=0;
            }
            public MyArray(int length){
                 this.length=length;
                 array=new int[length];
                 this.elems=0;
            }
            //获取数组有效长度
            public int getLength(){
                 return elems;
            }
            //添加元素
            public  void add(int data){
                if(ifFull()){
                    System.out.println("该数组已满");
                    return ;
                }
                array[elems++]=data;
            }
            //判断数组是否已满
            public boolean ifFull(){
                 if(elems==length-1){
                     return true;
                 }
                 return false;
            }
            public boolean ifEmpty(){
                 if(elems==0){
                     return true;
                 }
                 return false;
            }
            //删除元素
            public void delete(int value){
                    int temp=find(value);
                    if(temp==-1){
                        return ;
                    }else if(temp==length-1){
                        elems--;
                    }else{
                        for(int i=temp;i<elems-1;i++){
                            array[i]=array[i+1];
                        }
                        elems--;
                    }

            }
            //查找元素
            public int find(int value){
                 for(int i=0;i<elems;i++){
                     if(array[i]==value){
                         return i;
                     }
                 }
                 return -1;
            }
            //修改元素void
            public boolean motify(int olddata,int newdata){
                int k=find(olddata);
                if(k==-1){
                    System.out.println("此元素不存在");
                    return false;
                }else{
                    array[k]=newdata;
                    return true;
                }

            }
            public void display(){
                 for(int i=0;i<elems;i++){
                     System.out.print(array[i]+" ");
                 }
                System.out.println();
            }
}
public class Test {
    public static void main(String[] args) {
        MyArray array=new MyArray(5);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.display();
        array.delete(1);
        array.display();

    }
}*/
