package com.example.Todolist.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Calendar;
import java.util.Date;

@Document(collection = "todolist")
public class Todolist {
    @Id
    //id
    private String id;
    //tên công việc
    private String title;
    //mô tả công việc
    private String description;
    //thời gian tạo
    private Date createTime;
    //thời gian update cuối cùng
    private Date lastModified;
    //trọng số của công việc
    private long score;
    //thuộc tính cho biết công việc đã đc check chưa
    private boolean check;

    //getter
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public long getScore() {
        return score;
    }

    public boolean getCheck() {
        return check;
    }

    //setter
    public void setId(String id) {
        this.id = id;
        Calendar calendar = Calendar.getInstance();
        this.lastModified = calendar.getTime();
    }

    public void setTitle(String title) {
        this.title = title;
        Calendar calendar = Calendar.getInstance();
        this.lastModified = calendar.getTime();
    }

    public void setDescription(String description) {
        this.description = description;
        Calendar calendar = Calendar.getInstance();
        this.lastModified = calendar.getTime();
    }

    public void setScore(long score) {
        this.score = score;
        Calendar calendar = Calendar.getInstance();
        this.lastModified = calendar.getTime();
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    //contructor
    public Todolist() {
        //Nó được dùng để lấy calendar sử dụng time zone và locale mặc định
        Calendar calendar = Calendar.getInstance();
        //Lấy thời gian tạo
        this.createTime = calendar.getTime();
        //Lấy thời gian chỉnh sửa
        this.lastModified = this.createTime;
    }

    //contructor co tham so
    public Todolist(String title, String description, long score, boolean check) {
        this.title = title;
        this.description = description;
        this.score = score;
        //Nó được dùng để lấy calendar sử dụng time zone và locale mặc định
        Calendar calendar = Calendar.getInstance();
        //lấy thời gian tạo
        this.createTime = calendar.getTime();
        //Lấy thời gian chỉnh sửa
        this.lastModified = this.createTime;
        this.check = check;
    }

    //contructor co tham so
    public Todolist(Todolist job) {
        this.title = job.getTitle();
        this.description = job.getDescription();
        this.score = job.getScore();
        Calendar calendar = Calendar.getInstance();
        this.createTime = calendar.getTime();
        this.lastModified = this.createTime;
        this.check = job.getCheck();
    }
    //doi thanh chuoi
    @Override
    public String toString() {
        return "Todolist{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", lastModified=" + lastModified +
                ", score=" + score +
                ", check=" + check +
                '}';
    }
}
