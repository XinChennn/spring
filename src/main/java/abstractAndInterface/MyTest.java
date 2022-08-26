package abstractAndInterface;

/**
 * Created by XinChen on 2022/8/23
 *
 * @Description : TODO    接口和抽象类的区别
 */
public abstract class MyTest {
    // 1.接口可以有构造方法，但抽象类没有
    public MyTest(int b) {
        this.b = b;
    }
    // 2.抽象类中可以有普通成员变量，接口中没有普通成员变量
    private int a;
    private final int b;
    private final static int c = 0;
    // 3. 抽象类中可以包含非抽象的普通方法，接口中的所有方法必须都是抽象的，不能有非抽象的普通方法。
    public void test() {
        System.out.println(" test().. ");
    }
    // 4.抽象类中的抽象方法的访问类型可以是public，protected,
    //   但接口中的抽象方法只能是public类型的，并且默认即为public abstract类型。

    // 5.抽象类中可以包含静态方法，接口中不能包含静态方法
    private static void test1() {
        System.out.println("test1()...");
    }
    // 6.抽象类和接口中都可以包含静态成员变量，
    // 抽象类中的静态成员变量的访问类型可以任意，
    // 但接口中定义的变量只能是public static final类型，并且默认即为public static final类型。
    private static int i;
    // 7. 一个类可以实现多个接口，但只能继承一个抽象类。


    public static void main(String[] args) {
        test1();
    }

}
