package Model;

import Helper.KoneksiData;
import java.sql.Connection;
public abstract class ModelAbstract{
    //class setengah jadi memiliki method dan atribut untuk mengimplemntasikannya dengan inheritance yaitu Extends
    public Connection conn = KoneksiData.getconection();
    public abstract void updatePassword(String password, int id);
    public abstract int cekLogin(String username, String password);
}
