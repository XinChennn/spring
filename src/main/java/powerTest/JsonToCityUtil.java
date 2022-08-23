package powerTest;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class JsonToCityUtil {
    private JsonToCityUtil() {
    }

    private static JsonToCityUtil jsonToCityUtil;

    public static JsonToCityUtil getInstance() {
        if (jsonToCityUtil == null) {
            jsonToCityUtil = new JsonToCityUtil();
        }
        return jsonToCityUtil;
    }


    public static List<PowerObject> readJson() throws Exception {
        List<PowerObject> list = new ArrayList<>();
        // 读取 json 文件
        File file = ResourceUtils.getFile("/Volumes/XDISK/JAVA/xinhuiDuo/spring/src/main/java/test/power.json");
        //  System.out.println(file);
        String jsonData = jsonRead(file);
        //System.out.println(jsonData);
        JSONArray array = JSONArray.parseArray(jsonData);
        // System.out.println(array);
        for (int i = 0; i < array.size(); i++) {
            JSONObject jsonObject2 = array.getJSONObject(i);
            //  System.out.println(jsonObject2);
            int time = jsonObject2.getInteger("time");
            double money = jsonObject2.getDouble("money");
            int power = jsonObject2.getInteger("power");

            // 把 读取到 jsonObject2  弄成一个个的对象
            PowerObject powerObject = new PowerObject();
            powerObject.setTime(time);
            powerObject.setMoney(money);
            powerObject.setPower(power);
//            System.out.println(powerObject);
            list.add(powerObject);  // 把对象 放到了集合中..
        }
        return list;
    }


    private static String jsonRead(File file) {
        FileInputStream is = null;
        StringBuilder stringBuilder = null;
        try {
            /**
             * 文件有内容才去读文件
             */
            is = new FileInputStream(file);
            InputStreamReader streamReader = new InputStreamReader(is, "utf-8");
            BufferedReader reader = new BufferedReader(streamReader);
            String line;
            stringBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                // stringBuilder.append(line);
                stringBuilder.append(line);
            }
            reader.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return String.valueOf(stringBuilder);
    }

}
