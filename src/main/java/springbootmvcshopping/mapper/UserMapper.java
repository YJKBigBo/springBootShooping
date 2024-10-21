package springbootmvcshopping.mapper;

import org.apache.ibatis.annotations.Mapper;
import springbootmvcshopping.domain.MemberDTO;

@Mapper
public interface UserMapper {
    public void userInsert(MemberDTO memberDTO);
}
