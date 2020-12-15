package bean;

import java.util.Objects;

public class Record {
    private int id;
    private String address;
    private String login;
    private String pass;
    private  String data;
    private  String comment;

    public Record() {
    }

    public Record(int id, String address, String login, String pass,  String comment,String data) {
        this.id = id;
        this.address = address;
        this.login = login;
        this.pass = pass;
        this.comment = comment;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", data='" + data + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return id == record.id &&
                address.equals(record.address) &&
                login.equals(record.login) &&
                pass.equals(record.pass) &&
                data.equals(record.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, address, login, pass, data);
    }
}
