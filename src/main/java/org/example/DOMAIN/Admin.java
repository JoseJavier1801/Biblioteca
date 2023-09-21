package org.example.DOMAIN;

public class Admin extends person{
    /**
     * Clase admin que hereda la clase user
     */
        public Admin(int id, String username, String password, String DNI, String email) {
            super(id, username, password, DNI, email);
        }



        public Admin() {
            this(0," "," "," "," ");
        }



        @Override
        public String toString() {
            return  super.toString();
        }
}
