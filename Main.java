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
        System.out.println("TO BE A JUMPER, ENTER '0' (ZERO)");
        System.out.println("TO BE A NORMAL PERSON, TYPE ANY OTHER NUMBER");
        if (reader.nextInt() == 0){
            unit = new Jumper(field, 5, 5);
            System.out.println("NOW U ARE JUMPER, HIS STEP IS 2 CELLS");
        }
        else{
            unit = new Standard(field, 5, 5);
            System.out.println("NOW U ARE NORMAL PERSON, HIS STEP IS 1 CELL");
        }

        field.output(unit);
        char key;
        do{
            key = reader.next().charAt(0);
            unit.move(key);
            field.output(unit);
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
        System.out.println(("HP: " + unit.HP + " CASH: " + unit.CASH));
        if (unit.HP <= 0){
            System.out.println("BRO U DED");
        }
    }
    boolean canGO(int y, int x){
        if (x < 0 || x >= w || y < 0 || y >= h){
            return false;}
        return matrix[y][x] != '|';
    }
}
