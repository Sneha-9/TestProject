package splitwise;

public class Person {
    private Amount amountSpent;
    private String name;
    Person(String name,Amount amountSpent){
        this.amountSpent = amountSpent;
        this.name = name;
    }

    public Amount getAmountSpent() {
        return amountSpent;
    }

    public String getName() {
        return name;
    }
}
