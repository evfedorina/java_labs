class Seller extends Unit{
    Seller(Field field, int x, int y) {
        super(field,x,y);
    }
    void sellingThorn(int y, int x){
        field.matrix[y][x] = '_';
        CASH+=10;
    }
    void collectingMoney(int y, int x){
        field.matrix[y][x] = '_';
        CASH+=15;
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
            case 'r':
                if(field.isDollar(ny-1,nx)) collectingMoney(ny-1, nx);
                if(field.isDollar(ny+1,nx)) collectingMoney(ny+1, nx);
                if(field.isDollar(ny,nx-1)) collectingMoney(ny, nx-1);
                if(field.isDollar(ny,nx+1)) collectingMoney(ny, nx+1);
                if(field.isDollar(ny-1,nx-1)) collectingMoney(ny-1, nx-1);
                if(field.isDollar(ny+1,nx+1)) collectingMoney(ny+1, nx+1);
                if(field.isDollar(ny+1,nx-1)) collectingMoney(ny+1, nx-1);
                if(field.isDollar(ny-1,nx+1)) collectingMoney(ny-1, nx+1);
            case 't':
                if(field.isThorn(ny-1,nx)) sellingThorn(ny-1, nx);
                if(field.isThorn(ny+1,nx)) sellingThorn(ny+1, nx);
                if(field.isThorn(ny,nx-1)) sellingThorn(ny, nx-1);
                if(field.isThorn(ny,nx+1)) sellingThorn(ny, nx+1);
                if(field.isThorn(ny-1,nx-1)) sellingThorn(ny-1, nx-1);
                if(field.isThorn(ny+1,nx+1)) sellingThorn(ny+1, nx+1);
                if(field.isThorn(ny+1,nx-1)) sellingThorn(ny+1, nx-1);
                if(field.isThorn(ny-1,nx+1)) sellingThorn(ny-1, nx+1);
            default: System.out.println("BRO I CAN'T READ WHAT YOU'VE SENT, TRY AGAIN!!!");
                return;
        }
        if (!field.canGO(ny,nx)){
            System.out.println("CAN'T GO");
            return;
        }
        else if(field.canGO(ny,nx) && field.matrix[ny][nx] == '$'){
            CASH += 15;
            field.matrix[ny][nx] = '_';
        }
        else if(field.canGO(ny,nx) && field.matrix[ny][nx] == '*'){
            HP -= 4;
            field.matrix[ny][nx] = '_';}
        x = nx;
        y = ny;
    }
}
