package springbootmvcshopping.mapper;

import org.apache.ibatis.annotations.Mapper;
import springbootmvcshopping.domain.MemberDTO;

@Mapper
public interface MemberMapper {
    public void memberInsert(MemberDTO dto);
}
