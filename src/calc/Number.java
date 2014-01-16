package calc;

/**
 * Created with IntelliJ IDEA.
 * User: KaZimad
 * Date: 13.12.13
 * Time: 22:20
 * To change this template use File | Settings | File Templates.
 */
public class Number {
    private double chislo1;
    private double chislo2;           // объявляем что у нас буде 3 числа типа дабл
    private double result;            //ответ сюда буду заносить
    private String mes;

    public Number (double num1, double num2 ){
        chislo1 = num1;
        chislo2 = num2;
    }

    public double otvet (){         //думаю не понадобится
        return result;             // получить ответ
    }
    public String oshibka(){

        return mes;
    }
    public void slojit (double chislo1, double chislo2){
        result = chislo1+ chislo2;
    }
    public void vu4est (double chislo1, double chislo2){
        result = chislo1 - chislo2;
    }
    public void ymnojit (double chislo1, double chislo2){
        result = chislo1*chislo2;
    }
    public void delenije(double chislo1, double chislo2){
        result = chislo1/chislo2;
    }
    public void ostatok_ot_delenija (double chislo1, double chislo2){
        result = chislo1%chislo2;
    }
    public void celochiselnoe_delenie(double chislo1, double chislo2){
        int r = (int) ((int)chislo1/chislo2);
        result = r;
    }
    public void sbros (double chislo1, double chislo2){
        result = 0;
    }
    public void vuhod (){
        System.exit(0);
    }
    public void soobshenije(String s){
       mes = s;
        }
}



