package org.almansa.app.core.entity.board;

import java.util.Date;
import java.util.List;

public class DefaultTextBoard implements Board {

    private Long id;
    private String name;
    private Date creationDate;
    private List<String> categories;
    private boolean isAbleToWrite;

    public DefaultTextBoard(Long id, String name, Date creationDate, List<String> categories, boolean isAbleToWrite) {
        super();
        this.id = id;
        this.name = name;
        this.creationDate = creationDate;
        this.categories = categories;
        this.isAbleToWrite = isAbleToWrite;
    }

    public DefaultTextBoard(String name, Date creationDate, List<String> categories, boolean isAbleToWrite) {
        super();
        this.name = name;
        this.creationDate = creationDate;
        this.categories = categories;
        this.isAbleToWrite = isAbleToWrite;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public void changeName(String newName) {
        this.name = newName;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setCreationDate(Date creationTime) {
        this.creationDate = creationTime;
    }

    @Override
    public Date getCreationDate() {
        return creationDate;
    }

    @Override
    public List<String> getCategories() {
        return categories;
    }

    @Override
    public boolean isAbleToWrite() {
        return isAbleToWrite;
    }

    @Override
    public void blockToWrite() {
        this.isAbleToWrite = false;
    }

    @Override
    public void allowToWrite() {
        this.isAbleToWrite = true;
    }

    @Override
    public String toString() {
        return "DefaultTextBoard [id=" + id + ", name=" + name + ", creationDate=" + creationDate + ", categories="
                + categories + ", isAbleToWrite=" + isAbleToWrite + "]";
    }
}