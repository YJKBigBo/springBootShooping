package springbootmvcshopping.service.goods;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import springbootmvcshopping.command.GoodsCommand;
import springbootmvcshopping.domain.AuthInfoDTO;
import springbootmvcshopping.domain.GoodsDTO;
import springbootmvcshopping.mapper.AutoNumMapper;
import springbootmvcshopping.mapper.GoodsMapper;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.UUID;

@Service
public class GoodsWriteService {
    @Autowired
    GoodsMapper goodsMapper;

    public void execute(GoodsCommand goodsCommand, String goodsNum, HttpSession session) {
        GoodsDTO dto = new GoodsDTO();
        dto.setGoodsName(goodsCommand.getGoodsName());
        dto.setGoodsPrice(goodsCommand.getGoodsPrice());
        dto.setGoodsContents(goodsCommand.getGoodsContents());
        dto.setGoodsNum(goodsNum);
        AuthInfoDTO auth = (AuthInfoDTO) session.getAttribute("auth");
        dto.setEmpNum(auth.getUserNum());

        ///////////////////////////////////////////////////////////////////파일 추가
        //////////upload의 파일 경로
        URL resource = getClass().getClassLoader().getResource("static/upload");
        //String fileDir = resource.getFile();
        ///////////////////////////////////////////////////////////////////
        //////////파일 관련 내용 (multipart/form-data 처리)
        //////메인이미지
        MultipartFile mf = goodsCommand.getGoodsMainImage();
        String originalFile = mf.getOriginalFilename();
        //저장 하기 위한 이름 생성 : 시간을 이용해서 만듬 => UUID와     확장자인 originalFile이 가지고 있는 확장자명 가져와서 사용
        String extension = originalFile.substring(originalFile.lastIndexOf("."));
        //이름 짓기 해야함
        String storeName = UUID.randomUUID().toString().replace("-", "");
        String storeFileName = storeName + extension;
        //파일 생성
        File file = new File(resource+ "/" + storeFileName);
        try {
            mf.transferTo(file);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //dto에 저장
        dto.setGoodsMainImage(originalFile);
        dto.setGoodsMainStoreImage(storeFileName);

        if(!goodsCommand.getGoodsDetailImage()[0].getOriginalFilename().isEmpty()){
            String originalTotal = "";
            String storeTotal = "";
            for(MultipartFile mpf : goodsCommand.getGoodsDetailImage()){
                originalFile = mpf.getOriginalFilename();
                extension = originalFile.substring(originalFile.lastIndexOf("."));
                storeName = UUID.randomUUID().toString().replace("-", "");
                storeFileName = storeName + extension;
                //파일 생성
                file = new File(resource+ "/" + storeFileName);
                try {
                    mpf.transferTo(file);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                originalTotal += originalFile + "/";
                storeTotal += storeFileName + "/";
            }
            dto.setGoodsDetailImage(originalTotal);
            dto.setGoodsDetailStoreImage(storeTotal);
        }

        goodsMapper.goodsInsert(dto);
    }
}
