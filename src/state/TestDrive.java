package state;

public class TestDrive {

    public static void main(String[] args) {

        // what about a singleton here???
//		RemoteDeviceV1 remote = new RemoteDeviceV1();
//		
//		remote.pressPlay();
//		
//		remote.pressPause();
//		
//		remote.pressStop();
//		
//		remote.pressPlay();
//		remote.pressPlay();
        RemoteDevice remote = new RemoteDevice();
//            remote.pressPlay();
//            remote.pressPause();
//            remote.pressStop();
//            remote.pressPlay();

//            remote.pressPlay();
//            remote.pressRewind();
//            remote.pressStop();
//            remote.pressStop();
//            remote.pressRewind();
//            remote.pressRewind();
//            remote.pressPlay();
        remote.pressPlay();
        remote.pressLock();
        remote.pressPause();
        remote.pressPlay();
        remote.pressRewind();
        remote.pressStop();
        remote.pressLock();
        remote.pressPause();
        remote.pressRewind();
        remote.pressStop();
        remote.pressRewind();
        remote.pressPlay();
        
        


    }

}
