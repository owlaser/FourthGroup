package com.example.springboot.service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.example.springboot.domain.Osc;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;


@Service
public class DownloadPackage {

    public static void downloadFile(String url, String dir) throws IOException {
        URL httpurl = new URL(url);
        File f =new File(dir );
        FileUtils.copyURLToFile(httpurl, f);

    }

    public static Osc downloadPackage(String groupId, String artifactId, String version) throws IOException {
        String [] urls={"https://mirrors.huaweicloud.com/repository/maven/","https://repo1.maven.org/maven2/",
                "https://repo.spring.io/libs-release/+groupID","https://repo.grails.org/grails/gradle-plugins-repo-cache/"};
        String filePath ="null";
        String name = "null";
        for(String url : urls) {
            for (String s : groupId.split("\\.")) {
                url = url + s + "/";
            }
            url = url + artifactId + "/" + version + "/" + artifactId + "-" + version + ".jar";
            System.out.println(url);
            //System.out.println("fileName---->"+filePath);
            filePath = ".\\" + groupId + "\\" + artifactId + "\\" + artifactId + "-" + version + ".jar";
            name = artifactId + "-" + version + ".jar";
            try {
                downloadFile(url, filePath);
//                System.out.println("successful");
//                return filePath;
                return new Osc(name,filePath,groupId,artifactId,version);
            } catch (FileNotFoundException e) {
                System.out.println("FileNotFound");
            }
        }
//        System.out.println("Failed");
//        return filePath;
        return new Osc("null","null","null","null","null");
    }
//    public static void main(String[] args) throws Exception {
//        downloadPackage("org.hibernate12", "hibernate-osgi", "5.4.9.Final");
//    }
}
