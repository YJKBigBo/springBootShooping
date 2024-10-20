package springbootmvcshopping.service.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootmvcshopping.mapper.AutoNumMapper;
import springbootmvcshopping.mapper.MemberMapper;

@Service
public class MemberDeleteService {
    @Autowired
    AutoNumMapper autoNumMapper;

    @Autowired
    MemberMapper memberMapper;

    public void execute(String memberNums[]){
        autoNumMapper.numsDelete(memberNums, "members", "member_num");
    }
}
