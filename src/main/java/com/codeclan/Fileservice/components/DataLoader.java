package com.codeclan.Fileservice.components;

import com.codeclan.Fileservice.models.File;
import com.codeclan.Fileservice.models.Folder;
import com.codeclan.Fileservice.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("!test")
@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    FileRepository fileRepository;
    @Autowired
    FolderRepository folderRepository;
    @Autowired
    PersonRepository personRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {

        Person john = new Person("john");

        Folder main = new Folder("main", john );

        File report = new File("report", "xl", "large", main );
    }
}
