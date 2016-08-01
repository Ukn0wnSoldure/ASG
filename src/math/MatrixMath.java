package math;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector2f;

import java.awt.geom.Point2D;

/**
 * Created by Aedan Smith on 7/5/2016.
 */

public final class MatrixMath {

    /**
     * Creates a Transformation Matrix for an image at (0, 0).
     *
     * @param translation: The amount to translate the image using the OpenGL Coordinate System.
     * @param scale: TODO: Fix Scale.
     * @return Matrix4f: The matrix that translates an image at (0, 0) to the correct position.
     */
    public static Matrix4f createTransformationMatrix(Point2D.Float translation, float scale){
        Matrix4f matrix4f = new Matrix4f();
        matrix4f.setIdentity();
        Matrix4f.translate(new Vector2f(translation.x, translation.y), matrix4f, matrix4f);
//        Matrix4f.scale(new Vector3f(scale,scale,scale), matrix4f, matrix4f);
        return matrix4f;
    }

}
