abstract class Unit {
    int HP, CASH, AMMU, x, y;
    Field field;
    String PHRASE1, PHRASE2, CURPHRASE="YES, MY LORD";
    Unit(Field field, int x, int y){
        this.field = field;
        this.x = x;
        this.y = y;
        HP = 10;
        CASH = 20;
        AMMU = 0;
    }
    abstract void move(char key);
}
