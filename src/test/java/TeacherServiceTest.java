import org.junit.Test;
import org.xuefeng.mssms.service.impl.TeacherServiceImpl;

/**
 * @Author: hanyun.li
 * @Date: 2020/4/16 20:21
 * @Description:
 */
public class TeacherServiceTest {

    @Test
    public void scoreTest(){
        System.out.println(new TeacherServiceImpl().updateScore("2016100001","高数",99.0f));
    }

}
