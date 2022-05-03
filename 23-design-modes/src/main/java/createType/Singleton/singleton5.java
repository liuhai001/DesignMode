package createType.Singleton;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 类<code>Doc</code>用于：单例模式5：枚举类实现单例，利用java枚举类本身的特性，保证了实例的唯一和安全性；
 *
 * @author liuhai
 * @version 1.0
 * @date 2022-05-03
 */
public enum singleton5 {
  INSTANCE;
  private final static AtomicLong id = new AtomicLong(0);

  public long getId() {
    return id.incrementAndGet();
  }
}
