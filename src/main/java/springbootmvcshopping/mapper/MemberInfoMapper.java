package springbootmvcshopping.mapper;

import org.apache.ibatis.annotations.Mapper;
import springbootmvcshopping.domain.MemberDTO;

@Mapper
public interface MemberInfoMapper {
    public MemberDTO memberSelectOne(String memberId);
    public Integer memberUpdate(MemberDTO dto);
}
