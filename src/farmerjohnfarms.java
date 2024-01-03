import java.io.*;
import java.util.*;

public class farmerjohnfarms {
    // Old solution: check out farmerjohnfarms_solution.java
    static class plant{
        int initial;
        int rate;
        public plant(int a, int b){
            this.initial = a;
            this.rate = b;
        }
    }
    static class comparebyinitial implements Comparator<plant>{
        public int compare(plant a, plant b){
            if(a.initial > b.initial) return a.initial;
            else return b.initial;
        }
    }
    static class comparebyrate implements Comparator<plant>{
        public int compare(plant a, plant b){
            if(a.rate > b.rate) return a.rate;
            else return b.rate;
        }
    }
    public static void main(String[] args) throws IOException{
        System.setIn(new FileInputStream("C:\\Users\\guole\\Downloads\\prob1_bronze_open22\\11.in"));
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        int T = Integer.parseInt(st.nextToken());
        for(int i = 0; i < T; i++){
            int needdays = 0;
            st = new StringTokenizer(r.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] heights = new int[N];
            int[] rates = new int[N];
            plant[] plants = new plant[N];
            st = new StringTokenizer(r.readLine());
            for(int j = 0; j < N; j++) heights[j] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(r.readLine());
            for(int j = 0; j < N; j++) rates[j] = Integer.parseInt(st.nextToken());
            for(int j = 0; j < N; j++) plants[j] = new plant(heights[j], rates[j]);
            st = new StringTokenizer(r.readLine());
            int[] fjdemands = new int[N];
            for(int j = 0; j < N; j++) fjdemands[j] = Integer.parseInt(st.nextToken());
            for(int j = 0; j < N; j++){
                
            }



            // for(int j = 0; j < N; j++){
            //     if(fjdemands[j] == 0) continue;
            //     else{
                    
            //     }    // OLD :: ignore this
            // }
        }
        pw.close();
    }
}
