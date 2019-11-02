import javax.swing.ImageIcon;
public class BackCard implements Card{
    public BackCard(){}
    public String getPosition(){
        return "BackCard";
    }
    public ImageIcon getImage(){
        return card[3];
    }
}