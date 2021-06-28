package nbd.riak.s10523riak;

import com.basho.riak.client.api.RiakClient;
import com.basho.riak.client.api.commands.kv.DeleteValue;
import com.basho.riak.client.api.commands.kv.FetchValue;
import com.basho.riak.client.api.commands.kv.StoreValue;
import com.basho.riak.client.core.RiakCluster;
import com.basho.riak.client.core.RiakNode;
import com.basho.riak.client.core.query.Location;
import com.basho.riak.client.core.query.Namespace;
import com.basho.riak.client.core.query.RiakObject;
import com.basho.riak.client.core.util.BinaryValue;

import java.util.concurrent.ExecutionException;

public class S10523RiakApplication {

    private static final String REMOTE_ADDRESS = "127.0.0.1";

    private static final int PORT = 8087;

    private static final Namespace bucket = new Namespace("s10523");

    private static final Location objectKey = new Location(bucket, "Alatreon");

    private static RiakClient client;

    private static RiakCluster cluster;

    public static void main (String[] args) throws Exception {
        try {
            startClient();
            System.out.println("Create response " + create(objectKey, "{'species':'Elder Dragon'}"));
            System.out.println("Po create " + read(objectKey));
            System.out.println("Update response " + update(objectKey, "{'species':'Elder Dragon','location':'Secluded Valley'}"));
            System.out.println("Po update " + read(objectKey));
            delete(objectKey);
            System.out.println("Po delete " + read(objectKey));
        } catch (Exception e) {
            throw e;
        } finally {
            shutdownClient();
        }
    }
    private static void shutdownClient () {
        if (cluster != null) cluster.shutdown();
    }
    private static void delete (Location key) throws ExecutionException, InterruptedException {
        client.execute(new DeleteValue.Builder(key).build());
    }
    private static void startClient () {
        RiakNode node = new RiakNode.Builder()
                .withRemoteAddress(REMOTE_ADDRESS)
                .withRemotePort(PORT)
                .build();
        cluster = new RiakCluster.Builder(node).build();
        client = new RiakClient(cluster);
        cluster.start();
    }
    private static StoreValue.Response update (Location key, String newValue) throws ExecutionException, InterruptedException {
        RiakObject updateObject = new RiakObject()
                .setContentType("application/json")
                .setValue(BinaryValue.create(newValue));
        StoreValue updateOp = new StoreValue.Builder(updateObject)
                .withLocation(key)
                .build();
        return client.execute(updateOp);
    }
    private static RiakObject read (Location key) throws ExecutionException, InterruptedException {
        FetchValue fetchOp = new FetchValue.Builder(key).build();
        RiakObject fetchedObject = client.execute(fetchOp).getValue(RiakObject.class);
        return fetchedObject;
    }
    private static StoreValue.Response create (Location klucz, String value) throws ExecutionException, InterruptedException {
        RiakObject newObject = new RiakObject()
                .setContentType("application/json")
                .setValue(BinaryValue.create(value));
        StoreValue createOperation = new StoreValue.Builder(newObject)
                .withLocation(klucz)
                .build();
        System.out.println("Saved object with key: " + klucz.getKeyAsString() + "and value: " + value);
        return client.execute(createOperation);
    }

}
