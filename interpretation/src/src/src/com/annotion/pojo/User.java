package src.src.com.annotion.pojo;

import src.src.com.annotion.annotion.Hello;

public class User {
    @Hello(value = "你好")
    private String sayHello;

    public User() {
    }

    public User(String sayHello) {
        this.sayHello = sayHello;
    }

}
