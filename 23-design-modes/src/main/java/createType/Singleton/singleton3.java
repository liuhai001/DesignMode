package createType.Singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 类<code>Doc</code>用于：单例模式3：双重检测，支持懒加载，又支持高并发
 *
 * @author liuhai
 * @version 1.0
 * @date 2022-05-03
 */
public class singleton3 {

  private final AtomicLong id = new AtomicLong(0);
  private static volatile singleton3 instance;

  private singleton3() {
  }

  public static singleton3 getInstance() {
    if (instance == null) {
      synchronized (singleton3.class) { //类级别锁
        if (instance == null) {
          instance = new singleton3();
        }
      }
    }
    return instance;
  }

  public long getId() {
    return id.incrementAndGet();
  }
}
