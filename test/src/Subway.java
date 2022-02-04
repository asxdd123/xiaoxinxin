/**
 * @Author: fg
 * @Date: 2020/5/22 11:35
 */
public class Subway {
    // 地铁站编号，地铁站名称，所属路线
    private String id;
    private String name;
    private String route; // luXian 也可以~~~

    /**
     * 1.包括所涉及的属性
     * 2.要生成getter()&setter()方法
     * 3.要包含无参和带全部参数的构造方法
     * 4.要有相应的toString()方法，用于输出相关属性的值
     */
    public Subway() {
    }

    public Subway(String id, String name, String route) {
        this.id = id;
        this.name = name;
        this.route = route;
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

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "Subway{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", route='" + route + '\'' +
                '}';
    }
}
