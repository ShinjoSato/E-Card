import javax.swing.ImageIcon;
public class Citizen implements Card{
    public Citizen(){}
    public String getPosition(){
        return position[0];
    }
    public ImageIcon getImage(){
        return card[0];
    }
}
