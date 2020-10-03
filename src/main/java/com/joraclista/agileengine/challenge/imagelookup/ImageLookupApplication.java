package com.joraclista.agileengine.challenge.imagelookup;

import com.joraclista.agileengine.challenge.imagelookup.http.ImagesHttpClient;
import com.joraclista.agileengine.challenge.imagelookup.model.Auth;
import com.joraclista.agileengine.challenge.imagelookup.model.Image;
import com.joraclista.agileengine.challenge.imagelookup.model.PageOfImages;
import com.joraclista.agileengine.challenge.imagelookup.repository.ImageRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

import static com.joraclista.agileengine.challenge.imagelookup.ImageDigest.getImageDigest;
import static com.joraclista.agileengine.challenge.imagelookup.http.HttpHelper.getBasicRequestWithBody;
import static com.joraclista.agileengine.challenge.imagelookup.http.HttpHelper.getRestTemplate;

@SpringBootApplication
@Slf4j
public class ImageLookupApplication implements ApplicationRunner {
    private static final String API_URL = "http://interview.agileengine.com";
    private static final String API_KEY = "23567b218376f79d9415";

    @Autowired
    private ImageRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(ImageLookupApplication.class, args);
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("run:");

        Map<String, Image> imagesMap = new HashMap<>();
        Map<String, String> imageDigestToIdMap = new HashMap<>();

        Auth auth = getRestTemplate().postForObject(
                API_URL + "/auth",
                getBasicRequestWithBody(Map.of("apiKey", API_KEY)),
                Auth.class);

        ImagesHttpClient imagesHttpClient = new ImagesHttpClient(auth, API_URL);
        if (auth.isAuth()) {
            int currentPage = 1;
            boolean hasMorePages = true;

            while (hasMorePages) {
                log.info("currentPage:" + currentPage);
                PageOfImages page = imagesHttpClient.getNextPage(auth, currentPage);
                hasMorePages = page.isHasMore();
                for(Image imageDesc : page.getPictures()) {
                    Image fullImageInfo = imagesHttpClient.getImageInfo(auth, imageDesc.getId());
                    imagesMap.put(imageDesc.getId(), fullImageInfo);
                    imageDigestToIdMap.put(getImageDigest(fullImageInfo), imageDesc.getId());
                }
                currentPage++;
            }

        }
        repository.setImagesMap(imagesMap);
        repository.setImagesDigestMap(imageDigestToIdMap);
    }

}
