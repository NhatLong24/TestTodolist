package com.example.Todolist.Service;

import com.example.Todolist.Model.Todolist;
import com.example.Todolist.Repository.ITodolistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class TodolistService implements ITodolistService{

    @Autowired
    private ITodolistRepository iTodolistRepository;
    //add 1 todolist
    @Override
    public Todolist addTodolist(Todolist todolist) {
        if(todolist!=null)
        {
            //lưu lại thời gian tạo
            Update update = new Update();

            //tóm lấy mốc lời gian đang chỉnh
            Calendar calendar = Calendar.getInstance();
            Date t = calendar.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

            update.set("createTime", sdf.format(t));
            //Lưu nó lại
            return this.iTodolistRepository.save(todolist);

        } else {
            return null;
        }

    }
    //update 1 todolist
    @Override
    public Todolist updateTodolist(Todolist todolist) {
        if(todolist!=null)
        {
            //Tạo điện kiện update
            Query query = new Query();
            //với đkiện id = id của todolist mới truyền
            query.addCriteria(Criteria.where("id").is(todolist.getId()));
            //Tạo 1 update để lấy giá trị ta muốn truyền
            Update update = new Update();
            update.set("title", todolist.getTitle());
            update.set("description", todolist.getDescription());
            update.set("score", todolist.getScore());
            update.set("check", todolist.getCheck());
            update.set("createTime", todolist.getCreateTime());

            //tóm lấy mốc lời gian đang chỉnh
            Calendar calendar = Calendar.getInstance();
            Date t = calendar.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

            update.set("lastModified", sdf.format(t));
            //tìm kiếm với điều kiện đã nêu trên + update lại nội dung đã chỉ định
            return this.iTodolistRepository.findOneAndModify(query, update);
        } else {
            return null;
        }
    }
    //delete 1 todolist
    @Override
    public void deleteTodolist(Todolist todolist) {
        //tạo truy vấn
        Query query = new Query();
        //truy vấn với điều kiện = id của todolist đã truyền
        query.addCriteria(Criteria.where("id").is(todolist.getId()));
        //xóa nó ra
        this.iTodolistRepository.deleteOne(query);
    }
    //tim 1 todolist thoa man
    @Override
    public List<Todolist> findTodolist(int limit, long min, long max, boolean check) {
        Query query = new Query();
        Criteria criteria = new Criteria();

        //dieu kien truy van, lon hon "min" nho hon "max" , bang voi trang thai "check"
        criteria.andOperator(Criteria.where("score").gte(min),
                Criteria.where("score").lte(max),
                Criteria.where("check").is(check));
        
        //so luong ban ghi toi da tra ve
        query.addCriteria(criteria)
                .with(PageRequest.of(0, limit))
                .with(Sort.by(Sort.Direction.DESC, "score"));
        return this.iTodolistRepository.find(query);
    }
}
