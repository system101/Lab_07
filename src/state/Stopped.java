package state;

/**
 * Stopped.java
 *
 * This file represents the Stopped state.
 */
public class Stopped implements State {

    private RemoteDevice remote;

    public Stopped(RemoteDevice remote) {
        this.remote = remote;
    }

    // the Play button is pressed
    public boolean pressPlay() {
        System.out.println("The player is now playing.");
        remote.setState(remote.getPlayingState());
        remote.setPosition(remote.getPosition() + 1);

        return true;
    }

    // the Paused button is pressed
    public boolean pressPause() {
        System.out.println("The player is now paused.");
        remote.setState(remote.getPausedState());

        return true;
    }

    // the  Stop button is pressed
    public boolean pressStop() {
        System.out.println("The player is already stopped.");

        return false;
    }

    @Override
    public boolean pressRewind() {
        if (remote.isLock()) {
            System.out.println("The remote is being locked.");
            return false;
        } else {
            System.out.println("The player is now rewinded.");
            remote.setState(remote.getRewindState());
            remote.setPosition(0);
            return true;
        }
    }

    @Override
    public boolean pressLock() {
        if(remote.isLock()){
            System.out.println("The remote is being locked.");
            return false;
        }
        else{
            System.out.println("The remote is NOW locked.");
            remote.setIsLock(true);
            remote.setPrevState(this);
            remote.setState(remote.getLockState());
            return true;
        } 
    }

    @Override
    public String getState() {
        return "Stop";
    }

}
