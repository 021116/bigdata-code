import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestUnit {

    @Before // 每次单元测试方法执行前 都会执行该方法 该方法一般存储一些初始化的代码
    public void init(){
        System.out.println("我是开始代码");
    }
    @After  // 每次单元测试方法执行后都会执行该方法 该方法一般都是存放一些连接关闭等收尾工作
    public void destory(){
        System.out.println("我是结束代码");
    }
    @Test   // 该方法即一个单元测试方法，这个方法是一个独立的方法，类似于Main方法
    public void testA(){
        System.out.println("Hello World!");
    }

    @Test
    public void testB(){
        System.out.println("Hello World!");
    }
}
