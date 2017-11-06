package com.bsuir.library.domain.User;

/**
 * this class summarizes information about the user
 */
public class User implements java.io.Serializable{
    /**
     * Enumeration of available roles
     */
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

    /**
     * Getting the role
     * @return Current user role
     */
    public Role getRole(){
        return  role;
    }

    /**
     * Calculates the hash value of a function
     * @return value of the hash function
     */
    @Override
    public int hashCode() {
        int result = 17;
        final int prime = 31;
        result = prime * result + login.hashCode();
        return result;
    }

    /**
     * Compares objects
     * @param obj  object to compare
     * @return comparison result
     */
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

        return true;
    }
    public String getEmail(){
        return  email;
    }
    private String email;
}
