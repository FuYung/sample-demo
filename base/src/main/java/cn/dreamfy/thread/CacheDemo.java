package cn.dreamfy.thread;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 缓存
 */
public class CacheDemo {


    Map<String, Object> cache = new HashMap<>();

    ReadWriteLock rwl = new ReentrantReadWriteLock();

    /**
     * 获得数据，缓存
     *
     * @param key key
     * @return Object
     */
    public Object getDate(String key) {
        rwl.readLock().lock();// 读锁
        Object value = null;
        try {
            value = cache.get(key);
            if (value == null) {
                rwl.readLock().unlock(); // 关闭读锁
                rwl.writeLock().lock(); // 开启写锁
                try {
                    if (value == null) { // 双重判断，防止多线程并发时出现数据扰乱
                        value = "a"; //写入(query DB)
                        cache.put(key, value);
                    }
                } finally {
                    rwl.writeLock().unlock();// 写入完成之后关闭写锁
                }
                rwl.readLock().lock();// 开启读锁
            }
        } finally {
            rwl.readLock().unlock();
        }
        return value;
    }
}
