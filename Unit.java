abstract class Unit {
    int HP, CASH, x, y;
    Field field;
    Unit(Field field, int x, int y){
        this.field = field;
        this.x = x;
        this.y = y;
        HP = 3;
        CASH = 20;
    }
    abstract void move(char key);
}