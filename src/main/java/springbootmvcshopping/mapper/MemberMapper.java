package springbootmvcshopping.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import springbootmvcshopping.domain.MemberDTO;
import springbootmvcshopping.domain.StartEndPageDTO;

import java.util.List;

@Mapper
public interface MemberMapper {
    public void memberInsert(MemberDTO dto);
    public List<MemberDTO> memberSelectList(StartEndPageDTO sepDTO);
    public Integer memberCount();

}
