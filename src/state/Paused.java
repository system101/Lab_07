package state;

/**
 * Paused.java
 *
 * This file represents the Paused state.
 */
public class Paused implements State {

    private RemoteDevice remote;

    public Paused(RemoteDevice remote) {
        this.remote = remote;
    }

    // the Play button is pressed
    public boolean pressPlay() {
        if (remote.isLock()) {
            System.out.println("The remote is being locked.");
            return false;
        } else {
            System.out.println("The player is now playing.");
            remote.setState(remote.getPlayingState());
            remote.setPosition(remote.getPosition() + 1);

            return true;
        }
    }

    // the Pause button is pressed
    public boolean pressPause() {
        System.out.println("The player is already paused.");

        return false;
    }

    // the Stop button is pressed
    public boolean pressStop() {
        if (remote.isLock()) {
            System.out.println("The remote is being locked.");
            return false;
        } else {
            System.out.println("The player is now stopped.");
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
        if (remote.isLock()) {
            System.out.println("The remote is being locked.");
            return false;
        } else {
            System.out.println("The remote is NOW locked.");
            remote.setPrevState(this);
            remote.setIsLock(true);
            remote.setState(remote.getLockState());
            return true;
        }
    }

    @Override
    public String getState() {
        return "Pause";
    }
}
