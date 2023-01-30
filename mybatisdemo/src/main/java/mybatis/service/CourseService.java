package mybatis.service;

import mybatis.entry.Course;

import java.util.List;

/**
 * @Author: 就不告诉你
 * @CreateTime: 2023-01-30 23:07
 */
public interface CourseService {
    public abstract List<Course> manyToMany();

}
