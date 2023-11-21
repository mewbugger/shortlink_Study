import com.wly.shortlinkStudy.project.ShortLinkStudyProjectApplication;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RBloomFilter;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShortLinkStudyProjectApplication.class)
public class ShortLinkStudyProjectApplicationTest {

    @Resource
    private RBloomFilter<String> shortUriCreateCachePenetrationBloomFilter;

    @Test
    public void testBloomFilter() {
        System.out.println(shortUriCreateCachePenetrationBloomFilter.contains("http://baidu.com/3UtOXE"));
    }
}
