import org.junit.Before;

public class TestUnit {

    @Before // 每次单元测试方法执行前 都会执行该方法 该方法一般存储一些初始化的代码
    public void init(){
        System.out.println("我是开始代码");
    }
}
