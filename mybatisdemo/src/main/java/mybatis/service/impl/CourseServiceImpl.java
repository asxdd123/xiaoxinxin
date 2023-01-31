package mybatis.service.impl;

import mybatis.entry.Course;
import mybatis.entry.Stu;
import mybatis.mapper.CourseMapper;
import mybatis.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 就不告诉你
 * @CreateTime: 2023-01-30 23:07
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Override
    public List<Stu> manyToMany() {
        return courseMapper.manyToMany();
    }
}
