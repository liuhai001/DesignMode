package Counter1.Reporter;

import Counter1.AggTools.Aggregator;

import Counter1.AggTools.RequestStat;
import Counter1.MetricsCollector.RequestInfo;
import Counter1.MetricsStorage.ImetricsStorage;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author liuhai
 * @version 1.0
 * @date 2022-04-16
 */

public class ConsoleReporter {
  private ImetricsStorage metricsStorage;
  private ScheduledExecutorService executor;

  public ConsoleReporter(ImetricsStorage metricsStorage) {
    this.metricsStorage = metricsStorage;
    this.executor = Executors.newSingleThreadScheduledExecutor();
  }

  // 第4个代码逻辑：定时触发第1、2、3代码逻辑的执行；
  public void startRepeatedReport(long periodInSeconds, long durationInSeconds) {
    executor.scheduleAtFixedRate(new Runnable() {
      @Override
      public void run() {
        // 第1个代码逻辑：根据给定的时间区间，从数据库中拉取数据；
        long durationInMillis = durationInSeconds * 1000;
        long endTimeInMillis = System.currentTimeMillis();
        long startTimeInMillis = endTimeInMillis - durationInMillis;
        Map<String, List<RequestInfo>> requestInfos =
            metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
        Map<String, RequestStat> stats = new HashMap<>();
        for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
          String apiName = entry.getKey();
          List<RequestInfo> requestInfosPerApi = entry.getValue();
          // 第2个代码逻辑：根据原始数据，计算得到统计数据；
          RequestStat requestStat = Aggregator.aggregate(requestInfosPerApi, durationInMillis);
          stats.put(apiName, requestStat);
        }
        // 第3个代码逻辑：将统计数据显示到终端（命令行或邮件）；
        System.out.println("Time Span: [" + startTimeInMillis + ", " + endTimeInMillis + "]");
        Gson gson = new Gson();
        System.out.println(gson.toJson(stats));
      }
    }, 0, periodInSeconds, TimeUnit.SECONDS);
  }
}
