package mybatis.mapper;

import mybatis.entry.Course;
import mybatis.entry.Stu;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: 就不告诉你
 * @CreateTime: 2023-01-30 23:07
 */
public interface CourseMapper {

    //多对多基于注解开发
    @Select("SELECT DISTINCT s.id,s.name,s.age FROM stu s,stu_cr sc WHERE sc.sid=s.id")
    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "name",property = "name"),
            @Result(column = "age",property = "age"),
            @Result(
                    property = "courseList",   // 被包含对象的变量名(要与实体类中的变量名要一致)
                    javaType = List.class,  // 被包含对象的实际数据类型
                    column = "id",          // 根据查询出student表的id来作为关联条件，去查询中间表和课程表
                    /*
                        many、@Many 一对多查询的固定写法
                        select属性：指定调用哪个接口中的哪个查询方法
                     */
                    many = @Many(select = "mybatis.mapper.CourseMapper.selectBySid")
            )
    })
    public abstract List<Stu> manyToMany();



    //根据学生id查询所选课程
    @Select("SELECT c.id,c.name FROM stu_cr sc,course c WHERE sc.cid=c.id AND sc.sid=#{id}")
    public abstract List<Course> selectBySid(Integer id);



//  [
//      {
//           "id": 1,
//            "name": "张三",
//            "age": 23,
//            "courseList": [
//                              {
//                                  "id": 1,
//                                  "name": "语文"
//                              },
//                              {
//                                  "id": 2,
//                                  "name": "数学"
//                              }
//                          ]
//    },
//    {
//            "id": 2,
//            "name": "李四",
//            "age": 24,
//            "courseList": [
//                              {
//                                  "id": 1,
//                                  "name": "语文"
//                              },
//                              {
//                                  "id": 2,
//                                  "name": "数学"
//                              }
//                          ]
//    }
//  ]
}
