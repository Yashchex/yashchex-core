import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;



public class YashchikCore{

    public  final int NETWORK_ID_MAIN = 1;
    public  final int NETWORK_ID_ROPSTEN = 3;
    private  String infuraAccessToken = "YourInfuraAccessToken";
    private  String infuraTestNetRopstenUrl = "https://ropsten.infura.io/" + infuraAccessToken;

    private static String credentialPath = "./eth";
    private static String password = java.util.UUID.randomUUID().toString();
    private Web3j web3j = Web3j.build(new HttpService(infuraTestNetRopstenUrl));
    String walletFile = WalletUtils.generateLightNewWalletFile(password, new File(credentialPath));
    private Credentials credentials = WalletUtils.loadCredentials(password, credentialPath);
    private String publicAddress = credentials.getAddress();
    //BigInteger privateKey = credentials.getEcKeyPair().getPrivateKey();



    private static ArduinoPort arduinoPort;
    private static State curState;

    public YashchikCore() throws CipherException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchProviderException, IOException {
    }

    public static void main(String[] args) throws Exception {
        int i = 0;
        arduinoPort = new ArduinoPort();
        arduinoPort.initialize();
        System.out.println("Start init");
        while (i<=5){
            for (State s : arduinoPort.getLastUnviewStates()){
                System.out.println("State : " + s);
                curState = s;
            }
            Thread.sleep(2000);
            i++;
        }
        arduinoPort.unlock();
        Thread.sleep(4000);
        arduinoPort.lock();
        System.out.println("Stop");
    }

    public static State getState(){
        return arduinoPort.getLastState();
    }


    public static String getPassword(){
        return password;
    }

    public static String getCredentialPath(){
        return credentialPath;
    }




}
