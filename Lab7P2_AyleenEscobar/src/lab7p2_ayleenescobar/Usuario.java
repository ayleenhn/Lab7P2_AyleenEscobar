
package lab7p2_ayleenescobar;

public class Usuario {
    private String name, user, password;
    private double Saldo_Compras;

    public Usuario() {
    }

    public Usuario(String name, String user, String password, double Saldo_Compras) {
        this.name = name;
        this.user = user;
        this.password = password;
        this.Saldo_Compras = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSaldo_Compras() {
        return Saldo_Compras;
    }

    public void setSaldo_Compras(double Saldo_Compras) {
        this.Saldo_Compras = Saldo_Compras;
    }

    @Override
    public String toString() {
        return user;
    }        
}
