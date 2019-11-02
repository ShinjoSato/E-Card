import javax.swing.Timer;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class EPlayPanel2 extends JPanel implements MouseListener, MouseMotionListener, EPanel, ActionListener{
    EFrame ef;
    String str;
    Timer tim;
    private int sec,msize,ysize,battle;
    JButton b1,b2,b3,b4;
    int[] x=new int[2],y=new int[2];
    public Card mine,yours;
    EPanel ep[]=new EPanel[4];
    public EPlayPanel2(EFrame ef,String str){
        this.ef=ef;
        this.str=str;
        this.setName(str);
        this.setBackground(Color.green);
        this.setLayout(null);

        this.setSize(width,height);
        addMouseListener(this);
        addMouseMotionListener(this);

        tim=new Timer(100,this);
        sec=0;
        mine=ef.mine;
        ep[0]=new EPlayPanel(ef,str);

        msize=0; ysize=0;
    }
    public void pc(String str){
        ef.changePanel((JPanel)this,str);
    }
    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseDragged(MouseEvent e){}
    public void mouseMoved(MouseEvent e){}
    public void mouseClicked(MouseEvent e){
        //System.out.println(e.getX()+" : "+e.getY());
        sec=0;
        msize=0;
        ysize=0;
        tim.start();
    }
    public void getCard(Card mine){
        mine=this.mine;
       // System.out.println("In getCard");
        System.out.println(mine.getPosition());
    }
    public void actionPerformed(ActionEvent e){
        //System.out.println(sec + " sec");
        x[0]=0; y[0]=0;
        x[1]=0; y[1]=0;
        if(sec<=30){
            x[1]=(int)(Math.random()*10)+5;
            y[1]=(int)(Math.random()*10)+5;
        }else if(sec<=60){

        }else if(sec<=90){
            x[0]=(int)(Math.random()*10)+5;
            y[0]=(int)(Math.random()*10)+5;
        
        }else if(sec<120){  
        }else if(sec==120){
            eCard ec=new eCard();
            battle=ec.battle(mine,yours);
            System.out.println(battle);
            if(battle==1){
                System.out.println("WIN");
                msize=1;
            }else if(battle==-1){
                System.out.println("LOST");
                ysize=1;
            }else{
                System.out.println("DRAW");
            }
        }else{
            tim.stop();
        }
        sec++;
        repaint();
    }
    public void paintComponent(Graphics g){
        mine=ef.mine;
        if(sec==1){
            int num=(int)(Math.random()*5);
            if(num==0) yours=new King();
            else yours=new Citizen();
        }
        //yours=new King();

        g.drawImage(room[0].getImage(),0,0,900,700,this);
        g.drawImage(player[1].getImage(),mpx2,mpy2,pwidth,pheight,this);
        g.drawImage(player[0].getImage(),ypx2,ypy2,pwidth,pheight,this);
        
        if(sec>=91) g.drawImage(mine.getImage().getImage(),mcx2+x[0],mcy2+y[0],110,220,this);
        else g.drawImage(card[3].getImage(),mcx2+x[0],mcy2+y[0],110,220,this);

        if(sec>=31) g.drawImage(yours.getImage().getImage(),ycx2+x[1],ycy2+y[1],110,220,this);
        else g.drawImage(card[3].getImage(),ycx2+x[1],ycy2+y[1],110,220,this);

        g.drawImage(win[0].getImage(),width/4,0,width/2*msize,height/6*msize,this);
        g.drawImage(lose[0].getImage(),width/4,0,width/2*ysize,height/6*ysize,this);

        b1=new JButton("Back");
        b1.setFont(new Font("Arial",Font.ITALIC,50));
        b1.setBounds(0,0,200,60);
        b1.setContentAreaFilled(false);
        b1.setBorderPainted(false);
        add(b1);

        b1.addActionListener(new MainActionListener());
        setLayout(null);
    }
    class MainActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            System.out.println("PlayPanel2");
            sec=0;
            msize=0;
            ysize=0;
            pc(ef.PName[0]);
        }
    }

}