public class ePlayer{
    private String name;
    private Card[] card;
    private int count,last;
    public ePlayer(String name,int count){
        this.name=name;
        this.count=count;
    }
    public void stock(){
        card=new Card[count];
        for(int i=0;i<count-1;i++) card[i]=new Citizen();
        if(name=="king") card[count-1]=new King();
        if(name=="slave") card[count-1]=new Slave();
    }
    public void shuffle(){
        Card scard;
        for(int i=0;i<count;i++){
            if(card[i].getName()=="king"||card[i].getName()=="slave"){
                int num=(int)(Math.random()*count);
                scard=card[i];
                card[i]=card[num];
                card[num]=scard;
            }
        }
    }
    public void show(){
        System.out.println("- in "+name+" hand -");
        for(int i=0;i<count;i++) System.out.println(card[i].getName());
        System.out.println();
    }
    public Card sendRandom(){
        //count--;
        return card[count-1];
    }
    public void lost(){
        count--;
        for(int i=0;i<count;i++){
            if(i==last) card[i]=card[count-1];
        }
    }
}
