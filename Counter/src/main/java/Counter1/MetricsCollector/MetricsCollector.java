package Counter1.MetricsCollector;

import Counter1.MetricsStorage.ImetricsStorage;
import org.apache.commons.lang3.StringUtils;

/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author liuhai
 * @version 1.0
 * @date 2022-04-16
 */

public class MetricsCollector {

  private ImetricsStorage metricsStorage;//基于接口而非实现编程

  //依赖注入
  public MetricsCollector(ImetricsStorage metricsStorage) {
    this.metricsStorage = metricsStorage;
  }

  //用一个函数代替了最小原型中的两个函数
  public void recordRequest(RequestInfo requestInfo) {
    if (requestInfo == null || StringUtils.isBlank(requestInfo.getApiName())) {
      return;
    }
    metricsStorage.saveRequestInfo(requestInfo);
  }
}
