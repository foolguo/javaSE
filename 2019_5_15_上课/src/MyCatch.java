import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: yd
 * @Date: 2019/5/15 20:54
 * @Version 1.0
 */
/*缓存
* HashMap+读写锁=缓存
*
* */
/*
public class MyCatch {
    private HashMap<Integer,String> hashMap=new HashMap<>();
    private ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.WriteLock writeLock=lock.writeLock();
    private ReentrantReadWriteLock.ReadLock readLock=lock.readLock();
    public void putVal(Integer integer,String s){
        writeLock.lock();
        hashMap.put(integer,s);
    }
    public void get(Integer integer){
        readLock.lock();
        hashMap.get(integer);
    }
}

*/

