//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

class CUBA extends JFrame implements ItemListener, ActionListener {
    int i;
    int j;
    int ii;
    int jj;
    int x;
    int y;
    int yesnull;
    int[][] a = new int[][]{{10, 1, 2, 3, 11}, {10, 1, 4, 7, 11}, {10, 1, 5, 9, 11}, {10, 2, 5, 8, 11}, {10, 3, 5, 7, 11}, {10, 3, 6, 9, 11}, {10, 4, 5, 6, 11}, {10, 7, 8, 9, 11}};
    int[][] a1 = new int[][]{{10, 1, 2, 3, 11}, {10, 1, 4, 7, 11}, {10, 1, 5, 9, 11}, {10, 2, 5, 8, 11}, {10, 3, 5, 7, 11}, {10, 3, 6, 9, 11}, {10, 4, 5, 6, 11}, {10, 7, 8, 9, 11}};
    boolean state;
    boolean type;
    boolean set;
    Icon ic1;
    Icon ic2;
    Icon icon;
    Icon ic11;
    Icon ic22;
    JLabel judulGame = new JLabel("TIC TAC TOE LEGEND");
    Checkbox c1;
    Checkbox c2;
    JLabel l1;
    JLabel l2;
    JButton[] b = new JButton[9];
    JButton reset;
    String namePlayer1;
    String namePlayer2;
    JLabel showNamePlayer;

    public void namePlayer() {
        if (this.type) {
            this.namePlayer1 = JOptionPane.showInputDialog("Masukan Nama Player 1:");
            this.namePlayer2 = JOptionPane.showInputDialog("Masukan Nama Player 2:");
        } else if (!this.type) {
            this.namePlayer1 = JOptionPane.showInputDialog("Masukan Nama:");
        }

        this.repaint(0, 0, 345, 600);
        this.showButton();
    }

    public void showButton() {
        this.x = 10;
        this.y = 100;
        this.j = 0;
        if (this.type) {
            for(this.i = 0; this.i <= 8; ++this.j) {
                this.b[this.i] = new JButton();
                if (this.j == 3) {
                    this.j = 0;
                    this.y += 103;
                    this.x = 10;
                }

                this.b[this.i].setBounds(this.x, this.y, 100, 100);
                this.b[this.i].setBackground(Color.BLACK);
                this.add(this.b[this.i]);
                this.b[this.i].addActionListener(this);
                ++this.i;
                this.x += 103;
            }

            this.showNamePlayer = new JLabel("GILIRAN " + this.namePlayer1 + " MAIN!");
            this.showNamePlayer.setBounds(110, 10, 450, 100);
            this.add(this.showNamePlayer);
            this.reset = new JButton("RESET");
            this.reset.setBounds(100, 450, 100, 50);
            this.reset.setBackground(Color.RED);
            this.add(this.reset);
            this.reset.addActionListener(this);
        } else {
            for(this.i = 0; this.i <= 8; ++this.j) {
                this.b[this.i] = new JButton();
                if (this.j == 3) {
                    this.j = 0;
                    this.y += 103;
                    this.x = 10;
                }

                this.b[this.i].setBounds(this.x, this.y, 100, 100);
                this.b[this.i].setBackground(Color.BLACK);
                this.add(this.b[this.i]);
                this.b[this.i].addActionListener(this);
                ++this.i;
                this.x += 103;
            }

            this.showNamePlayer = new JLabel("GILIRAN " + this.namePlayer1 + " MAIN!");
            this.showNamePlayer.setBounds(110, 10, 450, 100);
            this.add(this.showNamePlayer);
            this.reset = new JButton("RESET");
            this.reset.setBounds(100, 450, 100, 50);
            this.reset.setBackground(Color.RED);
            this.add(this.reset);
            this.reset.addActionListener(this);
        }

    }

    public void check(int var1) {
        for(this.ii = 0; this.ii <= 7; ++this.ii) {
            for(this.jj = 1; this.jj <= 3; ++this.jj) {
                if (this.a[this.ii][this.jj] == var1) {
                    this.a[this.ii][4] = 11;
                }
            }
        }

    }

    public void complogic(int var1) {
        for(this.i = 0; this.i <= 7; ++this.i) {
            for(this.j = 1; this.j <= 3; ++this.j) {
                if (this.a[this.i][this.j] == var1) {
                    this.a[this.i][0] = 11;
                    this.a[this.i][4] = 10;
                }
            }
        }

        for(this.i = 0; this.i <= 7; ++this.i) {
            this.set = true;
            if (this.a[this.i][4] == 10) {
                int var2 = 0;

                for(this.j = 1; this.j <= 3; ++this.j) {
                    if (this.b[this.a[this.i][this.j] - 1].getIcon() != null) {
                        ++var2;
                    } else {
                        this.yesnull = this.a[this.i][this.j];
                    }
                }

                if (var2 == 2) {
                    this.b[this.yesnull - 1].setIcon(this.ic2);
                    this.check(this.yesnull);
                    this.set = false;
                    break;
                }
            } else if (this.a[this.i][0] == 10) {
                for(this.j = 1; this.j <= 3; ++this.j) {
                    if (this.b[this.a[this.i][this.j] - 1].getIcon() == null) {
                        this.b[this.a[this.i][this.j] - 1].setIcon(this.ic2);
                        this.check(this.a[this.i][this.j]);
                        this.set = false;
                        break;
                    }
                }

                if (!this.set) {
                    break;
                }
            }

            if (!this.set) {
                break;
            }
        }

    }

    public void setCheckBox() {
        this.c1.setBounds(100, 230, 140, 40);
        this.c2.setBounds(100, 300, 140, 40);
        Font var1 = new Font("Sans", 1, 18);
        this.c1.setFont(var1);
        this.c2.setFont(var1);
        this.c1.setBackground(Color.RED);
        this.c2.setBackground(Color.red);
    }

    public void setJudulGame() {
        this.judulGame.setBounds(40, 100, 260, 60);
        Font var1 = new Font("Sans", 1, 24);
        this.judulGame.setFont(var1);
        this.judulGame.setBackground(Color.WHITE);
        this.judulGame.setOpaque(true);
    }

    CUBA() {
        super("TIC TAC TOE BY APRI");
        this.setJudulGame();
        this.add(this.judulGame);
        CheckboxGroup var1 = new CheckboxGroup();
        this.c1 = new Checkbox("Vs Computer", var1, false);
        this.c2 = new Checkbox("Vs Friend", var1, false);
        this.setCheckBox();
        this.add(this.c1);
        this.add(this.c2);
        this.c1.addItemListener(this);
        this.c2.addItemListener(this);
        this.state = true;
        this.type = true;
        this.set = true;
        this.ic1 = new ImageIcon("c1.jpg");
        this.ic2 = new ImageIcon("c2.jpg");
        this.ic11 = new ImageIcon("c11.jpg");
        this.ic22 = new ImageIcon("c22.jpg");
        this.getContentPane().setBackground(Color.ORANGE);
        this.setLayout((LayoutManager)null);
        this.setSize(345, 600);
        this.setVisible(true);
        this.setDefaultCloseOperation(2);
    }

    public void itemStateChanged(ItemEvent var1) {
        if (this.c1.getState()) {
            this.type = false;
        } else if (this.c2.getState()) {
            this.type = true;
        }

        this.remove(this.c1);
        this.remove(this.c2);
        this.remove(this.judulGame);
        this.namePlayer();
    }

    public void actionPerformed(ActionEvent var1) {
        if (this.type) {
            if (var1.getSource() == this.reset) {
                for(this.i = 0; this.i <= 8; ++this.i) {
                    this.showNamePlayer.setText("GILIRAN " + this.namePlayer1 + " MAIN!");
                    this.b[this.i].setIcon((Icon)null);
                }
            } else {
                for(this.i = 0; this.i <= 8; ++this.i) {
                    if (var1.getSource() == this.b[this.i] && this.b[this.i].getIcon() == null) {
                        if (this.state) {
                            this.showNamePlayer.setText("GILIRAN " + this.namePlayer2 + " MAIN!");
                            this.icon = this.ic1;
                            this.state = false;
                        } else {
                            this.showNamePlayer.setText("GILIRAN " + this.namePlayer1 + " MAIN!");
                            this.icon = this.ic2;
                            this.state = true;
                        }

                        this.b[this.i].setIcon(this.icon);
                    }
                }
            }
        } else if (!this.type) {
            if (var1.getSource() == this.reset) {
                for(this.i = 0; this.i <= 8; ++this.i) {
                    this.showNamePlayer.setText("GILIRAN " + this.namePlayer1 + " MAIN!");
                    this.b[this.i].setIcon((Icon)null);
                }

                for(this.i = 0; this.i <= 7; ++this.i) {
                    for(this.j = 0; this.j <= 4; ++this.j) {
                        this.a[this.i][this.j] = this.a1[this.i][this.j];
                    }
                }
            } else {
                for(this.i = 0; this.i <= 8; ++this.i) {
                    if (var1.getSource() == this.b[this.i] && this.b[this.i].getIcon() == null) {
                        this.showNamePlayer.setText("GILIRAN " + this.namePlayer1 + " MAIN!");
                        this.b[this.i].setIcon(this.ic1);
                        if (this.b[4].getIcon() == null) {
                            this.b[4].setIcon(this.ic2);
                            this.check(5);
                        } else {
                            this.complogic(this.i);
                        }
                    }
                }
            }
        }

        for(this.i = 0; this.i <= 7; ++this.i) {
            Icon var2 = this.b[this.a[this.i][1] - 1].getIcon();
            Icon var3 = this.b[this.a[this.i][2] - 1].getIcon();
            Icon var4 = this.b[this.a[this.i][3] - 1].getIcon();
            if (var2 == var3 && var3 == var4 && var2 != null) {
                if (var2 == this.ic1) {
                    this.b[this.a[this.i][1] - 1].setIcon(this.ic11);
                    this.b[this.a[this.i][2] - 1].setIcon(this.ic11);
                    this.b[this.a[this.i][3] - 1].setIcon(this.ic11);
                    JOptionPane.showMessageDialog(this, "!!! " + this.namePlayer1 + " WON !!! CLICK RESET!!!");
                    break;
                }

                if (var2 == this.ic2) {
                    this.b[this.a[this.i][1] - 1].setIcon(this.ic22);
                    this.b[this.a[this.i][2] - 1].setIcon(this.ic22);
                    this.b[this.a[this.i][3] - 1].setIcon(this.ic22);
                    if (this.type) {
                        JOptionPane.showMessageDialog(this, "!!! " + this.namePlayer2 + " WON!!! CLICK RESET!!!");
                    } else {
                        JOptionPane.showMessageDialog(this, "!!!AWK (COMPUTER) WON!!! CLICK RESET!!!");
                    }
                    break;
                }
            }
        }

    }

    public static void main(String[] var0) {
        new TTT1();
    }
}
