package createType.Singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 类<code>Doc</code>用于：单例模式2：懒汉式，延迟加载，因为有加锁，并发度为1，性能比较低
 *
 * @author liuhai
 * @version 1.0
 * @date 2022-05-03
 */
public class singleton2 {

  private final AtomicLong id = new AtomicLong(0);
  private static singleton2 instance;

  private singleton2() {
  }

  public static synchronized singleton2 getInstance() {//类级别锁
    if (instance == null) {
      instance = new singleton2();
    }
    return instance;
  }

  public long getId() {
    return id.incrementAndGet();
  }
}