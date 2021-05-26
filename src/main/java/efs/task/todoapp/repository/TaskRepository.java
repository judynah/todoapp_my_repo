package efs.task.todoapp.repository;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import efs.task.todoapp.Base64Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

public class TaskRepository implements Repository<UUID, TaskEntity> {

    // lista tasków, a może to ma to być lista słowników? -> id : taskEntity
    List<TaskEntity> taskEntityList = new ArrayList<>();

    @Override
    public UUID save(TaskEntity taskEntity) {
//        String descriptionEncoded = Base64Utils.encode(taskEntity.getDescription());
//        String dueEncoded = Base64Utils.encode(taskEntity.getDue());
//        String authEncoded = (descriptionEncoded + "=:" +dueEncoded);
        UUID taskID = UUID.randomUUID();
        String taskIDtoString = taskID.toString();
        taskEntity.setTaskID(taskIDtoString);
        taskEntityList.add(taskEntity);

        return taskID;

    }

    @Override
    public TaskEntity query(UUID uuid) {
        String uuidStr = uuid.toString();
        for (TaskEntity task : taskEntityList){
            if (uuidStr == task.getTaskID()){
                return task;
            }
        }
        return null;
    }

    @Override
    public List<TaskEntity> query(Predicate<TaskEntity> condition) {
        return null;
    }

    @Override
    public TaskEntity update(UUID uuid, TaskEntity taskEntity) {
        String uuidStr = uuid.toString();
        for (TaskEntity task: taskEntityList){
            if (task.getTaskID() == uuidStr){
                task.setDescription(taskEntity.getDescription());
                task.setDue(taskEntity.getDue());
                return task;
            }
        }
        return null;
    }

    @Override
    public boolean delete(UUID uuid) {
        String uuidStr = uuid.toString();
        for (TaskEntity task: taskEntityList){
            if (task.getTaskID() == uuidStr){
                taskEntityList.remove(task);
                return true;
            }
        }
        return false;
    }
}
