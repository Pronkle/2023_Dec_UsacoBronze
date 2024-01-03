import java.io.*;
import java.util.*;

public class candycanefeast{
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(r.readLine());
        long[] cows = new long[N];
        for(int i = 0; i < N; i++) cows[i] = Long.parseLong(st.nextToken());
        // Reads in the cows
        st = new StringTokenizer(r.readLine());
        long[] canes = new long[M];
        for(int i = 0; i < M; i++) canes[i] = Long.parseLong(st.nextToken());
        // Reads in the candycanes :)
        for(int i = 0; i < M; i++){
            long cane_base = 0;
            for(int j = 0; j < N; j++){
                if(canes[i] - cane_base == 0) break;
                // if(cane_base) Make sure to factor in what happens if all of the cane is eaten
                if(cows[j] >= cane_base && cows[j] < canes[i]){
                    long growth = cows[j] - cane_base;
                    cane_base += growth;
                    cows[j] += growth;
                }
                else if(cows[j] > canes[i]){
                    cows[j] += canes[i] - cane_base;
                    cane_base = canes[i];
                }
            }
        }
        for(int i = 0; i < N; i++) pw.println(cows[i]);
        pw.close();
    }
    //PASSED 14/14
}