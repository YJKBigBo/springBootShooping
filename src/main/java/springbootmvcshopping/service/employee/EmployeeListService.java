package springbootmvcshopping.service.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import springbootmvcshopping.domain.EmployeeDTO;
import springbootmvcshopping.domain.MemberDTO;
import springbootmvcshopping.domain.StartEndPageDTO;
import springbootmvcshopping.mapper.EmployeeMapper;
import springbootmvcshopping.service.StartEndPageService;

import java.util.List;

@Service
public class EmployeeListService {
    @Autowired
    StartEndPageService startEndPageService;
    @Autowired
    EmployeeMapper employeeMapper;

    public void execute(String searchWord, Integer page, Model model) {
        // 한 페이지에 몇개를 보여줄 것인가
        Integer limit = 3;

        StartEndPageDTO sepDTO = startEndPageService.execute(page,limit,searchWord);

        Integer count = employeeMapper.employeeCount();

        List<EmployeeDTO> list = employeeMapper.employeeSelectList(sepDTO);

        startEndPageService.execute(page, limit, count, searchWord, list, model);
    }

}
