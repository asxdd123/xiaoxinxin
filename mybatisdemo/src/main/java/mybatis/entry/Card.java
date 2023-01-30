package mybatis.entry;

import lombok.Data;
import mybatis.entry.Person;

/**
 * @Author: 就不告诉你
 * @CreateTime: 2023-01-30 21:32
 */
@Data
public class Card { //身份证    一个人只能有一个身份证
    private int id;			//也可以说一个身份证只能一个人使用,(互相)
    private String number;
    private int pid;
    private Person p;	//引入Person 对象
}
