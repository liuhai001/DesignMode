package createType.Singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 类<code>Doc</code>用于：单例模式4：静态内部类，既实现类懒加载，又支持并发；创建实例的安全问题由JVM保证
 *
 * @author liuhai
 * @version 1.0
 * @date 2022-05-03
 */
public class singleton4 {

  private final static AtomicLong id = new AtomicLong(0);

  private singleton4() {
  }

  private static class singleton4Holder {
    private final static singleton4 instance = new singleton4();
  }

  public static singleton4 getInstance() {
    return singleton4Holder.instance;
  }

  public long getId() {
    return id.incrementAndGet();
  }
}
