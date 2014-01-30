/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import play.db.jpa.Model;

/**
 *
 * @author sorely
 */
@Entity
//Table(name= "Usuarios" )
public class User extends Model {

    public String email;
    public String password;
    public String fullName;
    public Boolean isAdmin;

    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Post> post;

    public User(String email, String password, String fullName, Boolean isAdmin) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.isAdmin = isAdmin;
    }

    public static User validateUserAndPassword(String user, String pass){
    User usuario = User.find("email=? and password = ?", user, pass).first();
    return usuario;
    
    
    }
    
    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

  
}
