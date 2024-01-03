import java.io.*;
import java.util.*;

public class cowntacttracing {

    // Really poor solution: got like 2 test cases right :(
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        long N = Long.parseLong(st.nextToken());
        st = new StringTokenizer(r.readLine());
        String s = st.nextToken();
        char[] sickcows = s.toCharArray();  
        long totalsick = 0;
        ArrayList<Long> sickgroupdays = new ArrayList<>();

        for(int i = 0; i < s.length(); i++){
            Character c = sickcows[i];
            if(c == '1'){
                long indexs = i;
                for(int j = i; j < s.length(); j++){
                    Character c2 = sickcows[j];
                    if(c2 == '0' || j == s.length()-1){
                        long indexe = j;
                        sickgroupdays.add((indexe-indexs)+1);
                        i = j+1;
                        break;
                    }
                }
            }
        }
        boolean works = false;
        long d = 1;
        long max = 0;
        while(true){
            for(int i = 0; i < sickgroupdays.size(); i++){
                if((sickgroupdays.get(i) / d) != 0){
                    works = true;
                    totalsick = (sickgroupdays.get(i) / d);
                }
                else{
                    works = false;
                    break;
                }
            }
            d++;
            if(works == true) max = totalsick;
            if(works == false) break;
        }
        pw.println(max);
        pw.close();
    }
}
