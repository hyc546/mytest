package Account;

import com.SZ.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration("classpath:appContext.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class TTest {
    @Autowired
    private AccountService accountService;

    @Test
    public void test(){
        accountService.transfer("小王","德华", 200);
    }
}
