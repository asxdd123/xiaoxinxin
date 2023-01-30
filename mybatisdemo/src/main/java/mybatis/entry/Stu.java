package mybatis.entry;

import lombok.Data;

import java.util.List;

/**
 * @Author: 就不告诉你
 * @CreateTime: 2023-01-30 22:27
 */
//多个学生对应一个班级
//多对多模型：学生和课程，一个学生可以选择多门课程、一个课程也可以被多个学生所选择。
@Data
public class Stu {
    private Integer id;
    private String name;
    private Integer age;

    private List<Course> courseList;  //多对多模型：学生和课程，一个学生可以选择多门课程、一个课程也可以被多个学生所选择。
}
