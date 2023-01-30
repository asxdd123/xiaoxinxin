package mybatis.service.impl;

import mybatis.entry.Classes;
import mybatis.mapper.ClassesMapper;
import mybatis.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 就不告诉你
 * @CreateTime: 2023-01-30 22:33
 */
@Service
public class ClassesServiceImpl implements ClassesService {

    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public List<Classes> oneToMany() {
        return classesMapper.oneToMany();
    }
}
