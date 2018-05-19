import java.sql.Time;
import java.util.List;

public class YashchikCore{

    private static ArduinoPort arduinoPort;
    private static State curState;

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

    public static String getPubKey(){
        return "0x12213";
    }



}
