# Flicks
"Flicks" shows the latest movies currently playing in theaters. The app utilizes the Movie Database API to display images and basic information about these movies to the user.

Time spent: 16 hours spent in total

The following functionality is completed:
* [X] User can **scroll through current movies** from the Movie Database API
* [X] Layout is optimized with the [ViewHolder](http://guides.codepath.com/android/Using-an-ArrayAdapter-with-ListView#improving-performance-with-the-viewholder-pattern) pattern.
* [X] For each movie displayed, user can see the following details:
    * [X]  Title, Poster Image, Overview (Portrait mode)
    * [X]  Title, Backdrop Image, Overview (Landscape mode)
    
The following features are implemented:

* [X] Display a nice default [placeholder graphic](http://guides.codepath.com/android/Displaying-Images-with-the-Picasso-Library#configuring-picasso) for each image during loading.
* [X] Allow user to view details of the movie including ratings and popularity within a separate activity or dialog fragment.
* [X] When viewing a popular movie (i.e. a movie voted for more than 5 stars) the video should show the full backdrop image as the layout.   [Heterogenous RecyclerView](http://guides.codepath.com/android/Heterogenous-Layouts-inside-RecyclerView) to show different layouts.
* [X] Allow video trailers to be played in full-screen using the YouTubePlayerView.
    * [x] Overlay a play icon for videos that can be played.
    * [x] More popular movies should start a separate activity that plays the video immediately.
    * [x] Less popular videos rely on the detail page should show ratings and a YouTube preview.
* [X] Apply rounded corners for the poster or background images using [Picasso transformations](https://guides.codepath.com/android/Displaying-Images-with-the-Picasso-Library#other-transformations)

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<a href="https://imgflip.com/gif/24pe89"><img src="https://i.imgflip.com/24pe89.gif" title="made at imgflip.com"/></a>  
<a href="https://imgflip.com/gif/24peu9"><img src="https://i.imgflip.com/24peu9.gif" title="made at imgflip.com"/></a>

GIF created with [LiceCap](http://www.cockos.com/licecap/).


## Open-source libraries used

- [Android Async HTTP](https://github.com/loopj/android-async-http) - Simple asynchronous HTTP requests with JSON parsing
- [Picasso](http://square.github.io/picasso/) - Image loading and caching library for Android
