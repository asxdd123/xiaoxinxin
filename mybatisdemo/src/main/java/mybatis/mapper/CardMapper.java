package mybatis.mapper;

import mybatis.entry.Card;
import mybatis.entry.Person;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: 就不告诉你
 * @CreateTime: 2023-01-30 21:36
 */
public interface CardMapper {


   //一对一基于注解查询
   @Select("SELECT * FROM card")
   @Results({
           @Result(column = "id", property = "id"),
           @Result(column = "number", property = "number"),
           @Result(
                   property = "p",             // 被包含对象的变量名(要和实体类中的变量名一致)
                   javaType = Person.class,    // 被包含对象的实际数据类型
                   column = "pid",             // 根据查询出的card表中的pid字段调用selectById方法来查询person表
                   /*
                       one、@One 一对一固定写法
                       select属性：指定调用哪个接口中的哪个方法
                    */
                   one = @One(select = "mybatis.mapper.CardMapper.selectById")
           )
   })
   public abstract List<Card> oneToOne();


   //该方法接到id后带入sql查询
   @Select("SELECT * FROM person WHERE id=#{id}")
   public abstract Person selectById(Integer id);



//   {
//      "id": 1,
//      "number": "12345",
//      "pid": 0,
//      "p": {
//         "id": 1,
//         "name": "张三",
//         "age": 23
//        }
//   },
//   {
//       "id": 2,
//       "number": "23456",
//       "pid": 0,
//       "p": {
//           "id": 2,
//           "name": "李四",
//           "age": 24
//}
//},

}
