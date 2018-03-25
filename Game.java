
package game;
import java.util.Random;
public class Game {
       
    public static void main(String[] args) {
      int points = 0;
       int a[]={1,2,3,4,5};
    Random r = new Random();
    int b = r.nextInt(10);
        for(int i = 0;i<5;i++)
       {
           
           System.out.println(b);
            if (b ==a[i])
            {
                points++;
            }
       }
            System.out.println(b);
        System.out.println("score ="+ points );
    }
}
