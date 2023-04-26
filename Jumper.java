class Jumper extends Unit{
    Jumper(Field field, int x, int y) {
        super(field,x,y);
    }
    @Override
    void move(char key){
        int nx =x, ny = y;
        switch(key){
            case 'w':
                ny-=2; break;
            case 's':
                ny+=2; break;
            case 'a':
                nx-=2; break;
            case 'd':
                nx+=2; break;
            default: System.out.println("BRO I CAN'T READ WHAT YOU'VE SENT, TRY AGAIN!!!");
                return;
        }
        if (!field.canGO(ny,nx)){
            System.out.println("CAN'T GO");
            return;
        }
        else if(field.canGO(ny,nx) && field.matrix[ny][nx] == '$'){
            CASH += 10;
            field.matrix[ny][nx] = '_';
        }
        else if(field.canGO(ny,nx) && field.matrix[ny][nx] == '*'){
            HP -= 20;
            field.matrix[ny][nx] = '_';}
        x = nx;
        y = ny;
    }
}
