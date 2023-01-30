package mybatis.mapper;

import mybatis.entry.Studnt;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: 就不告诉你
 * @CreateTime: 2023-01-25 19:01
 */
@Repository
public interface StudentMapper {
    public abstract List<Studnt> selectList();

    public abstract int insertStudent(Studnt studnt);

    public abstract int insertStudentList(List<Studnt> list);

    Studnt selectById(String id);

    List<Studnt> selectBySexAndName(@Param("sex") String sex, @Param("name") String name);

    int updateSrudent(Studnt studnt);

    int deleteSrudent(String id);

    int deleteSrudentByNameAndSex(String name, String sex);
}
