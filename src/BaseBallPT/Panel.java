package BaseBallPT;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    JTextField field;
    int strike = 0;
    int ball = 0;
    int out = 0;

    void setData(int strike, int ball, int out) {
        this.strike = strike;
        this.ball = ball;
        this.out = out;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setFont(new Font("맑은고딕", Font.BOLD, 20));

        if (strike == 3) {
            g.setColor(Color.lightGray);
            g.setFont(new Font("맑은고딕", Font.BOLD, 65));
            g.drawString("HOME RUN", 30, 100);
        } else {

            if (strike == 0) {
                g.setColor(Color.RED);

                g.drawString("S", 30, 222);

                g.drawOval(50, 200, 30, 30);

                g.drawOval(90, 200, 30, 30);

            } else if (strike == 1) {
                g.setColor(Color.RED);

                g.drawString("S", 30, 222);

                g.fillOval(50, 200, 30, 30);

                g.drawOval(90, 200, 30, 30);

            } else {
                g.setColor(Color.RED);

                g.drawString("S", 30, 222);

                g.fillOval(50, 200, 30, 30);

                g.fillOval(90, 200, 30, 30);

            }

            if (ball == 0) {
                g.setColor(Color.BLUE);

                g.drawString("B", 30, 262);

                g.drawOval(50, 240, 30, 30);

                g.drawOval(90, 240, 30, 30);

                g.drawOval(130, 240, 30, 30);

            } else if (ball == 1) {
                g.setColor(Color.BLUE);

                g.drawString("B", 30, 262);

                g.fillOval(50, 240, 30, 30);

                g.drawOval(90, 240, 30, 30);

                g.drawOval(130, 240, 30, 30);

            } else if (ball == 2) {
                g.setColor(Color.BLUE);

                g.drawString("B", 30, 262);

                g.fillOval(50, 240, 30, 30);

                g.fillOval(90, 240, 30, 30);

                g.drawOval(130, 240, 30, 30);

            } else {
                g.setColor(Color.BLUE);

                g.drawString("B", 30, 262);

                g.fillOval(50, 240, 30, 30);

                g.fillOval(90, 240, 30, 30);

                g.fillOval(130, 240, 30, 30);

            }

            if (out == 0) {
                g.setColor(Color.ORANGE);

                g.drawString("O", 30, 302);

                g.drawOval(50, 280, 30, 30);

            } else {
                g.setColor(Color.ORANGE);

                g.drawString("O", 30, 302);

                g.fillOval(50, 280, 30, 30);

            }
        }


    }
}
