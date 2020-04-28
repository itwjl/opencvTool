import com.zsj.tool.apps.holiday.web.Face;

import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        Face face = new Face();
        try {
            face.FaceDetector(null, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
