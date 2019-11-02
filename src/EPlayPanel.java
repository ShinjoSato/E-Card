import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.*;
public class EPlayPanel extends JPanel implements MouseListener, MouseMotionListener, EPanel{
    EFrame ef;
    String str;
    private int[] mx={tx+65,tx+65+mcwidth*1,tx+65+mcwidth*2,tx+65+mcwidth*3,tx+65+mcwidth*4},
                  my={0,0,0,0,0};
    private int movedy;
    private JButton b1,b2,b3,b4;
    private Card mine;
    public EPlayPanel(EFrame ef,String str){
        this.ef=ef;
        this.str=str;
        this.setName(str);
        this.setBackground(Color.green);
        this.setLayout(null);
        this.setSize(width,height);
        addMouseListener(this);
        addMouseMotionListener(this);
    }
    public void pc(String str){
        ef.changePanel((JPanel)this,str);
    }
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseDragged(MouseEvent e){}
    public void mouseMoved(MouseEvent e){
        int x=e.getX(),y=e.getY();
        if(x>=mx[0]&&x<=mx[1]&&y>=theight+30&&y<=theight+30+mcheight){my[0]=-mcheight/2;}else{my[0]=0;}
        if(x>=mx[1]&&x<=mx[2]&&y>=theight+30&&y<=theight+30+mcheight){my[1]=-mcheight/2;}else{my[1]=0;}
        if(x>=mx[2]&&x<=mx[3]&&y>=theight+30&&y<=theight+30+mcheight){my[2]=-mcheight/2;}else{my[2]=0;}
        if(x>=mx[3]&&x<=mx[4]&&y>=theight+30&&y<=theight+30+mcheight){my[3]=-mcheight/2;}else{my[3]=0;}
        if(x>=mx[4]&&x<=mx[4]+mcwidth&&y>=theight+30&&y<=theight+30+mcheight){my[4]=-mcheight/2;}else{my[4]=0;}
        repaint();
    }
    public void mouseClicked(MouseEvent e){
        if (e.getClickCount() >= 2){
            int x=e.getX(),y=e.getY();
            if(x>=mx[0]&&x<=mx[1]&&y>=theight+30&&y<=theight+30+mcheight){
                System.out.println("No.1");
                mine=new Citizen();
                pc(ef.PName[1]);
            }
            if(x>=mx[1]&&x<=mx[2]&&y>=theight+30&&y<=theight+30+mcheight){
                System.out.println("No.2");
                mine=new Citizen();
                pc(ef.PName[1]);
            }
            if(x>=mx[2]&&x<=mx[3]&&y>=theight+30&&y<=theight+30+mcheight){
                System.out.println("No.3");
                mine=new Citizen();
                pc(ef.PName[1]);
            }
            if(x>=mx[3]&&x<=mx[4]&&y>=theight+30&&y<=theight+30+mcheight){
                System.out.println("No.4");
                mine=new Slave();
                pc(ef.PName[1]);
            }
            if(x>=mx[4]&&x<=mx[4]+mcwidth&&y>=theight+30&&y<=theight+30+mcheight){
                System.out.println("No.5");
                mine=new Citizen();
                pc(ef.PName[1]);
            }
        }
    }
    public Card selectedCard(){
        System.out.println("In selectedCard");
        return mine;
    }
    public void paintComponent(Graphics g){
        g.drawImage(room[0].getImage(),0,0,900,700,this);
        g.drawImage(player[0].getImage(),320,40,250,180,this);
        g.drawImage(table[0].getImage(),tx,ty,twidth,theight,this);
        for(int i=0;i<5;i++) g.drawImage(card[3].getImage(),tx+200+ycwidth*i,ty-20,ycwidth,ycheight,this);
        for(int i=0;i<5;i++){
            if(i==3) g.drawImage(card[1].getImage(),mx[i],theight+30+my[i],mcwidth,mcheight,this);
            else g.drawImage(card[0].getImage(),mx[i],theight+30+my[i],mcwidth,mcheight,this);
        }
        
        setLayout(null);
    }
    class MainActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("Othello");
            pc(ef.PName[1]);
        }
    }
}
