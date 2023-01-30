package mybatis.entry;

import lombok.Data;

import java.util.List;

/**
 * @Author: 就不告诉你
 * @CreateTime: 2023-01-30 22:26
 */
@Data
public class Classes {  //一个班级对应多个学生
    private Integer id;
    private String name;
    private List<Stu> stuList; //班级中的学生
}
