package Counter1.MetricsCollector;



/**
 * 类<code>Doc</code>用于：TODO
 *
 * @author liuhai
 * @version 1.0
 * @date 2022-04-16
 */


public class RequestInfo {

  private String apiName;
  private double responseTime;
  private long timestamp;

  public RequestInfo() {
  }

  public RequestInfo(String apiName, double responseTime, long timestamp) {
    this.apiName = apiName;
    this.responseTime = responseTime;
    this.timestamp = timestamp;
  }

  public String getApiName() {
    return apiName;
  }

  public void setApiName(String apiName) {
    this.apiName = apiName;
  }

  public double getResponseTime() {
    return responseTime;
  }

  public void setResponseTime(double responseTime) {
    this.responseTime = responseTime;
  }

  public long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(long timestamp) {
    this.timestamp = timestamp;
  }
}
