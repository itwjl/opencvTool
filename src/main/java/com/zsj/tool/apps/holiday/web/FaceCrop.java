package com.zsj.tool.apps.holiday.web;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.objdetect.CascadeClassifier;

/**
 *
 * @author 王敬磊
 * @email it_wjl@163.com
 * @date 2020年4月16日
 */
public class FaceCrop {
    public static double calcArea(Rect rect){
        return rect.width * rect.height;
    }
    public static String xmlfilePath = "F:\\zax\\openTool\\src\\main\\resources\\haarcascade_frontalface_alt.xml";
    public static void faceCrop(String inputImageFilename, String outputImageFilename){
        CascadeClassifier faceDetector = new CascadeClassifier(xmlfilePath);
        Mat image = Imgcodecs.imread(inputImageFilename);
        // 检测人脸
        // MatOfRect是矩形容器
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections);
        // 找出最大的一张人脸
        Rect maxRect = new Rect(0,0,0,0);
        for (Rect rect : faceDetections.toArray()) {
            if (calcArea(maxRect) < calcArea(rect)){
                maxRect=rect;
            }
        }
        if (calcArea(maxRect) > 0){
            // 创建人脸拷贝区域
            Mat roi_img = new Mat(image, maxRect);
            // 创建临时的人脸拷贝图形
            Mat tmp_img = new Mat();
            // 人脸拷贝
            roi_img.copyTo(tmp_img);
            // 保存最大的一张人脸
            Imgcodecs.imwrite(outputImageFilename, tmp_img);
        }
    }
}
