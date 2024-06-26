package de.spookly.haunted.scheduler;

public abstract class HauntedTask {

    /**
     * -1 means no repeating <br>
     * -2 means cancel <br>
     * -3 means processing for Future <br>
     * -4 means done for Future <br>
     * Never 0 <br>
     * >0 means number of ticks to wait between each execution
     */
    private volatile long period;
    private long nextRun;
    private final Runnable rTask;
    private final int id;

    protected HauntedTask(Runnable rTask, int id) {
        this.rTask = rTask;
        this.id = id;
    }
}
