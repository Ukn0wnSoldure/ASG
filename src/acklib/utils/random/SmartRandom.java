package acklib.utils.random;

import java.util.Random;

/**
 * Created by Aedan Smith on 5/13/2016.
 * 
 * A static Random class that has a few more useful functions.
 */

public class SmartRandom {

    private static Random random = new Random();

    private static boolean lastBoolean;
    private static int lastInt;
    private static float lastFloat;
    private static double lastDouble;
    private static long lastLong;
    private static double lastGaussian;

    /**
     * Resets the Random to reduce patterns in random generation.
     *
     * @return random: Returns the Random that random was set to.
     */
    public static Random resetRandom(){
        SmartRandom.setRandom(new Random());
        return SmartRandom.random;
    }

    /**
     * Sets the random to a given Random.
     *
     * @param random: The Random to set the random to.
     */
    public static void setRandom(Random random){
        SmartRandom.random = random;
    }

    /**
     * Sets the random's seed to the System's time in nanoseconds. Used to reduce
     * patterns in random generation.
     */
    public static void resetSeed(){
        SmartRandom.setSeed(System.nanoTime());
    }

    /**
     * Sets the random's seed to a given seed. Used to reduce patterns in random
     * generation.
     *
     * @param seed: The long to set the random's seed to.
     */
    public static void setSeed(long seed){
        SmartRandom.random.setSeed(seed);
    }

    /*
        All next<T> methods from the Random class, as well as a few new ones. Saves
        output to last<T>.
     */

    public static int nextInt(){
        SmartRandom.lastInt = random.nextInt();
        return SmartRandom.lastInt;
    }

    public static int nextInt(int max){
        SmartRandom.lastInt = random.nextInt(max);
        return SmartRandom.lastInt;
    }

    public static int nextInt(int min, int max){
        SmartRandom.lastInt = random.nextInt(max - min + 1) + min;
        return SmartRandom.lastInt;
    }

    public static boolean nextBoolean(){
        SmartRandom.lastBoolean = random.nextBoolean();
        return SmartRandom.lastBoolean;
    }

    public static double nextDouble(){
        SmartRandom.lastDouble = random.nextDouble();
        return SmartRandom.lastDouble;
    }

    public static double nextDouble(double max){
        SmartRandom.lastDouble = random.nextDouble() * max;
        return SmartRandom.lastDouble;
    }

    public static double nextDouble(double min, double max){
        SmartRandom.lastDouble = nextDouble(max - min) + min;
        return SmartRandom.lastDouble;
    }

    public static float nextFloat(){
        SmartRandom.lastFloat = random.nextFloat();
        return SmartRandom.lastFloat;
    }

    public static float nextFloat(float max){
        SmartRandom.lastFloat = random.nextFloat() * max;
        return SmartRandom.lastFloat;
    }

    public static float nextFloat(float min, float max){
        SmartRandom.lastFloat = nextFloat(max - min) + min;
        return SmartRandom.lastFloat;
    }

    public static long nextLong(){
        SmartRandom.lastLong = random.nextLong();
        return SmartRandom.lastLong;
    }

    public static long nextLong(long max) {
        long l = (long) (random.nextLong() * ((double)max/Long.MAX_VALUE) + 1);
        if (l < 0) l = -l;
        SmartRandom.lastLong = l;
        return SmartRandom.lastLong;
    }

    public static long nextLong(long min, long max){
        SmartRandom.lastLong = nextLong(max - min) + min;
        return SmartRandom.lastLong;
    }

    public static double nextGuassian(){
        SmartRandom.lastGaussian = random.nextGaussian();
        return SmartRandom.lastGaussian;
    }

    /*
        Gets last<T> generated by next<T>.
     */

    public static boolean getLastBoolean(){
        return lastBoolean;
    }

    public static int getLastInt() {
        return lastInt;
    }

    public static float getLastFloat() {
        return lastFloat;
    }

    public static double getLastDouble() {
        return lastDouble;
    }

    public static long getLastLong() {
        return lastLong;
    }

    public static double getLastGaussian() {
        return lastGaussian;
    }

    /*
        SmartRandom is a static class. Do not construct it.
     */
    private SmartRandom(){}
    
}
