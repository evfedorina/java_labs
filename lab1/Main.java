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
            if (unit.HP <= 0){
                key = 'e';}
        } while (key != 'e');
    }
}