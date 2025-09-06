package toDoList;

public class GetTaskRequest {

    private String id;

    private GetTaskRequest(String id){
        this.id = id;
    }


    public String getId() {
        return id;
    }

    public static class  Builder{
        private String id;

        public Builder withId(String id){
            this.id = id;
            return this;
        }




        public GetTaskRequest build() {
            return new GetTaskRequest(this.id);
        }
    }
}
