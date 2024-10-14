package springbootmvcshopping.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import springbootmvcshopping.mapper.AutoNumMapper;

@Service
public class AutoNumService {
    @Autowired
    AutoNumMapper autoNumMapper;

    public void execute(Model model, String sep, String columnName, Integer len, String tableName) {
        String autoNum = autoNumMapper.autoNumSelect(sep, columnName, len, tableName);
        model.addAttribute("autoNum", autoNum);
    }
}
