package powerTest;

import java.util.List;

/**
 * Created by XinChen on 2022/8/23
 *
 * @Description : TODO
 */
public class MyTest {
    public static void main(String[] args) {
//        // 每秒的钱数
//        double d = 400 / 300;
//        System.out.println("d = " + d);
//        // 时间范围的钱数
//        double v = d * 350;
//        System.out.println("v = " + v);

        try {
            // json转实体类
            List<PowerObject> powerObjects = JsonToCityUtil.readJson();
            System.out.println(powerObjects.size());
            for (int i = 0; i < powerObjects.size(); i++) {
                System.out.println("powerObjects.get(i) = " + powerObjects.get(i));
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void test(int targetPower, int timeConsumed) {
        // 模拟power区间
        int[] ints = {200, 400, 600};
        for (int i = 0; i < ints.length; i++) {
            // 到哪个区间停下，就获取到那个区间的阈值
            if(targetPower < ints[i]) {
                System.out.println("i = " + i);
                System.out.println("ints[i] = " + ints[i]);
                break;
            }
        }



    }
}
