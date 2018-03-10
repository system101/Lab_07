/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package state;

/**
 *
 * @author Jimmy Salami
 */
public class Rewind implements State {

    private RemoteDevice remote;

    public Rewind(RemoteDevice remote) {
        this.remote = remote;
    }

    @Override
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

    @Override
    public boolean pressPause() {
        if (remote.isLock()) {
            System.out.println("The remote is being locked.");
            return false;
        } else {
            System.out.println("The player is now paused.");
            remote.setState(remote.getPausedState());

            return true;
        }
    }

    @Override
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
            System.out.println("The player is already rewinded.");

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
            remote.setIsLock(true);
            remote.setPrevState(this);
            remote.setState(remote.getLockState());
            return true;
        } 
    }

    @Override
    public String getState() {
        return "Rewind";
    }

}
