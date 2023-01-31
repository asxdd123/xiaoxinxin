package mybatis.mapper;

import mybatis.entry.Classes;
import mybatis.entry.Stu;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: 就不告诉你
 * @CreateTime: 2023-01-30 22:32
 */
public interface ClassesMapper {

   //一对多基于注解开发实现
   @Select("SELECT * FROM classes")
   @Results({
           @Result(column = "id",property = "id"),
           @Result(column = "name",property = "name"),
           @Result(
                   property = "stuList",  // 被包含对象的变量名(要跟实体类中的变量名一致)
                   javaType = List.class,  // 被包含对象的实际数据类型
                   column = "id",          // 根据查询出的classes表的id字段来查询student表
                   /*
                       many、@Many 一对多查询的固定写法
                       select属性：指定调用哪个接口中的哪个查询方法
                    */
                   many = @Many(select = "mybatis.mapper.ClassesMapper.selectByCid")
           )
   })
   public abstract List<Classes> oneToMany();


   //根据cid查询student表
   @Select("SELECT * FROM stu WHERE cid=#{cid}")
   public abstract List<Stu> selectByCid(Integer cid);


//   [
//      {
//        "id": 1,
//        "name": "黑马一班",
//        "stuList": [
//                      {
//                         "id": 1,
//                         "name": "张三",
//                         "age": 23,
//                         "courseList": null
//                      },
//                      {
//                         "id": 2,
//                         "name": "李四",
//                         "age": 24,
//                         "courseList": null
//                      }
//                   ]
//       },
//      {
//        "id": 2,
//        "name": "黑马二班",
//        "stuList": [
//                      {
//                         "id": 3,
//                         "name": "王五",
//                         "age": 25,
//                         "courseList": null
//                      },
//                      {
//                         "id": 4,
//                         "name": "赵六",
//                         "age": 26,
//                         "courseList": null
//                      }
//                   ]
//       }
//    ]
}
