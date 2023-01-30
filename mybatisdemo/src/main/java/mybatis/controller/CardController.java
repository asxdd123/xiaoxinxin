package mybatis.controller;

import mybatis.entry.Card;
import mybatis.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 就不告诉你
 * @CreateTime: 2023-01-30 21:38
 */
@RestController
@RequestMapping("/oneToOne")
public class CardController {
    /**
     * 一对一嵌套查询  (表里有外键id建议这样搞,一对多,多对多同样)
     * 一个身份证对应一个人
     */
    @Autowired
    private CardService cardService;

    @RequestMapping("/aa")
    public List<Card> oneToOne(){
        return cardService.oneToOne();
    }
}
