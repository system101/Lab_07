package state;

/**
 * Playing.java
 *
 * This file represents the Playing state
 */
public class Playing implements State {

    private RemoteDevice remote;

    public Playing(RemoteDevice remote) {
        this.remote = remote;
    }

    // the Play button is pressed
    public boolean pressPlay() {
        System.out.println("The player is already playing.");

        return false;
    }

    // the Pause button is pressed
    public boolean pressPause() {
        if (remote.isLock()) {
            System.out.println("The remote is being locked.");
            return false;
        } else {
            System.out.println("The player is paused.");
            remote.setState(remote.getPausedState());

            return true;
        }
    }

    // the Stop button is pressed
    public boolean pressStop() {
        if (remote.isLock()) {
            System.out.println("The remote is being locked.");
            return false;
        } else {
            System.out.println("The player is stopped.");
            remote.setState(remote.getStoppedState());
            remote.setPosition(0);

            return true;
        }
    }

    @Override
    public boolean pressRewind() {
        if (remote.isLock()) {
            System.out.println("The remote is being locked.");
            return false;
        } else {
            System.out.println("Idle. . .");

            return false;
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
            remote.setPrevState(this);
            remote.setIsLock(true);
            remote.setState(remote.getLockState());
            return true;
        } 
    }

    @Override
    public String getState() {
        return "Play";
    }

}
