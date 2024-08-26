package BasicMath;

import java.util.LinkedHashMap;
import java.util.Map;

public class FrequencyOfanArray {
    public static void main(String[] args) {
        frequency("rajsuryakalieswaran");

    }

    //find the frequency
    public static void frequency(String str){
        //aabbcccabcde
        //key - > value
        //a -> 2
        //b -> 2
        //c -> 3
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        for(int i = 0; i < str.length(); i++){
            if(map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            }else{
                map.put(str.charAt(i), 1);
            }
        }

        for(Map.Entry<Character, Integer> entry : map.entrySet()){

                System.out.println(entry.getKey() + " -> " + entry.getValue());

        }
    }

}
