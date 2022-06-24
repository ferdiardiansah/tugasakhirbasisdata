package Entity;
//Extends untuk memanggil fungsi atau mehod dari class induk yaitu class AllUserEntity
public class UserEntity extends AllUserEntity {
    private int status;
    private String jenis_kelamin;
    //Private memiliki sifat tidak dapat diakses dari manapun kecuali dari Method Accessor(getter-setter) dan dari class itu sendiri
    
    public UserEntity(){};
    //Default Constructor tipedata int akan bernilai 0 dan String akan menjadi character.
    
    public int getStatus(){
        return status;
    }
    public void setStatus(int status){
        this.status = status;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }
}
