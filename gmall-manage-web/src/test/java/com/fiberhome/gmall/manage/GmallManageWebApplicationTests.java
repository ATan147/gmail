package com.fiberhome.gmall.manage;

import org.csource.common.MyException;
import org.csource.fastdfs.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GmallManageWebApplicationTests {


    @Test
    public void contextLoads() throws IOException, MyException {
        String path = GmallManageWebApplicationTests.class.getResource("/tracker.conf").getPath();
        ClientGlobal.init(path);
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getTrackerServer();
        StorageClient storageClient = new StorageClient(trackerServer, null);
        String[] pngs = storageClient.upload_file("d:/2020.png", "png", null);
        String url = "http://114.55.253.242";
        for (String png : pngs) {
            url += "/" + png;
        }
        System.out.println(url);
    }
}
