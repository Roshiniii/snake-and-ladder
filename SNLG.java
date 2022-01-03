import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
 
 public class SNLG
{
    public static void main (String [] args)
    {
        int counter= 100,iteration=-1;
        System.out.println ("-----------------------------------------------------Game Board-----------------------------------------------------");
        while (counter > 0){
            if (counter%10 == 0 && counter != 100){
                if(iteration==-1)
                {counter-=9;
                    iteration=1;
                }
                else
                {
                    System.out.print(counter+"\t");
                    counter-=10;
                    iteration=-1; 
                }
                if(counter!=0)
                System.out.print("\n" + counter + "\t"); 
            }
            else
            System.out.print(counter + "\t"); 
            counter+=iteration; 
        }
        System.out.println();
        System.out.println ("-------------------------------------------------------------------------------------------");
        SnakeNLadder s = new SnakeNLadder();
        s.startGame();
        
    }
}
class SnakeandLadder
{
     
    final static int WINPOINT = 100;
     
     
    static Map < Integer , Integer > snake = new HashMap < Integer , Integer >();
    static Map < Integer , Integer > ladder = new HashMap< Integer , Integer >();
     
    {
        snake.put(99,44);
        snake.put(80,35);
        snake.put(62,12);
        snake.put(24,1);
        snake.put(95,70);
         
        ladder.put(6,15);
        ladder.put(11,50);
        ladder.put(34,85);
        ladder.put(46,90);
        ladder.put(17,59);
    }

 
public int rollDice()
{
    int n = 0;
    Random r = new Random();
    n=r.nextInt(7);
    return (n==0?1:n);
}public int calculatePlayerValue(int player, int diceValue)
{
    player = player + diceValue;
      
    if(player > WINPOINT)
    {
        player = player - diceValue;
        return player;
    }
      
    if(null!=snake.get(player))
    {
        System.out.println("swallowed by snake");
        player= snake.get(player);
    }
      
    if(null!=ladder.get(player))
    {
        System.out.println("climb up the ladder");
        player= ladder.get(player);
    }
    return player;
}public boolean isWin(int player)
{
    return WINPOINT == player;
}
public void startGame()
{
    int player1 =0, player2=0;
    int currentPlayer=-1;
    Scanner s = new Scanner(System.in);
    String str;
    int diceValue =0;
    do
    {
        System.out.println(currentPlayer==-1?"\n\nFIRST PLAYER TURN":"\n\nSECOND PLAYER TURN");
        System.out.println("Press r to roll Dice");
        str = s.next();
        diceValue = rollDice();
          
          
        if(currentPlayer == -1)
        {
            player1 = calculatePlayerValue(player1,diceValue);
            System.out.println("First Player :: " + player1);
            System.out.println("Second Player :: " + player2);
            System.out.println("------------------");
            if(isWin(player1))
            {
                System.out.println("First player wins");
                return;
            }
        }
        else
        {
            player2 = calculatePlayerValue(player2,diceValue);
            System.out.println("First Player :: " + player1);
            System.out.println("Second Player :: " + player2);
            System.out.println("------------------");
            if(isWin(player2))
            {
                System.out.println("Second player wins");
                return;
            }
        }
          
        currentPlayer= -currentPlayer;
    }while("r".equals(str));
}
}
