package Counter1.MetricsStorage;

import Counter1.MetricsCollector.RequestInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author liuhai
 * @version 1.0
 * @date 2022-04-16
 */
public class RedisMetricsStorage implements ImetricsStorage {

  //...省略属性和构造函数等...
  @Override
  public void saveRequestInfo(RequestInfo requestInfo) {

  }

  @Override
  public List<RequestInfo> getRequestInfos(String apiName, long startTimestamp, long endTimestamp) {
    return new ArrayList<>();
  }

  @Override
  public Map<String, List<RequestInfo>> getRequestInfos(long startTimestamp, long endTimestamp) {
    return new HashMap<>();
  }
}