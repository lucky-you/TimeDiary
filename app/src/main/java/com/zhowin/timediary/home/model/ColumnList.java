package com.zhowin.timediary.home.model;

/**
 * Created by : Z_B on 2019/7/28.
 * describe： 栏目分类
 */
public class ColumnList {

    private String columnId;

    private String columnName;

    private int columnType;


    public ColumnList(String columnName) {
        this.columnName = columnName;
    }

    public ColumnList(String columnName, int columnType) {
        this.columnName = columnName;
        this.columnType = columnType;
    }

    public String getColumnId() {
        return columnId;
    }

    public void setColumnId(String columnId) {
        this.columnId = columnId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public int getColumnType() {
        return columnType;
    }

    public void setColumnType(int columnType) {
        this.columnType = columnType;
    }
}
