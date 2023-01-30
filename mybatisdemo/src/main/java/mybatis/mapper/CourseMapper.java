package mybatis.mapper;

import mybatis.entry.Course;

import java.util.List;

/**
 * @Author: 就不告诉你
 * @CreateTime: 2023-01-30 23:07
 */
public interface CourseMapper {
    public abstract List<Course> manyToMany();
}
