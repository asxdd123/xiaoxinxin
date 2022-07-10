package src.src.com.word.pojo;


import src.src.com.word.annotation.Address;
import src.src.com.word.annotation.Clazz;
import src.src.com.word.annotation.Xingbie;
import src.src.com.word.annotation.Xinxi;

public class XiaoHong {

    @Address("二道沟子")
    private String address;

    @Xinxi(name = "张三",age = 23)
    private String xinxi;

    @Clazz("一班")
    private String clazz;

    @Xingbie(gender = Xingbie.GenterType.Male)
    private String gender;

    public XiaoHong() {
    }

    @Override
    public String toString() {
        return "XiaoHong{" +
                "address='" + address + '\'' +
                ", xinxi='" + xinxi + '\'' +
                ", clazz='" + clazz + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public XiaoHong(String address, String xinxi, String clazz, String gender) {
        this.address = address;
        this.xinxi = xinxi;
        this.clazz = clazz;
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getXinxi() {
        return xinxi;
    }

    public void setXinxi(String xinxi) {
        this.xinxi = xinxi;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
