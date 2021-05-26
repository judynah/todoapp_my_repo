package efs.task.todoapp.repository;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ser.Serializers;
import efs.task.todoapp.Base64Utils;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"username", "password"})
public class UserEntity {

        @JsonProperty("username")
        private String username;
        @JsonProperty("password")
        private  String password;

        private String userID;

        public UserEntity(String u, String p){
                this.username = u;
                this.password = encodePassword(p);
        }


        // gettery
        public String getUsername() {
                return this.username;
        }
        public String getPassword(){
                return this.password;
        }
        public String getUserID() {return this.userID; }
        // settery
        public void setUsername(String u){
                this.username = u;
        }
        public void setPassword(String p) {
                this.password = p;
        }
        public void setUserID(String id) {this.userID = id; }

        // kodowanie hasła
        public String encodePassword(String p){
                return Base64Utils.encode(p);
        }

        // dekodowanie hasła
        public String decodePassword(String p){
                return Base64Utils.decode(p);
        }


}
