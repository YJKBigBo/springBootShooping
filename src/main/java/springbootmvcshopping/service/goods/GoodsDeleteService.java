package springbootmvcshopping.service.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootmvcshopping.domain.GoodsDTO;
import springbootmvcshopping.mapper.GoodsMapper;

import java.io.File;
import java.net.URL;
import java.util.Arrays;

@Service
public class GoodsDeleteService {
    @Autowired
    GoodsMapper goodsMapper;

    public void execute(String[] goodsNum){
        //삭제할 파일의 정보 가져오기
        GoodsDTO dto = goodsMapper.goodsSelectOne(Arrays.toString(goodsNum));

        //파일 삭제 코드
        int i = goodsMapper.goodsDelete(goodsNum);
        if(i>0){
            //1. 디렉터리 경로
            URL resource = getClass().getClassLoader().getResource("static/upload");
            String fileDir = resource.getPath();

            //2. 파일 객체 생성
            File file = new File(fileDir+"/"+dto.getGoodsMainStoreImage());
            //3. 파일 삭제
            if(file.exists()){
                file.delete();
            }

            if(dto.getGoodsDetailImage() != null){
                for(String fileName : dto.getGoodsDetailStoreImage().split("/")){
                    file = new File(fileDir+"/"+fileName);
                    //3. 파일 삭제
                    if(file.exists()){
                        file.delete();
                    }
                }
            }
        }
        
    }


}
