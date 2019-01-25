import java.applet.Applet;
import java.awt.*;

/**
 * @author zhukai
 * @date 2019/1/22
 */
public class MyApplet extends Applet {

    public void init() {
        setBackground(Color.gray);
    }

    public void paint(Graphics g) {
        g.setColor(Color.blue);
        g.drawString("Hello world!", 30, 60);
        g.setColor(Color.red);
        g.drawString("This is my first Applet code", 30, 80);
    }
}
