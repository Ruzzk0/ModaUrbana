
package Conexion;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;


/**
 *
 * @author Ruzzky
 */
public class MongoDBconexion {

  private static MongoDatabase instancia;


    public static MongoDatabase getInstance() {
        if (instancia == null) {
            CodecRegistry co = fromRegistries(
            MongoClientSettings.getDefaultCodecRegistry(),
            fromProviders(PojoCodecProvider.builder().automatic(true).build()));
            MongoClientSettings setting = MongoClientSettings.builder().codecRegistry(co).build();
            MongoClient conexion = MongoClients.create(setting);
            instancia = conexion.getDatabase("ModaUrbana");
        }
        return instancia;
    }
}
