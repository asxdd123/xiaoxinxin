package mybatis.mapper;

import mybatis.entry.Studnt;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: 就不告诉你
 * @CreateTime: 2023-01-25 19:01
 */
@Repository
public interface StudentMapper {
    public abstract List<Studnt> selectList();

    /**
     * useGeneratedKeys 是否使用创建的主键
     * keyColumn 数据表中的字段名
     * keyProperty 实体类中的属性名
     */
//    @Options(useGeneratedKeys = true,keyColumn = "sid",keyProperty = "sid")  //基于注解实现返回主键自增id
    public abstract int insertStudent(Studnt studnt);

    public abstract int insertStudentList(List<Studnt> list);

    Studnt selectById(String id);

    List<Studnt> selectBySexAndName(@Param("sex") String sex, @Param("name") String name);

    int updateSrudent(Studnt studnt);

    int deleteSrudent(String id);

    int deleteSrudentByNameAndSex(String name, String sex);

    Studnt selectByIdAndName(Map<String, Object> map);
}
