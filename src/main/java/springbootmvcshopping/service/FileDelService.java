package springbootmvcshopping.service;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import springbootmvcshopping.domain.FileDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class FileDelService {

    public int execute(String orgFile, String storeFile, HttpSession session) {
        // 세션을 사용한 장바구니 알고리즘을 사용하여 파일 삭제, 수정 용도로 사용
        int i = 0;
        FileDTO dto = new FileDTO();
        dto.setOrgFile(orgFile);
        dto.setStoreFile(storeFile);
        Boolean newFile = true;

        //session 생성 여부 확인
        List<FileDTO> list = (List<FileDTO>) session.getAttribute("fileList");
        if(list == null){
            list = new ArrayList<>();
        }

        //session에 있으면 삭제
        for( FileDTO fd : list){
            if(fd.getStoreFile().equals(storeFile)){
                list.remove(fd);
                newFile = false;
                break;
            }
        }
        
        //boolean을 사용하여 이게 삭제인지 삽입인지 판단
        if(newFile){
            list.add(dto);
            i = 1;
        }
        session.setAttribute("fileList", list); //session이 null일때를 위해 사용 오버라이딩 무조건 session이 있으면 적지 않아도 OK
        System.out.println(i);
        return i; //저장 했을때는 i값이 1, 저장되지 않거나 삭제시는 0
    }
}
