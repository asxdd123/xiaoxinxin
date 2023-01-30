package mybatis.controller;

import mybatis.entry.Classes;
import mybatis.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 就不告诉你
 * @CreateTime: 2023-01-30 22:32
 */
@RestController
@RequestMapping("/oneToMany")
public class ClassesController {

    @Autowired
    private ClassesService classesService;

    /**
     * 一对多嵌套查询(表里有外键id建议这样搞,一对多,多对多同样)
     * 一个班级里有多个学生
     * @return
     */
    @RequestMapping("/aa")
    public List<Classes> oneToMany() {
        return classesService.oneToMany();
    }
}
