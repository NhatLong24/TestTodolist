package com.example.Todolist.Controller;

import com.example.Todolist.Model.Todolist;
import com.example.Todolist.Service.ITodolistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todolist")
public class TodolistController {

    @Autowired
    private ITodolistService iTodolistService;

    @GetMapping("/")
    public String test(){
        return "Long lalalala";
    }

    //API add 1 todolist
    @PostMapping("/add")
    public Todolist addTodolist(@RequestBody Todolist todolist)
    {
        return this.iTodolistService.addTodolist(todolist);
    }

    //API update 1 todolist
    @PutMapping("/update")
    public Todolist updateEmployee(@RequestBody Todolist todolist){
        return this.iTodolistService.updateTodolist(todolist);
    }

    //API delete 1 todolist
    @DeleteMapping("/delete")
    public void deleteTodolist(@RequestBody Todolist todolist)
    {
        this.iTodolistService.deleteTodolist(todolist);
    }

    //API tim kiếm todolist theo đkiện
    @GetMapping("/find")
    //API tim kiem 1 todolist theo dieu kien
    public List<Todolist> findTodolist (@RequestParam(name = "limit") int limit,
                                        @RequestParam(name = "min") long min,
                                        @RequestParam(name = "max") long max,
                                        @RequestParam(name = "check") boolean check){
       return this.iTodolistService.findTodolist( limit,  min,  max,  check);
    }
}
