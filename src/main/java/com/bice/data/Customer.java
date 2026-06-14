package com.bice.data;

public class Customer {

    private String name;
    private String addr;
    private String city;
    private String state;
    private String pinno;
    private String telephoneno;
    private String emailid;
    private String dob;
    private String password;


    public String getName() { return name; }
    public String getAddr() { return addr; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getPinno() { return pinno; }
    public String getTelephoneno() { return telephoneno; }
    public String getEmailid() { return emailid; }
    public String getDob() { return dob; }
    public String getPassword() { return password; }

    public void setName (String name) {this.name = name;}
    public void setAddr (String addr) {this.addr = addr;}
    public void setCity(String city) { this.city = city; }
    public void setState(String state) { this.state = state; }
    public void setPinno(String pinno) { this.pinno = pinno; }
    public void setTelephoneno(String telephoneno) { this.telephoneno = telephoneno; }
    public void setEmailid(String emailid) { this.emailid = emailid; }
    public void setDob(String dob) { this.dob = dob; }
    public void setPassword(String password) { this.password = password; }
    
}
