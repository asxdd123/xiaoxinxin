package test;

/**
 * @Author: 就不告诉你
 * @CreateTime: 2023-01-12 14:38
 * 首先创建一个表示图形的抽象类 Shape
 */
public abstract  class Shape {
    public int width; // 几何图形的长
    public int height; // 几何图形的宽

    public Shape(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public abstract double area(); // 定义抽象方法，计算面积
}


/**
 * 定义一个正方形类，该类继承自形状类 Shape，并重写了 area( ) 抽象方法。
 */
class Square extends Shape {

    public Square(int width, int height) {
        super(width, height);
    }

    // 重写父类中的抽象方法，实现计算正方形面积的功能
    @Override
    public double area() {
        return width * height;
    }
}

/**
 * 定义一个三角形类，该类与正方形类一样，需要继承形状类 Shape，并重写父类中的抽象方法 area()。
 */
class Triangle extends Shape {
    public Triangle(int width, int height) {
        super(width, height);
    }

    @Override
    public double area() {
        return 0.5 * width * height;
    }
}


/**
 * 最后创建一个测试类，分别创建正方形类和三角形类的对象，并调用各类中的 area() 方法，
 * 打印出不同形状的几何图形的面积。
 */
class ShapeTest {
    public static void main(String[] args) {
        Square square = new Square(5, 4); // 创建正方形类对象
        System.out.println("正方形的面积为：" + square.area());
        Triangle triangle = new Triangle(2, 5); // 创建三角形类对象
        System.out.println("三角形的面积为：" + triangle.area());
    }
}
