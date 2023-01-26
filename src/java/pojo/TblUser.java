package pojo;
// Generated Oct 15, 2022 11:20:55 PM by Hibernate Tools 4.3.1

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import DAO.DAOLogin;
import DAO.DAOuser;
import java.util.List;
import javax.faces.application.FacesMessage;

@ManagedBean(name="TblUser")@ViewScoped

/**
 * TblUser generated by hbm2java
 */
public class TblUser  implements java.io.Serializable {


     private Integer idUser;
     private String email;
     private String name;
     private String password;
    
     
  public String save_user()
    {
        DAOLogin add= new DAOLogin();
        add.add_user(this);
        return "login.xhtml";
    }
     
  public String login_user(){
      DAOLogin uDAO= new DAOLogin();
      List<TblUser> us=uDAO.getBy(name,password);
      try {
          if (us !=null){
              name=us.get(0).name;
              password=us.get(0).password;
              return "index.xhtml";
          }
      } catch (Exception e){
          System.out.println(e);
          
      }
     return "login_gagal.xhtml";     
  }
    /**Get All Data for admin_page**/  
    public List<TblUser> getAllRecords()
    {
        DAOuser usr = new DAOuser();
        List<TblUser> Usr = usr.retrveTblUser();
        return Usr;
    }       
    
    /**
     *
     * @return
     */
    /**Get Data by user_id**/
    public String getById()
    {
        String user_id = idUser.toString();
        DAOuser usr = new DAOuser();
        List<TblUser> Usr = usr.getbyID(user_id);
        name = Usr.get(0).name;
        password = Usr.get(0).password;
        email = Usr.get(0).email;
        return "admin_page.xhtml";
    }
    /**For edit Data**/
    public String edit()
    {
        DAOuser usr = new DAOuser();
        usr.editUser(this);
        name = "";
        password = "";
        email = "";
        //FacesMessage facesmessage = new FacesMessage(FacesMessage.SEVERITY_INFO,"Berhasil Update Data",null);
        return "admin_page.xhtml";
    }
    /**For delete Data**/
    public String delete()
    {
        String user_id = idUser.toString();
        DAOuser usr = new DAOuser();
        usr.deleteUser(idUser);
        name = "";
        password = "";
        email = "";
        return "admin_page.xhtml";
    }        
    
    public TblUser() {
    }

    public TblUser(Integer iduser,String email, String name, String password) {
       this.idUser = iduser; 
       this.email = email;
       this.name = name;
       this.password = password;
    }
   
    public Integer getIdUser() {
        return this.idUser;
    }
    
    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }




}


