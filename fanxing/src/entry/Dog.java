package entry;

/**
 * @Author: 就不告诉你
 * @CreateTime: 2023-01-23 22:21
 */
public class Dog<E> {
    private E eat;

    public Dog(E eat) {
        this.eat = eat;
    }

    public E getEat() {
        return eat;
    }

    public void setEat(E eat) {
        this.eat = eat;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "eat=" + eat +
                '}';
    }
}
