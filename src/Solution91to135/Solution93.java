package Solution91to135;

import java.util.ArrayList;
import java.util.List;

public class Solution93 {

    //todo待优化
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if(s.length() > 12 || s.length() < 4) return result;
        ips(result, new ArrayList<>(), s, s.length());
        return result;
    }

    public void ips(List<String> result, List<String> current, String s, int restLen){
        int restIp = 4 - current.size();
        if(restLen == 0  && restIp == 0){
            String ip = current.get(0) + "." + current.get(1) + "." + current.get(2) + "." + current.get(3);
            result.add(ip);
        }
        if(restLen < restIp) return;
        int start = s.length() - restLen;
        if((restIp - 1) * 3 >= restLen - 1){
            current.add(s.charAt(start) + "");
            ips(result, current, s, restLen - 1);
            current.remove(current.size() - 1);
        }
        if(restLen >= 2 && s.charAt(start) != '0' && (restIp-1) * 3 >= restLen - 2 && (restIp-1) <= restLen - 2){
            current.add(s.substring(start, start + 2));
            ips(result, current, s, restLen - 2);
            current.remove(current.size() - 1);
        }

        if(restLen >= 3 && (restIp-1) * 3 >= (restLen - 3) && (restIp-1) <= (restLen - 3)
                && s.charAt(start) != '0' && (s.charAt(start) == '1'
                || (s.charAt(start) == '2' && Integer.parseInt(s.substring(start, start + 3) )<= 255))){
            current.add(s.substring(start, start + 3));
            ips(result, current, s, restLen - 3);
            current.remove(current.size() - 1);
        }


    }

    public static void main(String[] argv){
        Solution93 s = new Solution93();
        s.restoreIpAddresses("0000");
    }
}
