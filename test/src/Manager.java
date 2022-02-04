/**
 * @Author: fg
 * @Date: 2020/5/22 11:30
 */
public class Manager {
    // 工号，姓名，性别，手机号
    private String id;  // 类型不做统一要求,int可以,String也行
    private String name;
    private String gender;
    private String telephone;
    /**
     * 1.包括所涉及的属性
     * 2.要生成getter()&setter()方法
     * 3.要包含无参和带全部参数的构造方法
     * 4.要有相应的toString()方法，用于输出相关属性的值
     */
    public Manager() {
    }

    public Manager(String id, String name, String gender, String telephone) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.telephone = telephone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
