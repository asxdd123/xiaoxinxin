package mybatis.entry;

import lombok.Data;

import java.util.List;

/**
 * @Author: 就不告诉你
 * @CreateTime: 2023-01-30 23:02
 */
//课程表
@Data
public class Course {
    private Integer id;
    private String name;
//    private List<Stu> stuList; //多对多模型：学生和课程，一个学生可以选择多门课程、一个课程也可以被多个学生所选择。需要第三张表(中间表)
}
