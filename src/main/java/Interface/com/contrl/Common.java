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


//        JsonParser jp = new JsonParser();
//        JsonObject jo = jp.parse(JsonString).getAsJsonObject();
//        JSONObject jsonObject = JSONObject.parseObject(JsonString);
//        String body = "";
//        if (JsonId.equals("body")){
//            body = jsonObject.getString(JsonId);
//        }else{
//            body = jo.get(JsonId).getAsString();
//        }
//
//        return body;
    }

//    public static void main( String[] args ) throws Exception {
//        String str = ReadPakegeJson.readJsonFile("src/main/resources/case/TestData.json");
//        System.out.println(str);
//        JSONObject jsonObject = new JSONObject();
//        JSONObject value = (JSONObject) jsonObject.parse(str);
//        System.out.println(value);
//        System.out.println(value.get("body"));
//
//
//    }
    
}
