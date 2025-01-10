package org.example.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@EqualsAndHashCode
@Getter
@Setter
@Entity
@Table(name = "files")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "file_name" )
    private String fileName;
    @Column(name = "file_path")
    private String filePath;

    public File() {

    }

    public File(String fileName, String filePath){
        this.id = id;
        this.fileName = fileName;
        this.filePath = filePath;

    }

    public File(int i, String name2, String path2) {
    }

    @Override
    public String toString() {
        return "{" + "\"id\":" + id +
                ", \"fileName\":" + "\"" + fileName + "\"" +
                ", \"filePath\":" + "\"" + filePath + "\"" +
                "}";
    }

    public Integer getId() {
        return id;
    }

    public void setFileName(String fileName) {
    }

    public void setFilePath(String s) {
    }
}





       