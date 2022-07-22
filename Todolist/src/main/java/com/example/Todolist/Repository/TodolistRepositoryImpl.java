package com.example.Todolist.Repository;

import com.example.Todolist.Model.Todolist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TodolistRepositoryImpl implements ITodolistRepository{

    @Autowired
    private MongoTemplate mongoTemplate;

    //luu 1 todolist lai
    @Override
    public Todolist save(Todolist todolist) {
        //lữu 1todolist lại
        return this.mongoTemplate.save(todolist);
    }

    //tim 1 todolist thoa man dkien
    @Override
    public Todolist findOne(Query query) {
        //tìm ra 1 todolist trong dữ liệu thỏa mãn điều kiện
        return this.mongoTemplate.findOne(query,Todolist.class);
    }

    //tim nhung todolist thoa man dkien
    @Override
    public List<Todolist> find(Query query) {
        //tìm ra tất cả các todolist thỏa mãn đkiện
        return this.mongoTemplate.find(query, Todolist.class);
    }
    //tim va sua 1 todolist thoa man dkien
    @Override
    public Todolist findOneAndModify(Query query, Update update) {
        return this.mongoTemplate.findAndModify(query,update,Todolist.class);
    }

    //xóa 1 todolist
    @Override
    public void deleteOne(Query query) {
        this.mongoTemplate.findAndRemove(query,Todolist.class);
    }

    //Tìm kiếm todolist
    @Override
    public List<Todolist> findAll() {
        return this.mongoTemplate.findAll(Todolist.class);
    }
}
