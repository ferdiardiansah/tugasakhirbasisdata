package Entity;

public class AllUserEntity {
    protected int id;
    protected String nama, password, noTelp, alamat;
    //Protected memiliki sifat tidak dapat diakses dari luar package, bisa diakses dalam class dan packkage
    //2 constructor: 1 contructor dengan parameter, 1 constructor kosong.
    public AllUserEntity(){}
    public AllUserEntity(String nama, String password, String noTelp, String alamat){
        this.nama = nama;
        this.password = password;
        this.noTelp = noTelp;
        this.alamat = alamat;
    }
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public String getNama(){
        return nama;
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    
    public String getNoTelp(){
        return noTelp;
    }
    public void setNoTelp(String noTelp){
        this.noTelp = noTelp;
    }
    
    public String getAlamat(){
        return alamat;
    }
    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
}
