package service.generator;

/**
 * Created by vlad on 19.11.15.
 */
public class Generator {

    public static int genInt(int min, int max) {
        return min + (int) (Math.random() * (max - min));
    }

    public static float genFloat(float min, float max) {
        return min + (float) (Math.random() * (max - min));
    }

}
