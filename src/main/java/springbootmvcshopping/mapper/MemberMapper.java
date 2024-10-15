package springbootmvcshopping.mapper;

import org.apache.ibatis.annotations.Mapper;
import springbootmvcshopping.domain.MemberDTO;

import java.util.List;

@Mapper
public interface MemberMapper {
    public void memberInsert(MemberDTO dto);
    public List<MemberDTO> memberSelectList(String searchWord);
}
