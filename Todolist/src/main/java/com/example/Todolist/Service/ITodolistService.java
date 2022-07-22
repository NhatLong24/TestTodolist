package com.example.Todolist.Service;

import com.example.Todolist.Model.Todolist;

import java.util.List;

public interface ITodolistService {
    //them 1 todolist
     Todolist addTodolist(Todolist todolist);
    //sua todolist
    Todolist updateTodolist(Todolist todolist);
    //xoa todolist
    void deleteTodolist(Todolist todolist);
    //tim kiem theo dieu kien
    List<Todolist> findTodolist(int limit, long min, long max, boolean check);

}
