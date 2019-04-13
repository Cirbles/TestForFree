package Interface.com.dao;

import Interface.com.contrl.Common;

import java.util.HashMap;
import java.util.Map;

public class GetData {
    //  读取配置文件重的参数并存入map
    public static Map get_api_data(String path)throws Exception{

        Map map = new HashMap();

        //      从json文件中获取信息
        String domain = Common.getJsonValue(ReadPakegeJson.readJsonFile(path),"domain");
        String port = Common.getJsonValue(ReadPakegeJson.readJsonFile(path),"port");
        String method = Common.getJsonValue(ReadPakegeJson.readJsonFile(path),"method");
        String api = Common.getJsonValue(ReadPakegeJson.readJsonFile(path),"api");
        String param = Common.getJsonValue(ReadPakegeJson.readJsonFile(path),"param");
        String body = Common.getJsonValue(ReadPakegeJson.readJsonFile(path),"body");

        map.put("domain",domain);
        map.put("port",port);
        map.put("method",method);
        map.put("api",api);
        map.put("param",param);
        map.put("body",body);

        return map;
    }
}
