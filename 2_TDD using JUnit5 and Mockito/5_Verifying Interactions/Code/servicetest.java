import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
public class servicetest {
            @Test
	    public void testVerifyInteraction() {
	         ExternalApi mockApi = mock(ExternalApi.class);
                    MyService service = new MyService(mockApi);
                   service.fetchData();
                  verify(mockApi).getData();
	    }
        }
