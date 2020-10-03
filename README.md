# image-lookup-challenge
Image Lookup Challenge for Agile Engine Interview

### Project description

SpringBoot app to load images info from specific [endpoint](http://interview.agileengine.com/images)

and provide search of imagies by tags/author or some other metadata via endpoint GET /search/${searchTerm}


### Run
Run as a springboot app from IDE, main class is ImageLookupApplication

Search endpoint: http://localhost:8081/api/search/${searchTerm}

### Model
Image, PageOfImages - are used as abstractions for image information got from /images/${id} and /images?page=${number} endpoints respectively

### Search by term
Implemented in SearchImagesController - a controller providing /search/${searchTerm} endpoint

## Algorithm
