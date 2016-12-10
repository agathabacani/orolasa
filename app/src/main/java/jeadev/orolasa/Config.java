package jeadev.orolasa;

/**
 * Created by Arlene on 10/12/2016.
 */
public class Config {

    public static String ip="192.168.1.101";
    public  static  String URL(String php_name){
        return  "http://"+ip+"/UB/"+php_name+".php";
    }
    public static String ID="0";
    public static String lincenseID="";
    public static String Message="";
    public static String Last_year="";
}
