import javax.swing.JFrame;
import javax.swing.JPanel;
public class EFrame extends JFrame implements EcardITF{
    public String[] PName={"play","play2"};
    EPanel[] ep=new EPanel[4];
    public Card mine,yours;
    public EFrame(){
        super("E CARD");
        this.setSize(width,height);
        
        mine=new BackCard();
  
        ep[1]=new EPlayPanel2(this,PName[1]);
        this.add((EPlayPanel2)ep[1]);
        ((EPlayPanel2)ep[1]).setVisible(false);

        ep[0]=new EPlayPanel(this,PName[0]);
        this.add((EPlayPanel)ep[0]);
        ((EPlayPanel)ep[0]).setVisible(true);
       
    }
    public static void main(String[] args){
        EFrame ef=new EFrame();
        ef.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ef.setVisible(true);
    }
    public void changePanel(JPanel jp,String str){
        mine=((EPlayPanel)ep[0]).selectedCard();
        ((EPlayPanel2)ep[1]).getCard(mine);System.out.println("getCard side");

        System.out.println("name:"+jp.getName()+"\n"+"str:"+str);
        String name=jp.getName(); System.out.println("name : "+name);
        if(name==PName[0]){
            ep[0]=(EPlayPanel)jp;
            ((EPlayPanel)ep[0]).setVisible(false);
        }else if(name==PName[1]){
            ep[1]=(EPlayPanel2)jp;
            ((EPlayPanel2)ep[1]).setVisible(false);
        }
        if(str==PName[0]){
            ((EPlayPanel)ep[0]).setVisible(true);
        }else if(str==PName[1]){
            System.out.println(mine.getPosition());
            ((EPlayPanel2)ep[1]).setVisible(true);
        }
    }
}