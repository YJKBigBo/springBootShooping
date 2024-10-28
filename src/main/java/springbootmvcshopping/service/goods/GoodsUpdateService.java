package springbootmvcshopping.service.goods;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import springbootmvcshopping.command.GoodsCommand;
import springbootmvcshopping.domain.AuthInfoDTO;
import springbootmvcshopping.domain.FileDTO;
import springbootmvcshopping.domain.GoodsDTO;
import springbootmvcshopping.mapper.GoodsMapper;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class GoodsUpdateService {
    @Autowired
    GoodsMapper goodsMapper;

    public void execute(GoodsCommand goodsCommand, HttpSession session){
        GoodsDTO dto = new GoodsDTO();
        //일반 정보
        AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
        String empNum = auth.getUserNum();
        dto.setGoodsNum(goodsCommand.getGoodsNum());
        dto.setGoodsContents(goodsCommand.getGoodsContents());
        dto.setGoodsName(goodsCommand.getGoodsName());
        dto.setGoodsPrice(goodsCommand.getGoodsPrice());
        dto.setVisitCount(goodsCommand.getVisitCount());
        dto.setEmpNum(goodsCommand.getEmpNum());
        dto.setUpdateEmpNum(empNum);

        //파일 시스템에서 삭제
        //1. 디렉토리 정보
        URL resource = getClass().getClassLoader().getResource("static/upload");
        String fileDir = resource.getFile();

        //2. 새로 선택된 이미지 파일 객체 저장
        if(!(goodsCommand.getGoodsMainImage().getOriginalFilename() != null)){
            //파일객체를 불러오기
            MultipartFile mf = goodsCommand.getGoodsMainImage();
            //파일 이름 가져오기
            String originalFile = mf.getOriginalFilename();
            //확장자 불러오기
            String extendsion = originalFile.substring(originalFile.lastIndexOf("."));
            //새로운 파일명 만들기
            String storeName = UUID.randomUUID().toString().replace("-", "");
            //새로운 파일명과 확장자 붙이기
            String storeFileName = storeName + extendsion;
            //파일객체 만들기
            File file = new File(fileDir+"/"+storeFileName);
            //파일 저장
            try{
                mf.transferTo(file);
            }catch (Exception e){
                e.printStackTrace();
            }
            //dto에 파일이름 저장
            dto.setGoodsMainImage(originalFile);
            dto.setGoodsMainStoreImage(storeFileName);
        }

        String storeTotal = "" ;
        String originalTotal = "";
        //배열로 가져오기 때문에 length로 시도해봄     length -1로 찍혀나옴 배열 불가
        if(!goodsCommand.getGoodsDetailImage()[0].getOriginalFilename().isEmpty()){
            //forEach 문으로 파일 객체를 불러옴
            for(MultipartFile mf : goodsCommand.getGoodsDetailImage()){
                //파일 이름 가져오기
                String originalFile = mf.getOriginalFilename();
                //확장자 불러오기
                String extendsion = originalFile.substring(originalFile.lastIndexOf("."));
                //새로운 파일명 만들기
                String storeName = UUID.randomUUID().toString().replace("-", "");
                //새로운 파일명과 확장자 붙이기
                String storeFileName = storeName + extendsion;
                //파일객체 만들기
                File file = new File(fileDir+"/"+storeFileName);
                //파일 저장
                try{
                    mf.transferTo(file);
                }catch (Exception e){
                    e.printStackTrace();
                }
                storeTotal += storeFileName + "/";
                originalTotal += originalFile + "/";
            }
        }

        //session에 있는 값은 삭제, 넘어온 파일은 추가, session의 정보 가져옴
        List<FileDTO> list = (List<FileDTO>) session.getAttribute("fileList");
        //파일의 정보를 디비로 부터 가져오기
        GoodsDTO goodsDTO = goodsMapper.goodsSelectOne(goodsCommand.getGoodsNum());

        //session에 있는 정보를 디비로 부터 제거
        //배열을 리스트로 받아옴
        //만약 DB에 사진이 3개 있고 수정해서 1개만 한다면 배열은 "사진이름//"로 저장되기 때문에
        List<String> dbOrg = new ArrayList<>(Arrays.asList(goodsDTO.getGoodsDetailImage().split("[/`]")));
        List<String> dbStore = new ArrayList<>(Arrays.asList(goodsDTO.getGoodsDetailStoreImage().split("[/`]")));
        //session에 있는 데이터를 DB와 비교해서 디비에 있는 데이터를 삭제
        if(list != null){
            for(FileDTO fdto : list){
                for(String img : dbOrg){
                    if(fdto.getOrgFile().equals(img)){
                        dbOrg.remove(fdto.getOrgFile());
                        dbStore.remove(fdto.getStoreFile());
                        break;
                    }
                }
            }
        }
        for(String img : dbOrg) originalTotal += img +"/";
        for(String img : dbStore) storeTotal += img +"/";

        dto.setGoodsDetailStoreImage(storeTotal);
        dto.setGoodsDetailImage(originalTotal);


        int i = goodsMapper.goodsUpdate(dto);
        if(i > 0){
            if(list != null){
                for(FileDTO fd : list){
                    File file = new File(fileDir+"/"+fd.getStoreFile());
                    if(file.exists()){
                        file.delete();
                    }
                }
            }
        }
    }
}
