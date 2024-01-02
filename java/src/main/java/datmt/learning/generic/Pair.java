package datmt.learning.generic;

public class Pair <T> {
    private T type;
    public Pair(T getType) {
        this.type = getType;
    }

    public Pair() {}
    public T showEntity(){
        return this.type;
    }

    public void setEntity(Pair<? extends T> entity){
        this.type = entity.showEntity();
    }

    public void setType(T type) {
        this.type = type;
    }
}
