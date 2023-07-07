package cn.tedu.cn_tedu_v1.bookdeatils.service.impl;

import cn.tedu.cn_tedu_v1.bookdeatils.persist.repository.IBookDeatilsRepository;
import cn.tedu.cn_tedu_v1.bookdeatils.pojo.vo.BookDeatilsVO;
import cn.tedu.cn_tedu_v1.bookdeatils.service.IBookDeatilsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

@Service
@Slf4j
public class BookDeatilsServiceImpl implements IBookDeatilsService {
    @Autowired
    private IBookDeatilsRepository bookDetailsRepository;

    @Override
    public List<BookDeatilsVO> listBookDetails() throws IOException {
        List<BookDeatilsVO> BookDeatilsVO =bookDetailsRepository.listBookDetails();

        for (BookDeatilsVO libraryBookVO: BookDeatilsVO){
            Path imagePath = Paths.get("e:/files/" + libraryBookVO.getCover());
            byte[] imageBytes = Files.readAllBytes(imagePath);
            // 将图片转换成 base64 编码
            String base64Img = Base64.getEncoder().encodeToString(imageBytes);
            libraryBookVO.setCover("data:image/png;base64," + base64Img);
        }
        return BookDeatilsVO;

    }


}
