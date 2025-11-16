package com.myproject.tasks.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.tasks.dto.TasksDTO;
import com.myproject.tasks.facade.TaskFacade;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;




@Controller
@RequestMapping(value = "/tarefas", produces = MediaType.APPLICATION_JSON_VALUE)
public class TasksApi {
    @Autowired

    private TaskFacade TaskFacade;

    @PostMapping
    @ResponseBody
     public TasksDTO create(@RequestBody TasksDTO tasksDTO){
        return TaskFacade.create(tasksDTO);

    }

    @PutMapping("/{taskId}")
    @ResponseBody
    public TasksDTO update(@PathVariable("taskId") Long taskId,@RequestBody TasksDTO tasksDTO){
        return TaskFacade.update(tasksDTO,taskId);

    }

    @GetMapping
    @ResponseBody
    public List<TasksDTO> getAll(){
        return TaskFacade.getAll();
    }

    @DeleteMapping("/{taskId}")
    @ResponseBody
    public String delete(@PathVariable("taskId") Long taskId){

        return TaskFacade.delete(taskId);

    }

    
    
 
}
