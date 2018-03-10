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
public class Lock implements State{
    private RemoteDevice remote;

    public Lock(RemoteDevice remote) {
        this.remote = remote;
    }

    @Override
    public boolean pressPlay() {
        System.out.println("The remote is being locked.");

        return false;
    }

    @Override
    public boolean pressPause() {
        System.out.println("The remote is being locked.");

        return false;
    }

    @Override
    public boolean pressStop() {
        System.out.println("The remote is being locked.");

        return false;
    }

    @Override
    public boolean pressRewind() {
        System.out.println("The remote is being locked.");

        return false;
    }

    @Override
    public boolean pressLock() {
        if(remote.isLock()){
            System.out.println("Unlocked..");
            remote.setIsLock(false);
            remote.setState(remote.getPrevState());
            return true;
        }
        else{
            remote.setIsLock(true);
            return false;
        }
    }

    @Override
    public String getState() {
        return "Lock";
    }
}
