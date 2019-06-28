package Interface.com.contrl;
import com.alibaba.fastjson.JSONObject;

public class Common {
    /**
     * 解析Json内容
     * @return JsonValue 返回JsonString中JsonId对应的Value
     *
     **/
    public static String getJsonValue(String JsonString, String JsonId){
        JSONObject jsonObject = new JSONObject();
        JSONObject value = (JSONObject) jsonObject.parse(JsonString);
        String body = value.get(JsonId).toString();
        return body;
    }
}
