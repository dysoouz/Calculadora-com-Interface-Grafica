package Veiw;

import Model.Calculo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Janela extends JFrame implements ActionListener {
    //attributes

    private int utility, utility_2;
    //utility - Define qual campo vai ser preenchido(tfx ou tfy)
    // utility_2 - Define qual o tipo de calculo

    //Botões de numeração
    private JButton bt0, bt1, bt2, bt3, bt4, bt5, bt6, bt7, bt8, bt9;
    //Botões de excução
    private JButton btAdd, btSub, btDiv, btMul, btEqu, btOff;

    private JTextField tfx, tfy, tfExe, tfEqu;

    private JPanel pnNumber, pnField, pnEmp;

    private JLabel lbEqu;

    private Calculo calculo;

    //method
    public Janela() throws IOException {
        //Instancia os Botões
        bt1 = new JButton("1");
        bt2 = new JButton("2");
        bt3 = new JButton("3");
        bt4 = new JButton("4");
        bt5 = new JButton("5");
        bt6 = new JButton("6");
        bt7 = new JButton("7");
        bt8 = new JButton("8");
        bt9 = new JButton("9");
        bt0 = new JButton("0");

        btAdd = new JButton(" + ");
        btAdd.setBackground(Color.GRAY);
        Font fontbtAdd = btAdd.getFont();
        btAdd.setFont(fontbtAdd.deriveFont(Font.PLAIN, 20f));
        btAdd.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        btSub = new JButton(" - ");
        btSub.setBackground(Color.GRAY);
        Font fontbtSub = btSub.getFont();
        btSub.setFont(fontbtSub.deriveFont(Font.PLAIN, 20f));
        btSub.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        btDiv = new JButton(" / ");
        btDiv.setBackground(Color.GRAY);
        btDiv.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        btMul = new JButton(" x ");
        btMul.setBackground(Color.GRAY);
        btMul.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        btEqu = new JButton(" = ");
        btEqu.setBackground(Color.orange);
        Font fontbtEqu = btEqu.getFont();
        btEqu.setFont(fontbtEqu.deriveFont(Font.PLAIN, 20f));
        btEqu.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        btOff = new JButton(" C ");
        btOff.setBackground(Color.red);
        btOff.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        //Organiza os campos
        tfx = new JTextField(50);
        tfy = new JTextField(50);
        tfExe = new JTextField(50);
        tfExe.setEnabled(false);
        tfEqu = new JTextField(50);
        Font font = tfExe.getFont();
        tfExe.setFont(font.deriveFont(Font.PLAIN, 20f));

        //Organiza os Paineis
        pnField = new JPanel();
        pnField.setPreferredSize(new Dimension(600,50));
        pnField.setLayout(new GridLayout(1,4));
        pnEmp = new JPanel();
        pnEmp.setLayout(new GridLayout(1,1));
        pnEmp.setPreferredSize(new Dimension(200,50));
        pnNumber = new JPanel();
        pnNumber.setLayout(new GridLayout(4,4));
        pnNumber.setPreferredSize(new Dimension(600,300));

        lbEqu = new JLabel(" = ");
        Font fontlbEqu = lbEqu.getFont();
        lbEqu.setFont(font.deriveFont(Font.PLAIN, 20f));

        //Layout dos Paineis
        this.setLayout(new BorderLayout());
        this.add(pnField,BorderLayout.NORTH);
        this.add(pnEmp,BorderLayout.CENTER);
        this.add(pnNumber,BorderLayout.SOUTH);

        //Painel pnField
        pnField.add(tfx);pnField.add(tfExe);pnField.add(tfy);pnField.add(lbEqu);pnField.add(tfEqu);

        //Painel pnNumber
        pnNumber.add(bt7);pnNumber.add(bt8);pnNumber.add(bt9);pnNumber.add(btDiv);
        pnNumber.add(bt4);pnNumber.add(bt5);pnNumber.add(bt6);pnNumber.add(btMul);
        pnNumber.add(bt1);pnNumber.add(bt2);pnNumber.add(bt3);pnNumber.add(btSub);
        pnNumber.add(bt0);pnNumber.add(btEqu);pnNumber.add(btOff);pnNumber.add(btAdd);

        //Evento dos Botões
        bt0.addActionListener(this);
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        bt3.addActionListener(this);
        bt4.addActionListener(this);
        bt5.addActionListener(this);
        bt6.addActionListener(this);
        bt7.addActionListener(this);
        bt8.addActionListener(this);
        bt9.addActionListener(this);

        btAdd.addActionListener(this);
        btSub.addActionListener(this);
        btDiv.addActionListener(this);
        btMul.addActionListener(this);
        btEqu.addActionListener(this);
        btOff.addActionListener(this);

        //Ícone da Janela
        Image icon;
        icon = ImageIO.read(new File("C:\\Users\\jota1\\IdeaProjects\\CALCULADORA\\src\\Icone\\icone.png"));


        //Organiza a Janela
        this.setSize(600,400);
        this.setIconImage(icon);
        this.setTitle("CALCULADORA");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void setIconImage(String s) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        if (source == bt0 || source == bt1 || source == bt2 || source == bt3 ||
                source == bt4 || source == bt5 || source == bt6 || source == bt7 ||
                source == bt8 || source == bt9) {

            JButton buttonClicked = (JButton) source;
            String buttonText = buttonClicked.getText();

            if(utility == 0) {
                tfx.setText(tfx.getText() + buttonText);
            } else {
                tfy.setText(tfy.getText() + buttonText);
            }
        }
        if (source == btAdd) {
            tfExe.setText(tfExe.getText() + " + ");
            utility++;
            utility_2 = 1;
        }
        if (source == btSub) {
            tfExe.setText(tfExe.getText() + " - ");
            utility++;
            utility_2 = 2;
        }
        if (source == btMul) {
            tfExe.setText(tfExe.getText() + " x ");
            utility++;
            utility_2 = 3;

        }
        if (source == btDiv) {
            tfExe.setText(tfExe.getText() + " / ");
            utility++;
            utility_2 = 4;
        }
        if (source == btOff) {
            tfx.setText("");
            tfy.setText("");
            tfExe.setText("");
            tfEqu.setText("");
            utility = 0;
        }
        if (source == btEqu) {
            calculo = new Calculo(Double.parseDouble(tfx.getText()),Double.parseDouble(tfy.getText()),utility_2);
            tfEqu.setText(calculo.toString());
            utility--;
        }
    }

}
