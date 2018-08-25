package main;

public abstract class Loop {

    private boolean runFlag = false;
    private static double initDelta;

    /**
     * Begin the game loop
     *
     * @param delta time between logic updates (in seconds)
     */
    public void run(double delta) {
        runFlag = true;
        initDelta = delta;

        startup();
        // convert the time to seconds
        double nextTime = (double) System.nanoTime() / 1000000000.0;
        double maxTimeDiff = 0.5;
        int skippedFrames = 1;
        int maxSkippedFrames = 5;
        while (runFlag) {
            // convert the time to seconds
            double curTime = (double) System.nanoTime() / 1000000000.0;
            if ((curTime - nextTime) > maxTimeDiff) {
                nextTime = curTime;
            }
            if (curTime >= nextTime) {
                // assign the time for the next update
                nextTime += delta;
                update();
                if ((curTime < nextTime) || (skippedFrames > maxSkippedFrames)) {
                    render();
                    skippedFrames = 1;
                } else {
                    skippedFrames++;
                }
            } else {
                // calculate the time to sleep
                int sleepTime = (int) (1000.0 * (nextTime - curTime));
                // sanity check
                if (sleepTime > 0) {
                    // sleep until the next update
                    try {
                        Thread.sleep(sleepTime);
                    } catch (InterruptedException e) {
                        // do nothing
                    }
                }
            }
        }
        shutdown();
    }
    
    /**
     * Is called to close the program
     */
    public void stop() {
        runFlag = false;
    }
    
    public static double getDelta() {return initDelta;}

    public abstract void startup();
    public abstract void shutdown();
    public abstract void update();
    public abstract void render();
}
