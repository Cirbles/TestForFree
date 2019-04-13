package ReadCsv;

import java.awt.List;
import java.nio.charset.Charset;
import java.util.ArrayList;

import com.alibaba.fastjson.JSONObject;
import com.csvreader.CsvReader;

public class ReadCsvFile {

	public static ArrayList readCsvFile(String filePath) throws Exception {
		// TODO Auto-generated constructor stub
		ArrayList<String[]> csvList = new ArrayList<String[]>();
		CsvReader reader = new CsvReader(filePath,',',Charset.forName("utf-8"));
		reader.readHeaders(); //跳过表头
		while(reader.readRecord()){
            csvList.add(reader.getValues()); //按行读取，并把每一行的数据添加到list集合
        }
		reader.close();
        System.out.println("读取的行数："+csvList.size());
        System.out.println("读取的列数："+csvList.get(0).length);
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
        		jsonObject.put(titleList.get(j), csvList.get(i)[j]);
        		
			}
        	caseList.add(jsonObject);
		}

        return csvList;
	}
	
	public static void main(String[] args) throws Exception {
		String filePath = "src/main/resources/TestData/Data.csv";
        readCsvFile(filePath);
	}

}
