package com.fiberhome.gmall.manage.util;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author ATan147
 * @create 2020-08-26 22:40
 */
public class PmsUploadUtil {
    public static String uploadImage(MultipartFile multipartFile) {
        String imgUrl = "";
        String path = PmsUploadUtil.class.getResource("/tracker.conf").getPath();
        try {
            ClientGlobal.init(path);
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getTrackerServer();
            StorageClient storageClient = new StorageClient(trackerServer, null);

            byte[] bytes = multipartFile.getBytes();
            String originalFilename = multipartFile.getOriginalFilename();
            int i = originalFilename.lastIndexOf(".");
            String extName = originalFilename.substring(i + 1);
            String[] pngs = storageClient.upload_file(bytes, extName, null);
            imgUrl = "http://114.55.253.242";
            for (String png : pngs) {
                imgUrl += "/" + png;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }

        return imgUrl;
    }
}
