package com.xxt.service.impl;

import com.xxt.dao.OrderDao;
import com.xxt.dto.OrderDTO;
import com.xxt.entities.OrderEntity;
import com.xxt.service.OrderService;
import io.minio.*;
import io.minio.errors.*;
import io.minio.http.Method;
import io.minio.messages.Item;
import org.springframework.beans.BeanUtils;

import javax.annotation.Resource;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author xk
 * @create 2021.08.05 10:20
 */
@org.apache.dubbo.config.annotation.Service
//@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Override
    public OrderDTO findById(Long id) {
        OrderEntity entity = orderDao.findById(id);
        if(entity == null){
            return null;
        }
        OrderDTO dto = new OrderDTO();
        BeanUtils.copyProperties(entity,dto);
        return dto;
    }

    @Override
    public String getPhoto(Long id) throws Exception {
        final String minioBucket = "order";

        // Initialize minio client object.
        MinioClient minioClient =
                MinioClient.builder()
                        .endpoint("http://localhost:9000")
                        .credentials("123456789", "987654321")
                        .build();

        boolean exists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(minioBucket).build());
        if(!exists){
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(minioBucket).build());
        }
        // List all objects.
        Iterable<Result<Item>> myObjects = minioClient.listObjects(ListObjectsArgs.builder().bucket(minioBucket).build());

        // Iterate over each elements and set album url.
        for (Result<Item> result : myObjects) {
            Item item = result.get();
            System.out.println(item.lastModified() + ", " + item.size() + ", " + item.objectName());

            String objectUrl = minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder().bucket(minioBucket).method(Method.GET).object(item.objectName()).build());// Set the presigned URL in the album object

            // Add the album object to the list holding Album objects
            if(objectUrl != null){
                return objectUrl;
            }
        }

        return null;
    }

    @Override
    public String uploadPhoto(Long id) {
        MinioClient minioClient =
                MinioClient.builder()
                        .endpoint("http://localhost:9000")
                        .credentials("123456789", "987654321")
                        .build();
        try {
            minioClient.putObject(PutObjectArgs.builder().build());
            ObjectWriteResponse objectWriteResponse = minioClient.uploadObject(UploadObjectArgs.builder().bucket("").filename("")
                    .object("").build());
            if(objectWriteResponse != null){

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
