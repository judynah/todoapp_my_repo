package efs.task.todoapp.repository;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.Stack;
import java.util.UUID;

@JsonPropertyOrder({"description", "due"})
public class TaskEntity {

        @JsonProperty("description")
        private String description;
        @JsonProperty("due")
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
        private String due;

        private String taskID;



        TaskEntity(String d, String due){
            this.description = d;
            this.due = due;
        }

        public String getDescription(){
            return this.description;
        }
        public String getDue(){
            return this.due;
        }
        public String getTaskID() {return this.taskID;}

        public void setTaskID(String id){this.taskID = id;}

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDue(String due) {
        this.due = due;
    }
}
