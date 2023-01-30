package mybatis.controller;

import mybatis.entry.Course;
import mybatis.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 就不告诉你
 * @CreateTime: 2023-01-30 23:07
 */
@RestController
@RequestMapping("/manyToMany")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/aa")
    private List<Course> manyToMany(){
        return courseService.manyToMany();
    }
}
