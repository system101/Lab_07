package state;

/**
 * RemoteDevice.java
 *
 * This is the device that we are controlling with the State pattern.
 */
public class RemoteDevice {
    // the different states the device may be in

    private State playing;
    private State paused;
    private State stopped;
    private State rewind;
    private State locked;
    private State prevState;
    private boolean isLock = false;

    public boolean isLock() {
        return isLock;
    }

    public void setIsLock(boolean isLock) {
        this.isLock = isLock;
    }

    public State getPrevState() {
        return prevState;
    }

    public void setPrevState(State prevState) {
        this.prevState = prevState;
    }

    //the current state of the player
    private State currentState;

    /**
     * the current position of the media this may be 0 (the beginning of the
     * media) up to some int value representing the end of the media
     */
    private int currentPosition;

    // initialize the remote device	
    public RemoteDevice() {
        playing = new Playing(this);
        paused = new Paused(this);
        stopped = new Stopped(this);
        rewind = new Rewind(this);
        locked = new Lock(this);

        // initial state is stopped	
        currentState = stopped;

        // we are at the beginning of the media
        currentPosition = 0;
    }
    
    public State getCurrentState(){
        return currentState;
    }

    // set the state of the device	
    public void setState(State currentState) {
        this.currentState = currentState;
    }

    // set the position of the media	
    public void setPosition(int position) {
        currentPosition = position;
    }

    // get the current position of the media	
    public int getPosition() {
        return currentPosition;
    }

    // press the Play button	
    public void pressPlay() {
        currentState.pressPlay();
    }

    // press the Pause button	
    public void pressPause() {
        currentState.pressPause();
    }

    // press the Stop button	
    public void pressStop() {
        currentState.pressStop();
    }

    public void pressRewind() {
        currentState.pressRewind();
    }
    
    public void pressLock() {
        currentState.pressLock();
    }

    // return the playing state	
    public State getPlayingState() {
        return playing;
    }

    // return the paused state	
    public State getPausedState() {
        return paused;
    }

    // return the stopped state	
    public State getStoppedState() {
        return stopped;
    }

    public State getRewindState() {
        return rewind;
    }
    
    public State getLockState() {
        return locked;
    }
}
