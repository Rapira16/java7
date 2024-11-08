import java.util.ArrayList;

public class MyStack {
    private ArrayList<Object> list;

    public MyStack() {
        list = new ArrayList<>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }

    public Object peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return deepCopy(list.get(getSize() - 1));
    }

    public Object pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return deepCopy(list.remove(getSize() - 1));
    }

    public void push(Object o) {
        list.add(deepCopy(o));
    }

    private Object deepCopy(Object obj) {
        if (obj instanceof Cloneable) {
            try {
                return obj.getClass().getMethod("clone").invoke(obj);
            } catch (Exception e) {
                throw new RuntimeException("Clone not supported", e);
            }
        }
        return obj; // Если объект не Cloneable, возвращаем его как есть
    }
}
