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

### Search Algorithm
As I had only 2 hours for implementation I decided not to use any databases including in-menory as I know it will take a lot much time to implement search.
Thus I used just a java hash map (which can be changed to HazelCast impl) which is ok for the 2-hrs pet project.

To search images I created hashmap with IMAGE DIGEST information as a key and image id as a value.

Image digest is just a string with all image metadata : author + camera + tags + id.

Thus when user searchs by search term, keys are filtered (ignorecase) by this search term and then mapped to original image info.
That's it. 
I know that for searches like that companies like booking com and etc implement precomputed searches/n-grams and so on.

Thanks for the challenge and Have a nice day!
