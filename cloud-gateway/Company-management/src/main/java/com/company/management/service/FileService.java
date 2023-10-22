/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.company.management.service;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class FileService {


   
    public String uploadImage(String path, MultipartFile file) {
        //File name
        String name = file.getOriginalFilename();

        //File Path
        String filePath = path + File.separator + name;

        //Create folder if not created
        File f = new File(path);
        if (!f.exists()) {
            f.mkdir();
        }
        try {
            //file copy
            Files.copy(file.getInputStream(), Paths.get(filePath));
        } catch (Exception e) {
            e.printStackTrace();
        }


        return name;
    }
}
