package mybatis.service.impl;

import mybatis.entry.Card;
import mybatis.mapper.CardMapper;
import mybatis.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 就不告诉你
 * @CreateTime: 2023-01-30 21:36
 */
@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardMapper cardMapper;

    @Override
    public List<Card> oneToOne() {
        return cardMapper.oneToOne();
    }
}
