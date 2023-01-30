package entry;

import java.util.Objects;

/**
 * @Author: 就不告诉你
 * @CreateTime: 2023-01-23 22:21
 */
public class Cat<T> {
    private T name;
    private Integer age;


    public Cat() {
    }

    public Cat(T name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }
}
