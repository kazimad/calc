package calc;

/**
 * Created with IntelliJ IDEA.
 * User: KaZimad
 * Date: 13.12.13
 * Time: 22:20
 * To change this template use File | Settings | File Templates.
 */
import com.sun.java.swing.plaf.windows.resources.windows;
import com.sun.org.apache.xpath.internal.SourceTree;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calc implements ActionListener{

    private JFrame frame;
    private JPanel mainPanel;
    private JLabel label1,label2,label3;
    private JTextField textField1, textField2;/*textField3*/;
    private JButton plus,minus,delit,celochiselnoe_delenie,ymnojit,ostatok_ot_delenija,sbros,vuhod;

    public static void main(String[] args) {
        //запуск программы в safe потоке
        javax.swing.SwingUtilities.invokeLater(new Runnable() {    //выделяет отдельный поток для всего того что написано всередине  SwingUtilities.invokeLater - вроде так

            public void run() {
                setGUI();
            }
        });
    }

    private static void setGUI() {
        Calc gui = new Calc();
    }

    public Calc (){                                     // конструктор того что будет отображатся
        frame = new JFrame("Калькулятор");
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 4));     // 3строки - 4 столбца, но надо проверить!
        frame.getContentPane().add(mainPanel);
        components();                                   //компоненты окна - будут описаны ниже
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getPreferredSize();                       //!!!сам вписал
        frame.setLocation(300, 300);
        frame.pack();
        frame.setVisible(true);
    }

        private void components(){
            label1 = new JLabel("Число 1:");
            textField1 = new JTextField();
            label2 = new JLabel("Число 2:");
            textField2 = new JTextField();
            plus = new JButton("СЛОЖИТЬ");                                         //присвоил каждой функции отображение на экране
            minus = new JButton("ВЫЧЕСТЬ");
            delit = new JButton("ДЕЛЕНИЕ");
            celochiselnoe_delenie = new JButton("ЦЕЛОЧИСЕЛЬНОЕ ДЕЛЕНИЕ");
            ymnojit = new JButton("УМНОЖЕНИЕ");
            ostatok_ot_delenija = new JButton("ОСТАТОК ОТ ДЕЛЕНИЯ");
            sbros = new JButton("СБРОС");
            label3 = new JLabel("ОТВЕТ");
            //textField3 = new JTextField();
            vuhod = new JButton("ВЫХОД");

            textField1.setHorizontalAlignment(JLabel.LEFT);      // выравнивание полей воода ....!
            textField2.setHorizontalAlignment(JLabel.LEFT);
            label1.setHorizontalAlignment(JLabel.RIGHT);
            label2.setHorizontalAlignment(JLabel.RIGHT);
            label3.setHorizontalAlignment(JLabel.CENTER);

           /* textField3.setForeground(Color.blue);
            textField3.setBackground(Color.GRAY);*/

            //  добавление компонентов на панель...надо въхать хоть что это такое

            mainPanel.add(label1);
            mainPanel.add(textField1);
            mainPanel.add(label2);
            mainPanel.add(textField2);
            mainPanel.add(plus);
            mainPanel.add(minus);
            mainPanel.add(delit);
            mainPanel.add(celochiselnoe_delenie);
            mainPanel.add(ymnojit);
            mainPanel.add(ostatok_ot_delenija);
            mainPanel.add(sbros);
            mainPanel.add(vuhod);
            mainPanel.add(label3);
           // mainPanel.add(textField3);

            // слушатели событий
            plus.addActionListener(this);
            minus.addActionListener(this);
            delit.addActionListener(this);
            celochiselnoe_delenie.addActionListener(this);
            ymnojit.addActionListener(this);
            ostatok_ot_delenija.addActionListener(this);
            sbros.addActionListener(this);
            vuhod.addActionListener(this);


}
    Number cifru = new Number(0,0);                               // !!ВАЖно, стоит запомнить..... тут инициализируются элементы класса в который будут передаваться значение в будущем

    /*public void otvet (){
    String otvet =String.format("%.d",cifru.otvet());               // закоментил, на всякий случай не удалял...хз что это
    label3.setText(otvet);
        }*/



    @Override
   public void actionPerformed(ActionEvent e) {
     /*String Number_textField1 = textField1.getText();     // так пишет книжка, но что то мне не нравится
     String Number_textField2 = textField2.getText();*/

        try {

            double chislo1 = Double.parseDouble(textField1.getText());  // берем значение из строки ввода и инвертируем ее в Даблы
            if (!isDouble(textField1.getText())){cifru.soobshenije(" Введите число в первую строку ");}
            if (!isInteger(textField1.getText())){cifru.soobshenije("Введите число в первую строку ");}
            double chislo2 = Double.parseDouble(textField2.getText());
            if (!isDouble(textField2.getText())){cifru.soobshenije("Введите число во вторую строку ");}
            if (!isInteger(textField2.getText())){cifru.soobshenije("Введите число во вторую строку ");}

            if (e.getSource() == plus) {
                cifru.slojit(chislo1, chislo2);
                label3.setText(chislo1 + " + " + chislo2 + " = " + cifru.otvet());
            }

            if (e.getSource() == minus) {
                cifru.vu4est(chislo1, chislo2);
                label3.setText(chislo1 + " - " + chislo2 + " = " + cifru.otvet());
            }
            if (e.getSource() == ymnojit) {
                cifru.ymnojit(chislo1, chislo2);
                label3.setText(chislo1 + " * " + chislo2 + " = " + cifru.otvet());
            }
            if (e.getSource() == delit) {
                cifru.delenije(chislo1, chislo2);
                label3.setText(chislo1 + " / " + chislo2 + " = " + cifru.otvet());
            }
            if (e.getSource() == ostatok_ot_delenija) {
                cifru.ostatok_ot_delenija(chislo1, chislo2);
                label3.setText(chislo1 + " / " + chislo2 + " = " + cifru.otvet());
            }
            if (e.getSource() == vuhod) {
                cifru.vuhod();
                System.exit(0);
             }
            if (e.getSource() == celochiselnoe_delenie) {
                cifru.celochiselnoe_delenie(chislo1, chislo2);
                label3.setText(chislo1 + " / " + chislo2 + " = " + cifru.otvet());
            }
            if (e.getSource() == sbros) {
                cifru.sbros(chislo1, chislo2);
                label3.setText(String.valueOf(cifru.otvet()));
                chislo1=0;
                chislo2=0;
                textField1.setText("0");
                textField2.setText("0");
            }
        } catch (NumberFormatException w) {
            JOptionPane.showMessageDialog(frame, "вы ошиблись при вооде одного из чисел", "Ошибка", JOptionPane.WARNING_MESSAGE);
            //JOptionPane.showMessageDialog(frame, cifru.oshibka(), "Ошибка", JOptionPane.WARNING_MESSAGE); // - надо понять почему не работает  хз
        }
    }





    //проверка строки на тип Double
    private boolean isDouble(String num) {
        try {
            Double.parseDouble(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //проверка строки на тип Integer
    private boolean isInteger(String num) {
        try {
            Integer.parseInt(num);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}


//JOptionPane.showMessageDialog(frame, "Вы не ввели одно из1111 обязательных значений", "Сообщение", JOptionPane.INFORMATION_MESSAGE);

// для гита ...
// и еще ...
