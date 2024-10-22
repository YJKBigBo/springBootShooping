package springbootmvcshopping.sevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootmvcshopping.mapper.LoginMapper;
import springbootmvcshopping.mapper.MemberMapper;

@Service
public class EmailCheckService {
    @Autowired
    LoginMapper loginMapper;

    @Autowired
    MemberMapper memberMapper;

    public Integer execute(String userEmail) {
        return loginMapper.emailCheckSelectOne(userEmail);
    }

    public Integer update(String userEmail) {
        Integer i = loginMapper.emailCheckSelectOne(userEmail);
        int r = 0;
        if(i == 1){
            r = memberMapper.memberEmailCheckUpdate(userEmail);
            return r;
        }
        return i;
    }
}