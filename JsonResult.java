import java.util.HashMap;
import java.util.Map;

public class JsonResult {


  protected boolean   success;
  protected String    msg;
  protected int       code;
  protected Object    data;
  protected Exception e;

  public JsonResult() {
  }

  public JsonResult(boolean success, String msg) {
    this(success);
    this.msg = msg;
  }

  public JsonResult(boolean success, String msg, int code) {
    this(success, msg);
    this.code = code;
  }

  public JsonResult(boolean success) {
    this();
    this.success = success;
  }

  public boolean getSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public Exception getE() {
    return e;
  }

  public void setE(Exception e) {
    this.e = e;
  }

  public JsonResult put(String key, Object value) {
    if (data == null) {
      data = new HashMap<>();
    }
    ((HashMap) data).put(key, value);
    return this;
  }

  public JsonResult putAll(Map<String, Object> m) {
    if (data == null) {
      data = new HashMap<>();
    }
    ((HashMap) data).putAll(m);
    return this;
  }
}
