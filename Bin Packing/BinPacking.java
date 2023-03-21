import java.util.Arrays;
import java.util.Random;

public class BinPacking {
    static int BINSIZE=100;
    int [] requests;
    BinPacking(int size){
        Random rand  = new Random(size); //Seed will cause the same sequence of numbers to be generated each test
        requests = new  int[size];
        for (int i=0; i < size; i++){
            requests[i] =rand.nextInt(BINSIZE)+1;
        }
        if (size <=500 ) System.out.println("Size " + size + " " +Arrays.toString(requests));
    }

    public void scheduleWorstFit() {
        LeftistHeap<Disk> leftistHeap = new LeftistHeap<>();
        var maxDiskSize = 100;
        var i = 0;
        for (int request: requests) {
            if (leftistHeap.isEmpty()) {
                var newDisk = new Disk(i, maxDiskSize);
                newDisk.add(request);
                leftistHeap.Insert(newDisk);
            } else if (leftistHeap.root.element.remainingSpace - request > 0) {
                leftistHeap.root.element.add(request);
            } else {
                var newDisk = new Disk(i, maxDiskSize);
                newDisk.add(request);
                leftistHeap.Insert(newDisk);
            }
        }
        i++;
    }

    public static void main (String[] args)
    {
       int [] fileSizes = {10, 20, 100, 500,10000,100000};
        for (int size :fileSizes){
            BinPacking b = new BinPacking(size);
            b.scheduleWorstFit();
            //b.scheduleOfflineWorstFit();
        }

    }}
