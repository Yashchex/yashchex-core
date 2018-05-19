import javax.ws.rs.*;


@Path("/tasks")
@Produces({"application/json"})
public class ApiService {

    /**
     * Get task by uuid.
     *
     * @return task with specific uuid.
     */
    @GET
    @Path("/state")
    public State getState() {
        return YashchikCore.getState();
    }

    @GET
    @Path("/pubKey")
    public String getPubKey() {
        return YashchikCore.getPubKey();
    }

    /**
     * Add new task.
     *
     * @param string pu.
     */
    @POST
    @Path("/checkContract")
    @Consumes({"application/json"})
    public String add(String string) {
        //chechChain();
        return "OK";
    }


}
