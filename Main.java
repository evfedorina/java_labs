import java.util.Random;
import java.util.Scanner;

// Press ⇧ twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        Field field = new Field(10, 10);
        field.fill();
        Unit unit;
        System.out.println("CHOOSE YOUR FIGHTER");
        System.out.println("TO BE A SELLER, ENTER '0' (ZERO)");
        System.out.println("TO BE A BREAKER, ENTER '1'");
        System.out.println("TO BE A NORMAL PERSON, ENTER '2'");
        int FIGHTER = reader.nextInt();
        if (FIGHTER == 0){
            unit = new Seller(field, 5, 5);
            System.out.println("NOW U ARE A SELLER, HE CAN COLLECT NEARBY MONEY(type 'r') OR SELL NEARBY THORNS(type 't')");
        }
        else if (FIGHTER == 1){
            unit = new Breaker(field, 5, 5);
            System.out.println("NOW U ARE A BREAKER, HE CAN BREAK WALLS(JUST type 'g' if you are near a wall)");
        }
        else{
            unit = new Standard(field, 5, 5);
            System.out.println("NOW U ARE A NORMAL PERSON, HIS STEP IS 1 CELL");
        }

        field.output(unit);
        char key;
        do{
            key = reader.next().charAt(0);
            unit.move(key);
            field.output(unit);
            if (key == 'g' && FIGHTER == 1){
                System.out.println("AAAGGH!!! I'VE BROKEN ALL THE NEARBY WALLS! ME STONK!");
            }
            if (key == 'r' && FIGHTER == 0){
                System.out.println("COLLECTED ALL THE MONEY AROUND HERE. SO SWEET");
            }
            if (key == 't' && FIGHTER == 0){
                System.out.println("I DON'T KNOW WHY NOBODY CAN SELL THESE, BUT I SURELY CAN, JUST FREE MONEY");
            }
            if (unit.HP <= 0){
                key = 'e';}
        } while (key != 'e');
    }
}
class Field
{
    int w, h;
    char [][] matrix;
    Field(int w, int h)
    {
        this.w = w;
        this.h = h;
        matrix = new char[w][h];
    }
    void fill()
    {
        Random rng = new Random();
        for(int i=0;i<h;i++){
            for(int j=0;j<w;j++)
                matrix[i][j] = ' ';}
        for(int i=0;i<h;i++)
            for (int j = 0; j < w; j++){
                int dice = rng.nextInt(100);
                if (dice<50)
                    matrix [i][j] = '_';
                else if (dice < 70)
                    matrix [i][j] = '$';
                else if (dice < 90)
                    matrix [i][j] = '|';
                else
                    matrix [i][j] = '*';}

    }
    void output()
    {
        for(int i=0;i<h;i++){
            for (int j = 0; j < w; j++)
                System.out.print(matrix[i][j] + "_");
            System.out.println();
        }
    }
    void output(Unit unit)
    {
        for(int i=0;i<h;i++) {
            for (int j = 0; j < w; j++)
                if (unit.x == j && unit.y == i)
                    System.out.print('&');
                else
                    System.out.print(matrix[i][j]);
            System.out.println();}
        System.out.println(("HP: " + unit.HP + " CASH: " + unit.CASH + " AMMU: " + unit.AMMU));
        if (unit.HP <= 0){
            System.out.println("BRO U DED");
        }
    }
    boolean canGO(int y, int x){
        if (x < 0 || x >= w || y < 0 || y >= h){
            return false;}
        return matrix[y][x] != '|';
    }
    boolean isWall(int y, int x){
        if (x < 0 || x >= w || y < 0 || y >= h){
            return false;}
        return matrix[y][x] == '|';
    }
    boolean isThorn(int y, int x){
        if (x < 0 || x >= w || y < 0 || y >= h){
            return false;}
        return matrix[y][x] == '*';
    }
    boolean isDollar(int y, int x){
        if (x < 0 || x >= w || y < 0 || y >= h){
            return false;}
        return matrix[y][x] == '$';
    }
}
