import java.util.Random;

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
        System.out.println(unit.CURPHRASE);
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
