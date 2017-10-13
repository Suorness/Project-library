package com.bsuir.library.domain;

public class User implements java.io.Serializable{

    public enum Role {GUEST,ADMIN,USER}

    private String login;
    private String hash;
    private Role role;

    public User(String login,String hash, Role role){
        this.login = login;
        this.hash  = hash;
        this.role  = role;

    }
    public User(String login,String hash){
        this.login=login;
        this.hash=hash;
        this.role = Role.USER;
    }

    public Role getRole(){
        return  role;
    }
    @Override
    public int hashCode() {
        int result = 17;
        final int prime = 31;
        result = prime * result + login.hashCode();
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User userOnCheck = (User) obj;
        if (login == null) {
            if (userOnCheck.login != null) {
                return false;
            }
        } else if (!login.equals(userOnCheck.login)) {
            return false;
        }
//        if (hash == null) {
//            if (userOnCheck.hash != null) {
//                return false;
//            }
//        } else if (!hash.equals(userOnCheck.hash)) {
//            return false;
//        }
        return true;
    }

}
