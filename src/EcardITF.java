import javax.swing.ImageIcon;

interface EcardITF {
        String relative_path = "../images/";
        String[] CardPic = { relative_path + "citizen02.png", relative_path + "slave02.png",
                        relative_path + "king02.png", relative_path + "backcard02.png" },
                        TablePic = { relative_path + "etable.png", relative_path + "table02.png" },
                        RoomPic = { relative_path + "room1.jpg" },
                        PlayerPic = { relative_path + "kagawa01.png", relative_path + "tatsuya01.png" },
                        Quote = { relative_path + "zawa.png" }, Win = { relative_path + "win01.png" },
                        Lose = { relative_path + "lose01.png" };
        ImageIcon[] card = { new ImageIcon(CardPic[0]), new ImageIcon(CardPic[1]), new ImageIcon(CardPic[2]),
                        new ImageIcon(CardPic[3]) }, table = { new ImageIcon(TablePic[1]) },
                        room = { new ImageIcon(RoomPic[0]) },
                        player = { new ImageIcon(PlayerPic[0]), new ImageIcon(PlayerPic[1]) },
                        quote = { new ImageIcon(Quote[0]) }, win = { new ImageIcon(Win[0]) },
                        lose = { new ImageIcon(Lose[0]) };

        int width = 900, height = 600, // Back Ground!
                        twidth = 700, theight = 300, tx = 100, ty = 200, // Table Integer!
                        pwidth = 250, pheight = 180, // Player!
                        mcwidth = 120, mcheight = 160, // My Cards!
                        ycwidth = 60, ycheight = 80;// Your Cards!
        int mpx2 = 0, mpy2 = height / 2, // My Place on 2!
                        ypx2 = width - pwidth, ypy2 = height / 2, // Your Place on 2!
                        mcx2 = width / 4, mcy2 = height / 6, // My Card Place on 2!
                        ycx2 = width * 3 / 4 - 110, ycy2 = height / 6;// Your Card on 2!
}
