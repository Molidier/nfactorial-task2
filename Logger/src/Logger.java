import java.util.HashMap;
public class Logger {
    HashMap<String, Integer> map = new HashMap<>();

    public Logger(){}

    public boolean shouldPrintMessage (int timestamp, String message){
        if(map.size()>100){
            map.clear();
        }

        if(map.containsKey(message)){
            if(timestamp >= map.get(message)+10){
                map.put(message, timestamp);
                return true;
            }
        }else{
            map.put(message, timestamp);
            return true;
        }

        return false;
    }

    public void loggerSize(){
        System.out.println(map.size());
    }

    public boolean clean(int val){
        if(map.containsValue(val)) {
            return false;
        }
        //System.out.println(map);

        return true;
    }


}
