package test.testCase;

import Interface.com.dao.GetData;
import Interface.com.service.SentRequest;
import org.junit.Test;
import org.testng.Assert;

public class UnitTest {

//  对状态码进行校验
    @Test
    public void unitTest() throws Exception {
        String path = "src/main/resources/case/TestData.json";
        String result = "";

        String url = GetData.get_api_data(path).get("domain").toString() //获取域名
                    + ":"
                    + GetData.get_api_data(path).get("port").toString()  //获取端口号
                    + GetData.get_api_data(path).get("api").toString();   //获取接口名

        String body = GetData.get_api_data(path).get("body").toString(); //获取body

        result = SentRequest.doPost(url, body);
        Assert.assertEquals(result,"200");

    }
}
