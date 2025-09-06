package atmMachine;

public class Card {
    private String id;
    private String accountId;

    Card(IdGenerator idGenerator, String accountId){
        if(accountId == null || accountId.isEmpty()){
            throw new IllegalArgumentException("Account Id cannot be empty");
        }
        this.id = idGenerator.generateId();
        this.accountId=accountId;
    }

    public String getId() {
        return id;
    }

    public String getAccountId() {
        return accountId;
    }
}
