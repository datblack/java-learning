package datmt.learning.generic;

public class Manager extends Employee {
    @Override
    public String toString() {
        return "Manager{" +
                "raw='" + raw + '\'' +
                ", reward=" + reward +
                '}';
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public Double getReward() {
        return reward;
    }

    public void setReward(Double reward) {
        this.reward = reward;
    }

    public Manager() {
    }

    public Manager(String name, Integer age, Integer gender, String birthDay, Integer salary) {
        super(name, age, gender, birthDay, salary);
    }

    public Manager(String raw, Double reward) {
        this.raw = raw;
        this.reward = reward;
    }

    public Manager(String name, Integer age, Integer gender, String birthDay, Integer salary, String raw, Double reward) {
        super(name, age, gender, birthDay, salary);
        this.raw = raw;
        this.reward = reward;
    }

    private String raw;
    private Double reward;
}
