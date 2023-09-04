import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.flume.Context;
import org.apache.flume.Event;
import org.apache.flume.interceptor.Interceptor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author mortal
 */
public class MyInterceptor implements Interceptor {
    // 初始化
    @Override
    public void initialize() {

    }



    @Override
    public Event intercept(Event event) {
        // 解析 文本数据变为另一种格式
        byte[] body = event.getBody();
        String content = new String(body);
        // 将一个JSON字符串变为json对象
        JSONObject jsonObject = JSON.parseObject(content);
        // 通过对象 获取json中的值
        String host = jsonObject.getString("host");
        String userId = jsonObject.getString("userId");
        // 通过对象获取json数组
        JSONArray items = jsonObject.getJSONArray("items");
        // 定义一个集合,集合中是map
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        for (Object object: items){
            String obj = object.toString();
            JSONObject jobj = JSON.parseObject(obj);
            String itemType = jobj.getString("itemType");
            String activeTime = jobj.getString("activeTime");
            HashMap<String, String> map = new HashMap<>();
            map.put("activeTime", activeTime);
            map.put("itemType", itemType);
            map.put("host", host);
            map.put("userId", userId);

            list.add(map);
        }
        // 将对象变为字符串
        String s = JSON.toJSONString(list);
        event.setBody(s.getBytes());
        return event;
    }

    // 这个方法调用上面的方法
    @Override
    public List<Event> intercept(List<Event> list) {
        for (int i = 0; i < list.size(); i++) {
            Event oldEvent = list.get(i);
            Event newEvent = intercept(oldEvent);
            list.set(i, newEvent);
        }
        return list;
    }

    @Override
    public void close() {

    }
    // 作用new,一个自定义拦截器的类
    public static class BuilderEvent implements Builder{

        @Override
        public Interceptor build() {
            return new MyInterceptor();
        }

        @Override
        public void configure(Context context) {

        }
    }
}
