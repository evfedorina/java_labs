class Breaker extends Unit{
    Breaker(Field field, int x, int y) {
        super(field,x,y);
    }
    void breakWall(int y, int x){
        field.matrix[y][x] = '_';
        HP-=1;
        AMMU+=3;
    }
    @Override
    void move(char key){
        int nx =x, ny = y;
        switch(key){
            case 'w':
                ny-=1; break;
            case 's':
                ny+=1; break;
            case 'a':
                nx-=1; break;
            case 'd':
                nx+=1; break;
            case 'g':
                if(field.isWall(ny-1,nx)) breakWall(ny-1, nx);
                if(field.isWall(ny+1,nx)) breakWall(ny+1, nx);
                if(field.isWall(ny,nx-1)) breakWall(ny, nx-1);
                if(field.isWall(ny,nx+1)) breakWall(ny, nx+1);
                break;
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
