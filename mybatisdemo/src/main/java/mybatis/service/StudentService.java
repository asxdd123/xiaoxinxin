package mybatis.service;

import com.github.pagehelper.PageInfo;
import mybatis.entry.Studnt;

import java.util.List;
import java.util.Map;


/**
 * @Author: 就不告诉你
 * @CreateTime: 2023-01-25 19:01
 */
public interface StudentService {
    public abstract PageInfo<Studnt> selectList();

    public abstract int insertStudent(Studnt studnt);

    public abstract int insertStudentList(List<Studnt> list);

    public abstract Studnt selectById(String id);

    List<Studnt> selectBySexAndName(String sex, String name);

    int updateSrudent(Studnt studnt);

    int deleteSrudent(String id);

    int deleteSrudentByNameAndSex(String name, String sex);

    Studnt selectByIdAndName(Map<String, Object> map);
}
