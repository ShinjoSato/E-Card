import javax.swing.ImageIcon;
interface Card extends EcardITF{//eCard
    String[] position={"citizen",
                        "slave",
                        "king"},
            result={"win",
                    "lost",
                    "draw",
                    "victory"};
    String getPosition();
    ImageIcon getImage();
}
