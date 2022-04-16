package Counter1;

import Counter1.MetricsCollector.MetricsCollector;
import Counter1.MetricsCollector.RequestInfo;
import Counter1.MetricsStorage.ImetricsStorage;
import Counter1.MetricsStorage.RedisMetricsStorage;
import Counter1.Reporter.ConsoleReporter;
import Counter1.Reporter.EmailReporter;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author liuhai
 * @version 1.0
 * @date 2022-04-16
 */

public class Demo {

  public static void main(String[] args) {
    ImetricsStorage storage = new RedisMetricsStorage();
    ConsoleReporter consoleReporter = new ConsoleReporter(storage);
    consoleReporter.startRepeatedReport(60, 60);

    EmailReporter emailReporter = new EmailReporter(storage);
    emailReporter.addToAddress("wangzheng@xzg.com");
    emailReporter.startDailyReport();

    MetricsCollector collector = new MetricsCollector(storage);
    collector.recordRequest(new RequestInfo("register", 123, 10234));
    collector.recordRequest(new RequestInfo("register", 223, 11234));
    collector.recordRequest(new RequestInfo("register", 323, 12334));
    collector.recordRequest(new RequestInfo("login", 23, 12434));
    collector.recordRequest(new RequestInfo("login", 1223, 14234));

    try {
      Thread.sleep(100000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
