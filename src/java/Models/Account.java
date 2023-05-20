
package Models;


public class Account {
  
     private int idAccount;
     private String username;
     private String password;
     private String name;
     private String email;
     private String address;
     private String phone;
     private int idRole;
     private String avatar;

    public Account() {
    }

    public Account(int idAccount, String username, String password, String name, String email, String address, String phone, int idRole, String avatar) {
        this.idAccount = idAccount;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.idRole = idRole;
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

 

    public int getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(int idAccount) {
        this.idAccount = idAccount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    @Override
    public String toString() {
        return "Account{" + "idAccount=" + idAccount + ", username=" + username + ", password=" + password + ", name=" + name + ", email=" + email + ", address=" + address + ", phone=" + phone + ", idRole=" + idRole + '}';
    }
     
     
    
}
