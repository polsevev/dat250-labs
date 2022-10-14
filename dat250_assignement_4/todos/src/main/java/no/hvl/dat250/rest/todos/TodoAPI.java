package no.hvl.dat250.rest.todos;

import com.google.gson.Gson;
import okhttp3.MediaType;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

import static spark.Spark.*;

/**
 * Rest-Endpoint.
 */
public class TodoAPI {

    static ArrayList<Todo> todos = new ArrayList<>();
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static void main(String[] args) {
        if (args.length > 0) {
            port(Integer.parseInt(args[0]));
        } else {
            port(9000);
        }
        Gson gson = new Gson();

        //I assume doing this is okay as the assignement does not state we need to use JPA so i just make the Ids myself
        AtomicLong idCount = new AtomicLong();
        after((req, res) -> {
            res.type("application/json");
        });
        post("/todos", ((request, response) -> {

            Todo sent = gson.fromJson(request.body(), Todo.class);
            if (sent.getId() == null){
                sent = new Todo(idCount.get(), sent.getSummary(), sent.getDescription());
                idCount.addAndGet(1);
            }
            todos.add(sent);

            return gson.toJson(sent);
        }));

        get("/todos", ((request, response) -> {
            return gson.toJson(todos, ArrayList.class);
        }));

        get("/todos/:id", ((request, response) -> {
            String idString = request.params(":id");
            Long id = null;
            try{
                id = Long.parseLong(idString,10);
            }catch (Exception e){
                return String.format("The id \"%s\" is not a number!", idString);
            }
            for (Todo todo: todos) {
                if (Objects.equals(todo.getId(), id)){
                    return gson.toJson(todo);
                }
            }
            return String.format("Todo with the id \"%s\" not found!", id);
        }));

        delete("/todos/:id", ((request, response) -> {
            String idString = request.params(":id");
            Long id = null;
            try{
                id = Long.parseLong(idString,10);
            }catch (Exception e){
                return String.format("The id \"%s\" is not a number!", idString);
            }
            for (int i = 0; i < todos.size(); i++){
                if(Objects.equals(todos.get(i).getId(), id)){
                    todos.remove(i);
                    return "Deletion successfull!";
                }
            }
            System.out.println("Deleted!");
            return String.format("Todo with the id \"%s\" not found!", idString);
        }));


        put("/todos/:id", ((request, response) -> {
            String idString = request.params(":id");
            Long id = null;
            try{
                id = Long.parseLong(idString,10);
            }catch (Exception e){
                return String.format("The id \"%s\" is not a number!", idString);
            }
            Todo sent = gson.fromJson(request.body(), Todo.class);
            for (int i = 0; i < todos.size(); i++) {
                if(Objects.equals(todos.get(i).getId(), id)){
                    todos.set(i, sent);
                    break;
                }
            }
            return "Successfull update!";

        }));

    }
}
