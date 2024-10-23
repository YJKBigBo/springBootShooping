package springbootmvcshopping.service.myPage;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import springbootmvcshopping.domain.AuthInfoDTO;
import springbootmvcshopping.domain.EmployeeDTO;
import springbootmvcshopping.mapper.EmployeeMyInfoMapper;

import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeInfoService {
    @Autowired
    EmployeeMyInfoMapper employeeMyInfoMapper;

    public Map<String, Object> execute(HttpSession session, Model model) {
        Map<String, Object> map = new HashMap<String, Object>();
        AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
        EmployeeDTO dto = employeeMyInfoMapper.employeeSelectOne(auth.getUserId());
        model.addAttribute("employeeCommand", dto);
        map.put("employeeCommand", dto);
        return map;
    }
}
