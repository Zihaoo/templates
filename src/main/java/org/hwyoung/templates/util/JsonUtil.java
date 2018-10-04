package org.hwyoung.templates.util;
import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonUtil {

    /**
     * Bean对象转JSON
     */
    public static String beanToJson(Object object, String dataFormatString) {
        if (object != null) {
            if (StringUtils.isEmpty(dataFormatString)) {
                return JSONObject.toJSONString(object);
            }
            return JSON.toJSONStringWithDateFormat(object, dataFormatString);
        } else {
            return null;
        }
    }

    /**
     * Bean对象转JSON
     */
    public static String beanToJson(Object object) {
        if (object != null) {
            return JSON.toJSONString(object);
        } else {
            return null;
        }
    }

    /**
     * string(k,v)转JSON字符串 就是map对象->json
     */
    public static String stringToJsonByFastjson(String key, String value) {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value)) {
            return null;
        }
        Map<String, String> map = new HashMap<String, String>();
        map.put(key, value);
        return beanToJson(map, null);
    }

    /**
     * 将json字符串转换成对象
     */
    public static Object jsonToBean(String json, Object clazz) {
        if (StringUtils.isEmpty(json) || clazz == null) {
            return null;
        }
        return JSON.parseObject(json, clazz.getClass());
    }

    /**
     * json字符串转map
     */
    @SuppressWarnings("unchecked")
    public static Map<String, Object> jsonToMap(String json) {
        if (StringUtils.isEmpty(json)) {
            return null;
        }
        return JSON.parseObject(json, Map.class);
    }

    /**
     * JsonArray[] 转换成 List<T>
     */
    public static <T> List<T> JsonArrayToListBean(String json,Class<T> clazz){
        if(StringUtils.isEmpty(json) || clazz == null ){
            return null;
        }
        return JSON.parseArray(json,clazz);
    }

    /**
     * list<T> 转换成JsonArray[]
     */
    public static <T> String ListBeanToJsonArray(Class<T> clazz){
        if(clazz == null) {
            return null;
        }
        return JSON.toJSONString(clazz);
    }

}

