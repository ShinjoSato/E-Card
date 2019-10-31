import javax.swing.ImageIcon;
public class eCard implements Card{//rule
    public eCard(){}
    public int battle(Card mine,Card yours){
        String m=mine.getPosition(),
               y=yours.getPosition();
        if(m==y){// citizen vs citizen
            return 0;
        }else if(m==position[2]&&y==position[1]){// king vs slave
            return -1;
        }else if(m==position[2]&&y==position[0]){// king vs citizen
            return 1;
        }else if(m==position[1]&&y==position[2]){// slave vs king
            return 1;
        }else if(m==position[1]&&y==position[0]){//slave vs citizen
            return -1;
        }else if(m==position[0]&&y==position[2]){// citizen vs king
            return -1;
        }else if(m==position[0]&&y==position[1]){// citizen vs slave
            return 1;
        }
        return 0;
    }
    public String getPosition(){
        String str="NULL";
        return str;
    }
    public ImageIcon getImage(){
        return card[3];
    }
}

