package mybatis.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mybatis.entry.Studnt;
import mybatis.mapper.StudentMapper;
import mybatis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: 就不告诉你
 * @CreateTime: 2023-01-25 19:02
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    /**
     * 分页查询
     * @return
     */
    @Override
    public PageInfo<Studnt> selectList() {
        PageHelper.startPage(1, 10);
        List<Studnt> list = studentMapper.selectList();
        PageInfo<Studnt> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * 新增单条数据
     * @param studnt
     * @return
     */
    @Override
    public int insertStudent(Studnt studnt) {
        return studentMapper.insertStudent(studnt);
    }


    /**
     * 修改单条数据
     * @param studnt
     * @return
     */
    @Override
    public int updateSrudent(Studnt studnt) {
        return studentMapper.updateSrudent(studnt);
    }

    /**
     * 根据条件进行批量删除
     * @param name
     * @param sex
     * @return
     */
    @Override
    public int deleteSrudentByNameAndSex(String name, String sex) {
        return studentMapper.deleteSrudentByNameAndSex(name,sex);
    }

    /**
     * 删除单条数据
     * @param id
     * @return
     */
    @Override
    public int deleteSrudent(String id) {
        return studentMapper.deleteSrudent(id);
    }

    /**
     * 根据条件查询数据
     * @param sex
     * @param name
     * @return
     */
    @Override
    public List<Studnt> selectBySexAndName(String sex, String name) {
        return studentMapper.selectBySexAndName(sex,name);
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @Override
    public Studnt selectById(String id) {
        return studentMapper.selectById(id);
    }

    /**
     * 批量新增数据
     * @param list
     * @return
     */
    @Override
    public int insertStudentList(List<Studnt> list) {
        return studentMapper.insertStudentList(list);
    }
}
