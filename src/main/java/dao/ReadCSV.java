package dao;

import java.nio.charset.Charset;
import java.util.ArrayList;

import com.alibaba.fastjson.JSONObject;
import com.csvreader.CsvReader;

public class ReadCSV {

    public static void readCSV() throws Exception {
        String filePath = "src/main/resources/TestData/Data.csv";
        ArrayList<String[]> csvList = new ArrayList<String[]>();
        CsvReader reader = new CsvReader(filePath, ',', Charset.forName("utf-8"));
        reader.readHeaders(); // 跳过表头
        while (reader.readRecord()) {
            csvList.add(reader.getValues()); // 按行读取，并把每一行的数据添加到list集合
        }
        reader.close();
        System.out.println("读取的行数：" + csvList.size());
        System.out.println("读取的列数：" + csvList.get(0).length);

        ArrayList<String> titleList = new ArrayList<String>();
        ArrayList<JSONObject> caseList = new ArrayList<JSONObject>();
        titleList.add("case");
        titleList.add("domain");
        titleList.add("port");
        titleList.add("method");
        titleList.add("api");
        titleList.add("param");
        titleList.add("body");
        JSONObject jsonObject = new JSONObject();
        for (int i = 0; i < csvList.size(); i++) {
            for (int j = 0; j < csvList.get(i).length; j++) {
                // System.out.println(titleList.get(j) + ":" + csvList.get(i)[j]);
                jsonObject.put(titleList.get(j), csvList.get(i)[j]);

            }
            System.out.println(jsonObject);
            caseList.add(jsonObject);
        }
        System.out.println(caseList.get(0));

        // System.out.println(csvList);
        // try {
        // throw new RuntimeException("111111111");
        // } catch (Exception e) {
        // logger.error("请求不到用户接口数据！"+ e.getMessage());
        // request.setAttribute("message", "请求不到用户接口数据！");
        // return "commons/errors";
        // }

    }

    public static void main(String[] args) throws Exception {
        ReadCSV.readCSV();
    }

}