public class Main{
    public static void main(String[] args){
        eCard e=new eCard();
        ePlayer[] ep=new ePlayer[2];
        ep[0]=new ePlayer("king",5);
        ep[1]=new ePlayer("slave",5);
        ep[0].stock();
        ep[1].stock();

        ep[0].show();
        ep[1].show();

        ep[0].shuffle();
        ep[1].shuffle();

        ep[0].show();
        ep[1].show();

        int count=1;
        String str=e.battle(ep[0].sendRandom(),ep[1].sendRandom());
        System.out.println(str);
        while(count!=10){
            System.out.println("count : "+count);
            ep[0].shuffle();
            ep[1].shuffle();
            ep[0].show();
            ep[1].show();
            count++;
        }
    }
}
