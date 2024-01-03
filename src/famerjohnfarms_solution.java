import java.io.*;
import java.util.*;

public class famerjohnfarms_solution {
    /*
     * My new working solution to this problem - post contest
     * PASSED 13/13 :D
     * Note: This problem really demonstrates the importance of scratch paper, I would've made Silver
     * if I actually sat down and worked out more of the cases, it really isn't that bad!
     */
    static class plant{
        Long height;
        Long rate;
        Long place;
        public plant(long a, long b, long c){
            this.height = a;
            this.rate = b;
            this.place = c;
        }
    }
    static class comparebyplace implements Comparator<plant>{
        public int compare(plant a, plant b){
            return a.place.compareTo(b.place);
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(r.readLine());
        PrintWriter pw = new PrintWriter(System.out);
        int cases = Integer.parseInt(st.nextToken());
        for(int i = 0; i < cases; i++){
            st = new StringTokenizer(r.readLine());
            int N = Integer.parseInt(st.nextToken());
            plant[] plants = new plant[N];
            StringTokenizer st1 = new StringTokenizer(r.readLine());
            StringTokenizer st2 = new StringTokenizer(r.readLine());
            StringTokenizer st3 = new StringTokenizer(r.readLine());
            for(int j = 0; j < N; j++){ 
            plants[j] = new plant(
            Long.parseLong(st1.nextToken()), 
            Long.parseLong(st2.nextToken()), 
            Long.parseLong(st3.nextToken()));
            }
            comparebyplace comparespots = new comparebyplace();
            Arrays.sort(plants, comparespots);
            long maxdays = 0;
            for(int j = 0; j < N-1; j++){
                if(plants[j].rate > plants[j+1].rate){
                    long d_height = plants[j+1].height - plants[j].height;
                    long d_rate = plants[j].rate - plants[j+1].rate;
                    long days = (d_height/d_rate) + 1;
                    if(days > maxdays) maxdays = days;
                }
            }
            boolean works = true;
            for(int j = 0; j < N-1; j++){
                if((plants[j].height + plants[j].rate * maxdays) <= (plants[j+1].height + plants[j+1].rate * maxdays)){
                    pw.println("-1");
                    works = false;
                    break;
                }
            }
            if(works == true) pw.println(maxdays);
        }
        pw.close();
    }
}
