package Controller;

public interface ControllerInterface {
    //class ini berisi method abstract dan hanya berisi deklarasi method
    int login(String username, String password);
    void insertData(String nama, String password, String noTelp, String alamat, String jenis_kelamin);
}
