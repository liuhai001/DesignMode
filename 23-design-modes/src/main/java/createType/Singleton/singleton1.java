package createType.Singleton;

import java.util.concurrent.atomic.AtomicLong;
import java.lang.Math;
import java.lang.Runtime;

/**
 * 类<code>singleton1</code>用于：单例模式1：饿汉式，需要用时已经初始化好，没有线程安全问题。
 * 不支持延迟加载
 * @author liuhai
 * @version 1.0
 * @date 2022-05-03
 */
public class singleton1 {

  private final AtomicLong id = new AtomicLong(0);
  private static final singleton1 instance = new singleton1();

  private singleton1() {
  }

  public static singleton1 getInstance() {
    return instance;
  }

  public long getId() {
    return id.incrementAndGet();
  }
}