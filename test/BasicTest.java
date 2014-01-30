import org.junit.*;
import java.util.*;
import play.test.*;
import models.*;

public class BasicTest extends UnitTest {
    private Post Post;

    @Test
    public void aVeryImportantThingToTest() {
        assertEquals(2, 1 + 1);
    }

    @Test
    public void createAndRetrieveUser(){
    //crear un usuario y guardarlo
        User usuario = new User("sorely.falomir@gmail.com", "secret", "sorely", Boolean.FALSE);
        usuario.save();
        
        User usuarioTest = User.find("byEmail", "sorely").first();
        
        assertNotNull(usuarioTest);
        assertEquals("sorely", usuarioTest.fullName);
     
        
        Post post = new Post("un poste de demostracion", usuario, null);
        post.save();
    }
}
