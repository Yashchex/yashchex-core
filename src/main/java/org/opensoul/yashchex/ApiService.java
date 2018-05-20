import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import javax.ws.rs.*;
import java.io.File;
import java.io.IOException;


@Path("/")
public class ApiService {

    @GET
    @Path("/json")
    @Produces({ "application/json" })
    public String getHelloWorldJSON() {
        return "{\"result\":\"" + "Hello world!" + "\"}";
    }

    /**
     * Get task by uuid.
     *
     * @return task with specific uuid.
     */
    @GET
    @Path("/state")
    @Produces({"application/json"})
    public State getState() {
        return YashchikCore.getState();
    }

    @GET
    @Path("/pubKey")
    @Produces({"application/json"})
    public String getPubKey() {
        Credentials credentials = null;
        try {
            credentials = WalletUtils.loadCredentials(YashchikCore.getPassword(), new File(YashchikCore.getCredentialPath()));
        } catch (Exception e) {
            return e.toString();}
        return credentials.getAddress();
    }

    @POST
    @Path("/checkContract/")
    @Consumes({"application/json"})
    public String checkContract() {
        //chechChain();
        return "OK";
    }


}
