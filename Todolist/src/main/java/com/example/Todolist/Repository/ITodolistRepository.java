package com.example.Todolist.Repository;


import com.example.Todolist.Model.Todolist;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

public interface ITodolistRepository {


    Todolist save(Todolist todolist);

    Todolist findOne(Query query);

    List<Todolist> find(Query query);

    Todolist findOneAndModify(Query Query, Update update);

    void deleteOne(Query Query);

    List<Todolist> findAll();
}
