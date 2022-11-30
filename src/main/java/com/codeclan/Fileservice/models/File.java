package com.codeclan.Fileservice.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="files")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "extension")
    private String extension;
    @Column(name = "size")
    private String size;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @ManyToMany
    @JsonBackReference
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(
            name = "files_folders",
            joinColumns = {@JoinColumn(
                    name = "file_id",
                    nullable = false,
                    updatable = false
            )

            },
            inverseJoinColumns = {@JoinColumn(
                    name = "folder_id",
                    nullable = false,
                    updatable = false
            )

            }
    )
    private List<Folder> folders;

    public File(String name, String extension, String size, Person person) {
        this.name = name;
        this.extension = extension;
        this.size = size;
        this.person = person;
        this.folders = new ArrayList<Folder>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<Folder> getFolders() {
        return folders;
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }

    public void addFolder(Folder folder){
        this.folders.add(folder);
    }
}

